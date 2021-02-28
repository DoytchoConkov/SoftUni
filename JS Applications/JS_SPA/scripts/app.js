const UserModel = firebase.auth();
const DB = firebase.firestore();


const router = Sammy('#main', function () {

    this.use('Handlebars', 'hbs');

    this.get('#/home', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.isLoggedIn = true;
            context.email = email;
        }
        const shoes = DB.collection('shoes').get().then(function (result) {

            let shoes = [];
            result.forEach(function (doc) {
                shoes.push({ id: doc.id, ...doc.data() });

            });
            if (shoes.length > 1) {
                shoes.sort((a, b) => {
                    return b.buyers.length - a.buyers.length;
                });
            }
            context.shoes = shoes;
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
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            let that = this;
            const shoe = DB.collection('shoes').doc(context.params.id.slice(1));
            shoe.get().then(function (doc) {
                if (userInfo) {
                    const { uid, email } = JSON.parse(userInfo);
                    context.isLoggedIn = true;
                    context.email = email;
                }
               
                context.isCreator = context.email == doc.data().seller;
                const index = doc.data().buyers.indexOf(context.email);
                context.isBought = index >= 0 ? false : true
                context.name = doc.data().name;
                context.price = doc.data().price;
                context.brand = doc.data().brand;
                context.buyers = doc.data().buyers.length > 0 ? doc.data().buyers.length : 0
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
            const shoe = DB.collection('shoes').doc(context.params.id.slice(1));
            shoe.get().then(function (doc) {
                if (userInfo) {
                    const { uid, email } = JSON.parse(userInfo);
                    context.isLoggedIn = true;
                    context.email = email;
                }
                context.isCreator = context.email == doc.data().seller;
                const index = doc.data().buyers.indexOf(context.email);
                context.isBought = index >= 0 ? false : true
                context.name = doc.data().name;
                context.price = doc.data().price;
                context.brand = doc.data().brand;
                context.buyers = doc.data().buyers.length > 0 ? doc.data().buyers.length : 0
                context.imageUrl = doc.data().imageUrl;
                context.description = doc.data().description;
                context.id = context.params.id.slice(1);
                that.partial('./templates/details.hbs');
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
        const { email, password, repassword } = context.params;
        if (password !== repassword) {
            return;
        }
        UserModel.createUserWithEmailAndPassword(email, password).then((createUser) => {
            
            UserModel.signInWithEmailAndPassword(email, password)
            .then(({ user: { uid, email } }) => {
                let haveTeam = false;
                localStorage.setItem('userInfo', JSON.stringify({ uid, email }));
                context.redirect('#/home');
            }).catch((e) => alert(e));
        }).catch((e) => alert(e.message));
    });

    this.post('#/login', function (context) {

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
        const { uid, email } = JSON.parse(userInfo);
        DB.collection('movies').add({
            name: context.params.name,
            imageUrl: context.params.imageUrl,
            description: context.params.description,
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
        DB.collection('shoes').doc(context.params.id.slice(1)).update({
            name: context.params.name,
            price: context.params.price,
            imageUrl: context.params.imageUrl,
            description: context.params.description,
            brand: context.params.brand,
        }).then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

    this.get('#/delete/:id', function (context) {
        const id = context.params.id.slice(1);
        DB.collection('shoes').doc(id).delete().then(function (teamInfo) {
            context.redirect('#/home');
        }).catch((e) => alert(e));
    });

    this.get('#/buy/:id', function (context) {
        let that = this;
        const shoe = DB.collection('shoes').doc(context.params.id.slice(1));
        shoe.get().then(function (doc) {
            const userInfo = localStorage.getItem('userInfo');
            const { uid, email } = JSON.parse(userInfo);
            let buyers = [];

            doc.data().buyers.forEach(b => buyers.push(b));
            buyers.push(email);
            shoe.update({ buyers: buyers });
            context.redirect(`#/details/:${context.params.id.slice(1)}`);
        });
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