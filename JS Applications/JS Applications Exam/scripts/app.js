const UserModel = firebase.auth();
const DB = firebase.firestore();


const router = Sammy('#main', function () {

    this.use('Handlebars', 'hbs');

    this.get('#/home', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email, isOnTeam } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }
        loadPartials(context).then(function () {
            this.partial('./templates/home/home.hbs');
        })
    });

    this.get('#/login', function () {
        this.loadPartials({
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            this.partial('./templates/login.hbs');
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
            'header': './templates/header.hbs',
            'footer': './templates/footer.hbs'
        }).then(function () {
            this.partial('./templates/register/register.hbs');
        })
    });

    this.post('#/register', function (context) {
       
        const { email, password, repeatPassword } = context.params;
        if (password !== repeatPassword) {
            return;
        }
        toggleLoading();
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

function Notification(type, msg, ms = 1000) {
    let notification = document.getElementById(`${type}Box`);
    notification.style.display = 'block';
    notification.innerHTML = msg;
    setTimeout(() => {
      notification.style.display = 'none';
      notification.innerHTML = '';
    }, ms);
  }

  function toggleLoading(show = false) {
    let loadingBox = document.getElementById('loadingBox');
    loadingBox.style.display = show ? 'block' : 'none';
  }