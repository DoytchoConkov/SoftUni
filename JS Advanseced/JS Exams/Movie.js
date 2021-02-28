class Movie {
    constructor(movieName, ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = Number(ticketPrice);
        this.screenings = [];
        this._profit = 0;
        this._tickets = 0;
    }

    newScreening(date, hall, description) {
        let temp = this.screenings.find(e => {
            if (e.date === date && e.hall === hall) {
                return e;
            }
        })
        if (temp === undefined) {
            this.screenings.push({ date: date, hall: hall, description: description });
        } else {
            throw new Error(`Sorry, ${hall} hall is not available on ${date}`)
        }
        return `New screening of ${this.movieName} is added.`;

    }

    endScreening(date, hall, soldTickets) {
        let temp = this.screenings.find(e => {
            if (e.date === date && e.hall === hall) {
                return e;
            }
        });
        if (temp === undefined) {
            throw new Error(`Sorry, there is no such screening for ${this.movieName} movie.`);
        } else {
            let index = -1;
            for (let i = 0; i < this.screenings.length; i++) {
                if (this.screenings[i].date === date && this.screenings[i].hall === hall) {
                    index = i;
                    break;
                }
            }
            this.screenings.splice(index, 1);
            this._profit += this.ticketPrice * Number(soldTickets);
            this._tickets += Number(soldTickets);
        }

        return `${this.movieName} movie screening on ${date} in ${hall} hall has ended. Screening profit: ${this.ticketPrice * Number(soldTickets).toFixed(0)}`
    }

    toString() {
        let result = `${this.movieName} full information:\nTotal profit: ${this._profit.toFixed(0)}$\nSold Tickets: ${this._tickets}`;
        if (this.screenings.length > 0) {
            result += `\nRemaining film screenings:`;
            let sortetScreenings = this.screenings.sort((a, b) => a.hall.localeCompare(b.hall));
            sortetScreenings.forEach(e => { result += `\n${e.hall} - ${e.date} - ${e.description}`; }
            );
        } else {
            result += `\nNo more screenings!`;
        }
        return result;
    }
}

let m = new Movie('Wonder Woman 1984', '10.00');
m.newScreening('October 2, 2020', 'IMAX 3D', `3D`);
m.newScreening('October 3, 2020', 'Main', `regular`);
m.newScreening('October 4, 2020', 'IMAX 3D', `3D`);
m.endScreening('October 2, 2020', 'IMAX 3D', 150);
m.endScreening('October 3, 2020', 'Main', 78);
console.log(m.toString())