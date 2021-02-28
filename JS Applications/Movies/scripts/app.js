const UserModel = firebase.auth();
const DB = firebase.firestore();


const router = Sammy('#container', function () {

    this.use('Handlebars', 'hbs');

    this.get('#/home', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const movies = DB.collection('movies').get().then(function (result) {

            let movies = [];
            result.forEach(function (doc) {
                movies.push({ id: doc.id, ...doc.data() });
            });

            context.movies = movies;
            context.loadPartials({
                'header': './templates/header.hbs',
                'info': './templates/info.hbs',
                'footer': './templates/footer.hbs'
            }).then(function (context) {
                this.partial('./templates/home.hbs');
            })
        });
    });

    this.get('#/login', function (context) {
        this.loadPartials({
            'header': '../templates/header.hbs',
            'footer': '../templates/footer.hbs'
        }).then(function () {
            this.partial('../templates/login.hbs');
        })
    });

    this.get('#/logout', function (context) {
        UserModel.signOut()
            .then((response) => {
                localStorage.removeItem('userInfo');
                context.redirect('#/home');
            }).catch((e) => alert(e));
    });

    this.get('#/register', function (context) {
        this.loadPartials({
            'header': '../templates/header.hbs',
            'footer': '../templates/footer.hbs'
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
            const shoe = DB.collection('movies').doc(context.params.id.slice(1));
            shoe.get().then(function (doc) {
                if (userInfo) {
                    const { uid, email } = JSON.parse(userInfo);
                    context.isLoggedIn = true;
                    context.email = email;
                }

                context.isCreator = context.email == doc.data().creator;
                context.title = doc.data().title;
                context.likers = doc.data().likers.length > 0 ? doc.data().likers.length : 0
                context.imageUrl = doc.data().imageUrl;
                context.description = doc.data().description;
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
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            let that = this;
            const movies = DB.collection('movies').doc(context.params.id.slice(1));
            movies.get().then(function (doc) {
                if (userInfo) {
                    const { uid, email } = JSON.parse(userInfo);
                    context.isLoggedIn = true;
                    context.email = email;
                }
                const { uid, email } = JSON.parse(userInfo);
                context.isLiked = doc.data().likers.indexOf(email) >= 0 ? false : true
                context.isCreator = context.email == doc.data().creator;
                context.title = doc.data().title;
                context.liked = doc.data().likers.length > 0 ? doc.data().likers.length : 0
                context.imageUrl = doc.data().imageUrl;
                context.description = doc.data().description;
                context.id = context.params.id.slice(1);
                that.partial(`./templates/details.hbs`);
            });
        });
    })

    this.get('#/create', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const { uid, email } = JSON.parse(userInfo);
        this.loadPartials({
            'header': '../templates/header.hbs',
            'footer': '../templates/footer.hbs'
        }).then(function () {
            this.partial('../templates/create.hbs');
        })
    });

    this.post('#/register', function (context) {
        console.log(context.params);
        const { email, password, repeatPassword } = context.params;
        if (password !== repeatPassword) {
            return;
        }
        UserModel.createUserWithEmailAndPassword(email, password).then((createUser) => {
            UserModel.signInWithEmailAndPassword(email, password)
                .then(({ user: { uid, email } }) => {
                    localStorage.setItem('userInfo', JSON.stringify({ uid, email }));
                    context.redirect('#/home');
                }).catch((e) => alert(e));
        }).catch((e) => alert(e.message));
    });

    this.post('#/login', function (context) {
        console.log(context);
        const { email, password } = context.params;
        UserModel.signInWithEmailAndPassword(email, password)
            .then(({ user: { uid, email } }) => {
                localStorage.setItem('userInfo', JSON.stringify({ uid, email }));
                context.redirect('#/home');
            }).catch((e) => alert(e));
    });

    this.post('#/create', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        console.log(context.params)
        console.log(context.email)
        const { uid, email } = JSON.parse(userInfo);
        DB.collection('movies').add({
            title: context.params.title,
            imageUrl: context.params.imageUrl,
            description: context.params.description,
            likers: [],
            creator: context.email
        }).then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

    this.post('#/edit:id', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const { uid, email } = JSON.parse(userInfo);
        DB.collection('movies').doc(context.params.id.slice(1)).update({
            title: context.params.title,
            imageUrl: context.params.imageUrl,
            description: context.params.description,
        }).then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

    this.get('#/delete/:id', function (context) {
        const id = context.params.id.slice(1);
        DB.collection('movies').doc(id).delete().then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

    this.get('#/like/:id', function (context) {
        let that = this;
        const movies = DB.collection('movies').doc(context.params.id.slice(1));
        movies.get().then(function (doc) {
            const userInfo = localStorage.getItem('userInfo');
            const { uid, email } = JSON.parse(userInfo);
            let likers = [];

            doc.data().likers.forEach(b => likers.push(b));
            likers.push(email);
            movies.update({ likers: likers });
            context.redirect(`#/details/:${context.params.id.slice(1)}`);
        });
    });

    this.post('#/search', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const movies = DB.collection('movies').get().then(function (result) {
            let movieId = null;
            result.forEach(function (doc) {
                if (doc.data().title.includes(context.params.search) || doc.data().description.includes(context.params.search)) {
                    movieId = doc.id;
                }
                if (movieId){
                    context.redirect(`#/details/:${movieId}`);
                }
            });
        });
    })
});

(() => {
    router.run('#/home');
})();

function loadPartials(context) {
    return context.loadPartials({
        'header': './templates/header.hbs',
        'footer': './templates/footer.hbs'
    })
}