class Article {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

     likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`;
        } else if (this._likes.length === 1) {
            return `${this._likes[0]} likes this article!`;
        } else { return `${this._likes[0]} and ${this._likes.length - 1} others like this article!`; }
    }

    like(username) {
        if (username === this.creator) {
            throw new Error(`You can't like your own articles!`);
        }
        let user = this._likes.find(e => {
            if (e === username) {
                return e;
            }
        });
        if (user !== undefined) {
            throw new Error(`You can't like the same article twice!`);
        }
        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        let user = this._likes.find(e => {
            if (e === username) {
                return e;
            }
        });
        if (user === undefined) {
            throw new Error("You can't dislike this article!");
        }
        let index = this._likes.indexOf(username);
        this._likes.splice(index, 1);
        return `${username} disliked ${this.title}`
    }

    comment(username, content, id) {
        let comment = this._comments.find(e => e.id === id);
        if (id === undefined || !comment) {
            this._comments.push({ id: this._comments.length + 1, username: username, content: content, replies: [] });
            return `${username} commented on ${this.title}`;
        }
        comment.replies.push({ id: id + '.' + (comment.replies.length + 1), username: username, content: content });
        return `You replied successfully`;
    }

    toString(sortingType) {
        let result = `Title: ${this.title}\nCreator: ${this.creator}\nLikes: ${this._likes.length}\nComments:`;
        let sortFunction = {
            asc: (a, b) => { return a.id - b.id; },
            desc: (a, b) => { return b.id - a.id; },
            username: (a, b) => { return a.username.localeCompare(b.username); }
        }
        let sortTypeFunction = sortFunction[sortingType];
        let sortedComments = this._comments.slice().sort(sortTypeFunction);
        for (const comment of sortedComments) {
            result += `\n-- ${comment.id}. ${comment.username}: ${comment.content}`;
            let sortedReplies = comment.replies.sort(sortTypeFunction);
            for (const reply of sortedReplies) {
                result += `\n--- ${reply.id}. ${reply.username}: ${reply.content}`
            }
        }
        return result;
    }
}

let art = new Article("My Article", "Anny");
console.log(art.like("John"));
console.log(art.likes());
console.log(art.dislike("John"));
console.log(art.like("Ivan"));
console.log(art.like("Steven"));
console.log(art.likes());
console.log(art.comment("Anny", "Some Content"));
console.log(art.comment("Ammy", "New Content", 1));
console.log(art.comment("Zane", "Reply", 2));
console.log(art.comment("Jessy", "Nice :)"));
console.log(art.comment("SAmmy", "Reply@", 2));

console.log(art.toString('asc'));