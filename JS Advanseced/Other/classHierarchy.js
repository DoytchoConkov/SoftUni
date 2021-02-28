function result() {
    class Figure {
        constructor(units = 'cm') {
            this.units = units;
        }
        get area() {
            throw new Error('No imput implement');
        }

        changeUnits(newUnit) {
            this.units = newUnit;
        }

        convertUnit(value) {
            if (this.units === 'm') {
                return value / 100;
            } else if (this.units === 'mm') {
                return value * 10;
            }
            return value;
        }

        toString() {
            return `Figures units: ${this.units} Area: ${this.area}`;
        }
    }
    class Circle extends Figure {
        constructor(radius, units) {
            super(units);
            this.radius = radius;
        }
        get area() {
            const r = this.convertUnit(this.radius);
            return Math.PI * r * r;
        }
        toString() {
            return `${super.toString()} - radius: ${this.convertUnit(this.radius)}`;
        };
    };
    class Rectangle extends Figure {
        constructor(width, height, units) {
            super(units);
            this.width = width;
            this.height = height;
        }
        get area() {
            const w = this.convertUnit(this.width);
            const h = this.convertUnit(this.height)
            return w * h;
        }
        toString() {
            return `${super.toString()} - width: ${this.convertUnit(this.width)}, height: ${this.convertUnit(this.height)}`;
        };
    };

    return { Figure, Circle, Rectangle }
}

let classes = result();
let Figure = classes.Figure;
let Rectangle = classes.Rectangle;
let Circle = classes.Circle;
let c = new Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

let r = new Rectangle(3, 4, 'mm');
console.log(r.area); // 1200 
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

c.changeUnits('mm');
console.log(c.area); // 7853.981633974483
console.log(c.toString()) 

'Figures units: undefined Area: 78.53981633974483 - radius: 5' 
'Figures units: cm Area: 78.53981633974483 - radius: 5'