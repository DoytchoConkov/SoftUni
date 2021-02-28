class Parking {
    constructor(capacity) {
        this.capacity = Number(capacity);
        this.vehicles = [];
    }

    addCar(carModel, carNumber) {
        if (this.vehicles.length === this.capacity) {
            throw new Error('Not enough parking space.');
        }
        const car = { carModel: carModel, carNumber: carNumber, payed: false };
        this.vehicles.push(car);
        return `The ${carModel}, with a registration number ${carNumber}, parked.`;
    }

    removeCar(carNumber) {
        let index = -1;
        for (let i = 0; i < this.vehicles.length; i++) {
            if (this.vehicles[i].carNumber === carNumber) {
                index = i;
                break;
            }
        }
        if (index===-1) {
            throw new Error("The car, you're looking for, is not found.");
        }
        if (!this.vehicles[index].payed) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`);
        }
        this.vehicles.splice(index, 1);
        return `${carNumber} left the parking lot.`
    }

    pay(carNumber) {
        let index = -1;
        for (let i = 0; i < this.vehicles.length; i++) {
            if (this.vehicles[i].carNumber === carNumber) {
                index = i;
                break;
            }
        }
        if (index===-1) {
            throw new Error(`${carNumber} is not in the parking lot.`);
        }
        if (this.vehicles[index].payed) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`);
        }
        this.vehicles[index].payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`
    }

    getStatistics(carNumber) {
        let result = '';
        if (!carNumber) {
            let sortedCars = this.vehicles.sort((a, b) => {
                a.carModel.localeCompare(b.carModel)
            });
            result = `The Parking Lot has ${this.capacity - this.vehicles.length} empty spots left.`
            sortedCars.forEach(car => {
                result += `\n${car.carModel} == ${car.carNumber} - ${car.payed ? 'Has payed' : 'Not payed'}`;
            })

        } else {
            let index = false;
            for (let i = 0; i < this.vehicles.length; i++) {
                if (this.vehicles[i].carNumber === carNumber) {
                    index = i;
                    break;
                }
            }
            let car = this.vehicles[index];
            result = `${car.carModel} == ${car.carNumber} - ${car.payed ? 'Has payed' : 'Not payed'}`;
        }
        return result;
    }
}
