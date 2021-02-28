const UserModel = firebase.auth();
const DB = firebase.firestore();


const router = Sammy('#root', function () {

    this.use('Handlebars', 'hbs');

    this.get('#/home', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const blogs = DB.collection('blog').get().then(function (result) {

            let blogs = [];
            result.forEach(function (doc) {
                blogs.push({ id: doc.id, ...doc.data() });
            });

            context.blogs = blogs;
            context.loadPartials({
                'header': '../templates/header.hbs',
                'post': '../templates/post.hbs'
            }).then(function () {
                this.partial('./templates/home.hbs');
            })
        });
    });

    this.get('#/login', function () {
        this.loadPartials({
            'header': '../templates/header.hbs'
        }).then(function () {
            this.partial('../templates/login.hbs');
        })
    });

    this.get('#/logout', function (context) {
        UserModel.signOut()
            .then((response) => {
                localStorage.removeItem('userInfo');
                context.redirect('#/home');
            }).catch((e) => console.log(e));
    });

    this.get('#/register', function () {
        this.loadPartials({
            'header': '../templates/header.hbs'
        }).then(function () {
            this.partial('../templates/register.hbs');
        })
    });

    this.get('#/edit/:id', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        this.loadPartials({
        'header': './templates/header.hbs'
    }).then(function () {
        let that = this;
        const shoe = DB.collection('blog').doc(context.params.id.slice(1));
        shoe.get().then(function (doc) {
            if (userInfo) {
                const { uid, email } = JSON.parse(userInfo);
                context.isLoggedIn = true;
                context.email = email;
            }

            context.isCreator = context.email == doc.data().creator;
            context.title = doc.data().title;
            context.category = doc.data().category;
            context.content = doc.data().content;
            context.id = context.params.id.slice(1);
            that.partial('./templates/edit.hbs');
        });
    });
});

    this.get('#/details/:id', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        this.loadPartials({
        'header': './templates/header.hbs'
    }).then(function () {
        let that = this;
        const shoe = DB.collection('blog').doc(context.params.id.slice(1));
        shoe.get().then(function (doc) {
            if (userInfo) {
                const { uid, email } = JSON.parse(userInfo);
                context.isLoggedIn = true;
                context.email = email;
            }

            context.isCreator = context.email == doc.data().creator;
            context.title = doc.data().title;
            context.category = doc.data().category;
            context.content = doc.data().content;
            context.id = context.params.id.slice(1);
            that.partial('./templates/details.hbs');
        });
    });
});

    this.post('#/edit/:id', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const { uid, email } = JSON.parse(userInfo);
        DB.collection('blog').doc(context.params.id.slice(1)).update({
            title: context.params.title,
            category: context.params.category,
            content: context.params.content,
        }).then(function () {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    }); 

    this.get('#/create', function () {
        this.loadPartials({
            'header': './templates/header.hbs',
            'createForm': './templates/createForm.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            this.partial('./templates/create/createPage.hbs');
        })
    });

    this.get('#/catalog', function (context) {
        context.hasNoTeam = true;
        const userInfo = localStorage.getItem('userInfo');
        const teamData = DB.collection('teams').get().then(function (result) {

            let teams = [];
            result.forEach(function (doc) {
                context.name = doc.data().name;
                context.comment = doc.data().comment;
                teams.push({ _id: doc.id, name: doc.data().name, comment: doc.data().comment });
            });
            if (teams.length > 0) {
                context.teams = teams;
                context.hasNoTeam = teams;
            }
            if (userInfo) {
                const { uid, email, isOnTeam } = JSON.parse(userInfo);
                context.loggedIn = true;
                context.email = email;
            }
            context.loadPartials({
                'header': './templates/header.hbs',
                'team': './templates/team.hbs'
            }).then(function () {
                this.partial('./templates/teamCatalog.hbs');
            })
        })


    });

    this.get('#/about', function (context) {
        const userInfo = localStorage.getItem('userInfo');

        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }

        loadPartials(context).then(function () {
            this.partial('./templates/about.hbs');
        })
    });

    this.post('#/register', function (context) {
        const { email, password, repeatPassword } = context.params;
        if (password !== repeatPassword) {
            return;
        }
        UserModel.createUserWithEmailAndPassword(email, password).then((createUser) => {
            this.redirect('#/login');
        }).catch((e) => console.log(e));
    });

    this.post('#/login', function (context) {

        const { email, password } = context.params;
        UserModel.signInWithEmailAndPassword(email, password)
            .then(({ user: { uid, email } }) => {
                let haveTeam = false;
                localStorage.setItem('userInfo', JSON.stringify({ uid, email, isOnTeam: haveTeam }));

                context.redirect('#/home');
            }).catch((e) => console.log(e));
    });

    this.post('#/create', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }
        const { uid, email } = JSON.parse(userInfo);
        DB.collection('blog').add({
            title: context.params.title,
            category: context.params.category,
            content: context.params.content,
            creator: email
        }).then(function (teamInfo) {
            localStorage.setItem('blog', teamInfo.id)
            context.redirect('#/home');
        }).catch((e) => console.log(e));
    });

    this.get('#/delete/:id', function (context) {
        const id = context.params.id.slice(1);
        DB.collection('blog').doc(id).delete().then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

});

(() => {
    router.run('#/home');
})();

function loadPartials(context) {
    return context.loadPartials({
        'header': './templates/header.hbs'
    })
}