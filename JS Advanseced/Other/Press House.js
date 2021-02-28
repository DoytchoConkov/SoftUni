function solve() {
    class Article {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Title: ${this.title}\nContent: ${this.content}`;
        }

    }

    class ShortReports extends Article {
        constructor(title, content, originalResearch) {
            if (content.length >= 150) {
                throw new Error('Short reports content should be less then 150 symbols.');
            }
            if (!originalResearch.title || !originalResearch.author) {
                  throw new Error('The original research should have author and title.');
            }
            super(title, content);
            this.originalResearch = originalResearch;
            this._comments = [];
        }
        addComment(comment) {
            this._comments.push(comment);
            return 'The comment is added.';
        }
        toString() {
            let result = super.toString() + `\nOriginal Research: ${this.originalResearch.title} by ${this.originalResearch.author}\n`;
            if (this._comments.length > 0)
                result += `Comments:`;
            this._comments.reduce((acc, elem) => {
                return result +='\n'+ elem ;
            }, result);
            return result;
        }
    }

    class BookReview extends Article {
        constructor(title, content, book) {
            super(title, content);
            this.book = book;
            this.clients = [];
        }
        addClient(clientName, orderDescription) {
            let client=this.clients.forEach(e=>{
                if(e.clientName===clientName)
                throw new Error('This client has already ordered this review.');
            })
            this.clients.push({ clientName, orderDescription });
            return `${clientName} has ordered a review for ${this.book.name}`;
        }
        toString() {
            let result = super.toString() + `\nBook: ${this.book.name}\n`;
            if (this.clients.length > 0) {
                result += 'Orders:';
                this.clients.forEach(e => {
                    result += `\n${e.clientName} - ${e.orderDescription}`;
                })
            }
            return result;
        }
    }

    return { Article, ShortReports, BookReview };
}