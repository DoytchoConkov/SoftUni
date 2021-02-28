class Bank {
    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {
        this.allCustomers.find(e => {
            if (e.personalId === customer.personalId) {
                throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`)
            }
        })
        this.allCustomers.push(customer);
        return customer;
    }

    depositMoney(personalId, amount) {
        let person = this.allCustomers.find(e => {
            return e.personalId === personalId;
        });
        if (person === undefined) {
            throw new Error("We have no customer with this ID!");
        }
        if (isNaN(person.totalMoney)) {
            person.totalMoney = amount;
        } else {
            person.totalMoney += amount;
        }
        if (!Array.isArray(person.transactionInfos)) {
            person.transactionInfos = [];
        }
        let masage = `${person.transactionInfos.length + 1}. ${person.firstName} ${person.lastName} made deposit of ${amount}$!`;
        person.transactionInfos.push(masage);
        return `${person.totalMoney}$`;
    }

    withdrawMoney(personalId, amount) {
        let person = this.allCustomers.find(e => {
            return e.personalId === personalId;
        });
        if (person === undefined) {
            throw new Error("We have no customer with this ID!");
        }
        if (isNaN(person.totalMoney)) {
            person.totalMoney = 0;
        }
        if (!Array.isArray(person.transactionInfos)) {
            person.transactionInfos = [];
        }
        if (person.totalMoney < amount) {
            throw new Error(`${person.firstName} ${person.lastName} does not have enough money to withdraw that amount!`);
        } else {
            person.totalMoney -= amount;
        }
        let masage = `${person.transactionInfos.length + 1}. ${person.firstName} ${person.lastName} withdrew ${amount}$!`;
        person.transactionInfos.push(masage);
        return `${person.totalMoney}$`;
    }

    customerInfo(personalId) {
        let person = this.allCustomers.find(e => {
            return e.personalId === personalId;
        });
        if (person === undefined) {
            throw new Error("We have no customer with this ID!");
        } else {
            let result = '';
            result += `Bank name: ${this._bankName}\nCustomer name: ${person.firstName} ${person.lastName}\n`;
            result += `Customer ID: ${person.personalId}\n`;
            result += `Total Money: ${person.totalMoney}$\nTransactions:\n`;
            for (let index = person.transactionInfos.length - 1; index >= 0; index--) {
                result += person.transactionInfos[index];
                if (index !== 0) {
                    result += '\n';
                }
            }
            return result;
        }
    }
}

let bank = new Bank("SoftUni Bank");
console.log(bank.newCustomer({ firstName: 'Svetlin', lastName: 'Nakov', personalId: 1111111 }));
