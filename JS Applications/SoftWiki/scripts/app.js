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
        const category = DB.collection('article').get().then(function (result) {
            let categories = [];
            result.forEach(function (doc) {
                let findCategory = categories.find(el => {
                   return el.category == doc.data().category
                });
                if (findCategory) {
                    findCategory.articles.push({ id: doc.id, title: doc.data().title, content: doc.data().content });
                } else {
                    categories.push({ category: doc.data().category, articles: [{ id: doc.id, title: doc.data().title, content: doc.data().content }] });
                }
            });
            context.categories = categories;
            context.loadPartials({
                'header': '../templates/header.hbs',
                'articles': '../templates/articles.hbs',
                'footer': '../templates/footer.hbs'
            }).then(function () {
                this.partial('./templates/home.hbs');
            })
        });
    });

    this.get('#/login', function () {
        this.loadPartials({
            'header': '../templates/header.hbs',
            'footer': './templates/footer.hbs'
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
            'header': '../templates/header.hbs',
            'footer': './templates/footer.hbs'
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
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            let that = this;
            const shoe = DB.collection('article').doc(context.params.id.slice(1));
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
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            let that = this;
            const shoe = DB.collection('article').doc(context.params.id.slice(1));
            shoe.get().then(function (doc) {
                if (userInfo) {
                    const { uid, email } = JSON.parse(userInfo);
                    context.isLoggedIn = true;
                    context.email = email;
                }
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
        DB.collection('article').doc(context.params.id.slice(1)).update({
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
            'footer': './templates/footer.hbs'
        }).then(function () {
            this.partial('./templates/create.hbs');
        })
    });

    this.post('#/register', function (context) {
        const { email, password, reppass } = context.params;
        if (password !== reppass) {
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
        DB.collection('article').add({
            title: context.params.title,
            category: context.params.category,
            content: context.params.content,
            creator: email
        }).then(function (teamInfo) {
            localStorage.setItem('article', teamInfo.id)
            context.redirect('#/home');
        }).catch((e) => console.log(e));
    });

    this.get('#/delete/:id', function (context) {
        const id = context.params.id.slice(1);
        DB.collection('article').doc(id).delete().then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

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