    function breakfastRobot() {
        const microelements = {
            protein: 0,
            carbohydrate: 0,
            fat: 0,
            flavour: 0
        };
        const recepties = {
            apple: {
                carbohydrate: 1,
                flavour: 2
            },
            lemonade: {
                carbohydrate: 10,
                flavour: 20
            },
            burger: {
                carbohydrate: 5,
                fat: 7,
                flavour: 3

            },
            eggs: {
                protein: 5,
                fat: 1,
                flavour: 1

            },
            turkey: {
                protein: 10,
                carbohydrate: 10,
                fat: 10,
                flavour: 10
            },
        }
        const cooking = {
            restock: (microelement, qty) => {
                microelements[microelement] += Number(qty);
                return 'Success';
            },
            prepare: (recept, qty) => {
                for (let key of Object.keys(recepties[recept])) {
                    if (recepties[recept][key] * qty > microelements[key]) {
                        return `Error: not enough ${key} in stock`;
                    }
                }
                for (let key of Object.keys(recepties[recept])) {
                    microelements[key]-=recepties[recept][key] * qty ;
                }
                return 'Success';
            },
            report: () => {
                return `protein=${microelements.protein} carbohydrate=${microelements.carbohydrate} fat=${microelements.fat} flavour=${microelements.flavour}`;
            }
        }
        function menager(input) {
            const tokens = input.split(' ');
            return cooking[tokens[0]](tokens[1], tokens[2]);
        }
        return menager
    }

let manager = breakfastRobot();
console.log(manager("restock protein 100")); // Success
console.log(manager("restock carbohydrate 100"));
console.log(manager("restock fat 100"));
console.log(manager("restock flavour 100"));
console.log(manager("report"));
console.log(manager("prepare turkey 2"));
console.log(manager("report"));
console.log(manager("prepare turkey 1"));
console.log(manager("report"));
