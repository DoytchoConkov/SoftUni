function solveClasses() {
    class Developer {
        constructor(firstName, lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.baseSalary = 1000;
            this.tasks = [];
            this.experience = 0;
        }

        addTask(id, taskName, priority) {
            let taskObj = { id: id, taskName: taskName, priority: priority }
            if (priority === 'high' && this.tasks.length > 0) {
                this.tasks.unshift(taskObj);
            } else {
                this.tasks.push(taskObj);
            }
            return `Task id ${id}, with ${priority} priority, has been added.`;
        }

        doTask() {
            if (!this.tasks.length > 0) {
                return `${this.firstName}, you have finished all your tasks. You can rest now.`;
            } else {
                return this.tasks.shift();
            }
        }

        getSalary() {
            return `${this.firstName} ${this.lastName} has a salary of: ${this.baseSalary}`
        }

        reviewTasks() {
            let result = 'Tasks, that need to be completed:';
            this.tasks.forEach(task => {
                result += `\n${task.id}: ${task.taskName} - ${task.priority}`
            });
            return result;
        }
    }

    class Junior extends Developer {
        constructor(firstName, lastName, bonus, experience) {
            super(firstName, lastName);
            this.baseSalary += +bonus;
            this.experience = +experience;
        }

        learn(years) {
            this.experience += Number(years);
        }
    }

    class Senior extends Developer {
        constructor(firstName, lastName, bonus, experience) {
            super(firstName, lastName);
            this.baseSalary += Number(bonus);
            this.experience = Number(experience)+5;
        }

        changeTaskPriority(taskId) {
            let index = -1;
            for (let i = 0; i < this.tasks.length; i++) {
                if (this.tasks[i].id === taskId) {
                    index = i;
                    break;
                }
            }
            let task = this.tasks.splice(index, 1);
            if (task.priority === "high") {
                task.priority = 'low';
                this.tasks.push(task);
            } else {
                task.priority = 'high';
                this.tasks.unshift(task);
            }
            return task;
        }

    }

    return {
        Developer,
        Junior,
        Senior
    }
}

let classes = solveClasses();
const developer = new classes.Developer("George", "Joestar");
console.log(developer.addTask(1, "Inspect bug", "low"));
console.log(developer.addTask(2, "Update repository", "high"));
console.log(developer.reviewTasks());
console.log(developer.getSalary());
const junior = new classes.Junior("Jonathan", "Joestar", 200, 2);
console.log(junior.getSalary());
const senior = new classes.Senior("Joseph", "Joestar", 200, 2);
senior.addTask(1, "Create functionality", "low");
senior.addTask(2, "Update functionality", "high");
console.log(senior.changeTaskPriority(1)["priority"]);

