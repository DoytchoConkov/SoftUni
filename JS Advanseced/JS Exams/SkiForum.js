class Forum {

    constructor() {
        this._users = [];
        this._questions = [];
        this._id = 1;
        this._loggedUsers = [];
    }

    register(username, password, repeatPassword, email) {
        if (username === '' || password === '' || repeatPassword === '' || email === '') {
            throw new Error('Input can not be empty');
        }
        if (password !== repeatPassword) {
            throw new Error('Passwords do not match');
        }
        let user = this._users.find(e => e.username === username || e.email === email);
        if (user) {
            throw new Error('This user already exists!');
        }
        this._users.push({ username: username, password: password, email: email });
        return `${username} with ${email} was registered successfully!`
    }

    login(username, password) {
        let user = this._users.find(e => e.username === username);
        if (!user) {
            throw new Error('There is no such user');
        }
        if (user.password === password) {
            this._loggedUsers.push(user);
            return `Hello! You have logged in successfully`;
        }

    }

    logout(username, password) {
        let user = this._loggedUsers.find(e => e.username === username);
        if (!user) {
            throw new Error('There is no such user');
        }
        if (user.password === password) {
            let index = this._loggedUsers.indexOf(user);
            this._loggedUsers.splice(index, 1);
            return `You have logged out successfully`;
        }
    }

    postQuestion(username, question) {
        let user = this._loggedUsers.find(e => e.username === username);
        let userLogged = this._users.find(e => e.username === username);
        if (!user || !userLogged) {
            throw new Error('You should be logged in to post questions');
        }
        if (question === '') {
            throw new Error('Invalid question');
        }
        let questionObj = { id: this._id, question: question, username: username, answers: [] };
        this._id++;
        this._questions.push(questionObj);
        return `Your question has been posted successfully`;
    }

    postAnswer(username, questionId, answer) {
        let user = this._loggedUsers.find(e => e.username === username);
        let userLogged = this._users.find(e => e.username === username);
        if (!user || !userLogged) {
            throw new Error('You should be logged in to post answers');
        }
        if (answer === '') {
            throw new Error('Invalid question');
        }
        let question = this._questions.find(e => e.id === questionId);
        if (!question) {
            throw new Error('There is no such question');
        }
        let ans = { username: username, answer: answer };
        question.answers.push(ans);
        return 'Your answer has been posted successfully';
    }

    showQuestions() {
        let result = [];
        this._questions.forEach(e => {
            result.push(`Question ${e.id} by ${e.username}: ${e.question}`);
            if (e.answers.length > 0) {
                e.answers.forEach(ans => {
                    result.push(`---${ans.username}: ${ans.answer}`)
                })
            }
        })
        return result.join('\n');
    }

}


let forum = new Forum();

forum.register('Michael', '123', '123', 'michael@abv.bg');
forum.register('Stoyan', '123ab7', '123ab7', 'some@gmail@.com');
forum.login('Michael', '123');
forum.login('Stoyan', '123ab7');

forum.postQuestion('Michael', "Can I rent a snowboard from your shop?");
forum.postAnswer('Stoyan', 1, "Yes, I have rented one last year.");
forum.postQuestion('Stoyan', "How long are supposed to be the ski for my daughter?");
forum.postAnswer('Michael', 2, "How old is she?");
forum.postAnswer('Michael', 2, "Tell us how tall she is.");

console.log(forum.showQuestions());

