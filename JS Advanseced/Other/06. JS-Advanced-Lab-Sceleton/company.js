class Company {
    constructor() {
        this.deparment = [];
    }
    addEmployee(username, salary, position, department) {
        _testParameter(username);
        _testParameter(salary);
        _testParameter(position);
        _testParameter(department);
        if (salary < 0) {
            throw new Error(' Invalid input!');
        }
        let currDep = this.deparment.find(d => d.name === department)
        if (currDep === undefined) {
            currDep = { name: department, employees: [] };
            this.deparment.push(currDep);
        }
        currDep.employees.push({username, salary: salary, position: position });
        return `New employee is hired. Name: ${username}. Position: ${position}`;

        function _testParameter(paramet) {
            if (paramet === null || paramet === undefined || paramet === '') {
                throw new Error('Invalid input!');
            }
        }
    }

    bestDepartment() {
        let newDepartments = this.deparment;
        newDepartments.sort((a, b) => {
            b.employees.reduce((acc, cur) => {
                return acc + cur.salary;
            }, 0) / b.employees.length - a.employees.reduce((acc, cur) => {
                return acc + cur.salary;
            }, 0) / a.employees.length
        });
        let result = [];
        const average = newDepartments[0].employees.reduce((acc, cur) => {
            return acc + cur.salary;
        }, 0) / newDepartments[0].employees.length;

        result.push(`Best Department is: ${newDepartments[0].name}`)
        result.push(`Average salary: ${average.toFixed(2)}`);
        newDepartments[0].employees.sort((a, b) => b.salary - a.salary||a.username.localeCompare(b.username));
        newDepartments[0].employees.forEach(e => {
            result.push(`${e.username} ${e.salary} ${e.position}`)
        });
     return result.join('\n');
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());