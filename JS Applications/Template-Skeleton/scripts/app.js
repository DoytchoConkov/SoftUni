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
            this.partial('../templates/home/home.hbs');
        })
    });

    this.get('#/login', function () {
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'loginForm': '../templates/login/loginForm.hbs',
            'footer': '../templates/common/footer.hbs'
        }).then(function () {
            this.partial('../templates/login/loginPage.hbs');
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
            'header': '../templates/common/header.hbs',
            'registerForm': '../templates/register/registerForm.hbs',
            'footer': '../templates/common/footer.hbs'
        }).then(function () {
            this.partial('../templates/register/registerPage.hbs');
        })
    });

    this.get('#/edit/:teamId', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email, isOnTeam } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }

        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'editForm': '../templates/edit/editForm.hbs',
            'footer': '../templates/common/footer.hbs'
        }).then(function () {
            this.partial('../templates/edit/editPage.hbs');
        })
    });

    this.post('#/edit/:teamId', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        if (userInfo) {
            const { uid, email } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }
        const { uid, email, isOnTeam } = JSON.parse(userInfo);
        const teamId = localStorage.getItem('teamId');

        console.log(teamId);
        const teamData = DB.collection('teams').doc(teamId);
        const editedTeam = {
            name: context.params.name,
            comment: context.params.comment,
            _creator: email
        }
        teamData.update(editedTeam).then(function (teamInfo) {
            localStorage.setItem('teamId', teamId)
            context.redirect('#/catalog');
        }).catch((e) => console.log(e));
    });

    this.get('#/create', function () {
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'createForm': '../templates/create/createForm.hbs',
            'footer': '../templates/common/footer.hbs'
        }).then(function () {
            this.partial('../templates/create/createPage.hbs');
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
                'header': './templates/common/header.hbs',
                'team': './templates/catalog/team.hbs',
                'footer': './templates/common/footer.hbs'
            }).then(function () {
                this.partial('./templates/catalog/teamCatalog.hbs');
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
            this.partial('../templates/about/about.hbs');
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
        DB.collection('teams').add({
            name: context.params.name,
            comment: context.params.comment,
            _creator: email,
            members: []
        }).then(function (teamInfo) {
            localStorage.setItem('teamId', teamInfo.id)
            context.redirect('#/catalog');
        }).catch((e) => console.log(e));
    });

    this.get('#/catalog/:teamId', function (context) {
        const userInfo = localStorage.getItem('userInfo');

        if (userInfo) {
            const { uid, email, isOnTeam } = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }
        const { uid, email, isOnTeam } = JSON.parse(userInfo);
        context.isOnTeam = isOnTeam;
        const teamId = context.params.teamId.substr(1);

        localStorage.setItem('teamId', teamId);
        this.loadPartials({
            'header': './templates/common/header.hbs',
            'teamMember': './templates/catalog/teamMember.hbs',
            'teamControls': './templates/catalog/teamControls.hbs',
            'footer': './templates/common/footer.hbs'
        }).then(function () {
            let that = this;
            const teamData = DB.collection('teams').doc(teamId);
            const { uid, email } = JSON.parse(userInfo);
            teamData.get().then(function (team) {
                context.isAuthor = email === team.data()._creator;
                context.name = team.data().name;
                context.members = team.data().members;
                context.comment = team.data().comment;
                context.teamId = teamId;
                that.partial('./templates/catalog/details.hbs');
            })
        })
    });

    this.get('#/leave', function (context) {
        const teamId = localStorage.getItem('teamId');
        const userInfo = localStorage.getItem('userInfo');
        const { uid, email, isOnTeam } = JSON.parse(userInfo);
        let haveTeam = false;
        let that = this;
        localStorage.setItem('userInfo', JSON.stringify({ uid, email, isOnTeam: haveTeam }));

        const teamData = DB.collection('teams').doc(teamId);
        teamData.get().then(function (team) {
            members = team.data().members;
            let membersEdited = [];
            members.forEach(m => {
                console.log(m.email + "  " + email);
                if (m.email != email) {
                    membersEdited.push(m);
                }
            })
            teamData.update({ members: membersEdited }).then(function () {
                localStorage.setItem('teamId', teamId);
                context.redirect(`#/catalog/:${teamId}`);
            });
        });
    });

    this.get('#/join/:teamId', function (context) {
        const userInfo = localStorage.getItem('userInfo');
        const { uid, email, isOnTeam } = JSON.parse(userInfo);
        let members = [];
        let haveTeam = true;
        let that = this;
        localStorage.setItem('userInfo', JSON.stringify({ uid, email, isOnTeam: haveTeam }));
        const teamId = context.params.teamId.substr(1);
        console.log(teamId);
        const teamData = DB.collection('teams').doc(teamId);
        teamData.get().then(function (team) {
            members = team.data().members;
            members.push({ email: email });
            teamData.update({ members: members }).then(function () {
                localStorage.setItem('teamId', teamId);
                context.redirect(`#/catalog/:${teamId}`);
            });
        });

    });
});

(() => {
    router.run('#/home');
})();

function loadPartials(context) {
    return context.loadPartials({
        'header': '../templates/common/header.hbs',
        'footer': '../templates/common/footer.hbs'
    })
}