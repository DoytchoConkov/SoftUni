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
                'header': './view/header.hbs',
                'footer': './view/footer.hbs'
            }).then(function (context) {
                this.partial('./view/home.hbs');
            })
        });
    });

});

(() => {
    router.run('#/home');
})();

function loadPartials(context) {
    return context.loadPartials({
        'header': './view/header.hbs',
        'footer': './view/footer.hbs'
    })
}