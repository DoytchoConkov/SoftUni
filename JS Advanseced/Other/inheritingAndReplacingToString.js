function inheritingAndReplacingToString() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }
        toString() {
            const className = Object.getPrototypeOf(this).constructor.name;
            if (className==='Person'){return `${className} (name: ${this.name}, email: ${this.email}` + ')';}
            return `${className} (name: ${this.name}, email: ${this.email}` ;
        }
    }

    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email);
            this.subject = subject;
        }
        toString() {
            return super.toString() + `, subject: ${this.subject})`;
        }
    }

    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }
        toString() {
            return super.toString() + `, course: ${this.course})`;
        }
    }

    return {
        Person,
        Teacher,
        Student
    }
}

const a=inheritingAndReplacingToString();
const b=new a.Teacher("sads", "fdsfds", "fsdfs");
console.log(b.toString());


'Teacher (name: Gosho, email: gosh@gosh.com), subject: Graphics)' 
'Teacher (name: Gosho, email: gosh@gosh.com, subject: Graphics)'