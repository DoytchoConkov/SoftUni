function solve() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }
        toString() {
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, like, dislike) {
            super(title, content);
            this.like = like;
            this.dislike = dislike;
            this.comments = [];
        }
        addComment(comment) {
            this.comments.push(comment);
        }
        toString() {
            const result = [];
            result.push(super.toString());
            result.push(`Rating: ${this.like - this.dislike}`);
            if (this.comments.length > 0) {
                result.push('Comments:');
                this.comments.forEach(c => {
                    result.push(' * ' + c);
                })
            }
            return result.join('\n');
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = views;
        }
        view() {
            this.views++;
            return this;
        }
        toString() {
            return `${super.toString()}\nViews: ${this.views}`;
        }
    }
    return {Post,SocialMediaPost,BlogPost};
}