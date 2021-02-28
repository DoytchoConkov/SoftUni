function solveClasses() {
    class Hall {
        constructor(capacity, name) {
            this.capacity = capacity;
            this.name = name;
            this.events = [];
        }

        hallEvent(title) {
            this.events.find(e => {
                if (e === title) {
                    throw new Error(`This event is already added!`);
                }
            });
            this.events.push(title);
            return `Event is added.`;
        }

        close() {
            this.events = [];
            return `${this.name} hall is closed.`;
        }
        toString() {
            let result = `${this.name} hall - ${this.capacity}`
            if (this.events.length > 0) {
                result += `\nEvents: ${this.events.join(', ')}`
            }
            return result;
        }
    }

    class MovieTheater extends Hall {
        constructor(capacity, name, screenSize) {
            super(capacity, name);
            this.screenSize = screenSize;
        }
        close() {
            return super.close() + '\nАll screenings are over.';
        }

        toString() {
            let result = super.toString() + `\n${this.name} is a movie theater with ${this.screenSize} screensize and ${this.capacity} seats capacity.`;
            return result;
        }
    }

    class ConcertHall extends Hall {

        constructor(capacity, name) {
            super(capacity, name);
            this._performers=[];
        }
        hallEvent(title, performers) {
            super.hallEvent(title);
            this._performers = performers;
            return 'Event is added.';
        }

        close() {
            super.events = [];
            this._performers=[];
            return super.close() + '\nАll performances are over.';
        }

        toString() {
            let result = super.toString();
            if (this._performers.length > 0) {
                result += `\nPerformers: ${this._performers.join(', ')}.`;
            }
            return result;
        }
    }

    return { Hall, MovieTheater, ConcertHall };
}

let classes = solveClasses();
let concert = new classes.ConcertHall(5000, 'Diamond');
concert.hallEvent('The Chromatica Ball', ['LADY GAGA'])
console.log(concert.toString());
console.log(concert.close());
console.log(concert.toString());