class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    };
    set fullName(fullName) {
        const names = fullName.split(' ');
        if (names.length === 2) {
            this.firstName = names[0];
            this.lastName = names[1];
        }
    };
    get fullName() {
        return this.firstName + ' ' + this.lastName;
    }
}