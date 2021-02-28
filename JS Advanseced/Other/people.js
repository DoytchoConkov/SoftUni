function people() {

    const juniorTasks = [' is working on a simple task.'];
    const SeniorTasks = [' is working on a complicated task.', ' is taking time off work.', ' is supervising junior workers.'];
    const ManagerTasks = [' scheduled a meeting.', ' is preparing a quarterly report.'];

    class Employee {
        constructor(name, age) {
            if (new.target==='Employee'){
                throw new Error ('Error')
            }
            this.name = name;
            this.age = age;
            this.salary = 0;
            this.dividend=0;
            this.task = [];
        }

        work() {
            const currentTask = this.task.shift();
            console.log(this.name + currentTask);
            this.task.push(currentTask);
        }

        collectSalary() {

            console.log(`${this.name} received ${this.salary} this month.`);
        }

    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age);
            juniorTasks.forEach(e => this.task.push(e));
        }
    };

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age);
            SeniorTasks.forEach(e => this.task.push(e));
        }
    };

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age);
            ManagerTasks.forEach(e => this.task.push(e));
        }
        collectSalary() { console.log(`${this.name} received ${this.salary + this.dividend} this month.`) }
    };

    return {
        Employee,
        Junior,
        Senior,
        Manager
    }
}