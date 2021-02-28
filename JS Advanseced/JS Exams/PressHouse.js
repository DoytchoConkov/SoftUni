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
            this.comments = [];
        }
        addComment(comment) {
            this.comments.push(comment);
            return 'The comment is added.';
        }
        toString() {
            let result = super.toString() + `\nOriginal Research: ${this.originalResearch.title} by ${this.originalResearch.author}\n`;
            if (this.comments.length > 0)
                result += `Comments:`;
            this.comments.reduce((acc, elem) => {
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

let classes = solve()
let book = new classes.BookReview('The Great Gatsby is so much more than a love story', 'The Great Gatsby is in many ways similar to Romeo and Juliet, yet I believe that it is so much more than just a love story. It is also a reflection on the hollowness of a life of leisure. ...', { name: 'The Great Gatsby', author: 'F Scott Fitzgerald' });
                        
output = book.toString();
console.log(output);
