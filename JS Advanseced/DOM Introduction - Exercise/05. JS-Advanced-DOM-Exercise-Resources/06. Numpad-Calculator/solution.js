function solve() {
    const buttons = document.querySelectorAll('.keys button');
    const mathOperation = {
        '+': (a, b) => a + b,
        '-': (a, b) => a - b,
        '*': (a, b) => a * b,
        '/': (a, b) => a / b
    };
    const operationElements = {
        first: '',
        operator: '',
        second: ''
    }
    for (let button of buttons) {
        let expresionResult = document.getElementById('expressionOutput');
       
        button.addEventListener('click', () => {
            let key = button.value;
            if (key === "=") {
                let result = mathOperation[operationElements.operator](Number(operationElements.first), Number(operationElements.second));
                document.getElementById('resultOutput').innerText = result;
            } else if (mathOperation.hasOwnProperty(key)) {
                operationElements.operator = key;
            } else {
                if (operationElements.operator === '') {
                    operationElements.first += key;
                } else {
                    operationElements.second += key;
                }
            }
            document.getElementById('expressionOutput').innerText = `${operationElements.first} ${operationElements.operator} ${operationElements.second}`
        })
    }
    const clearButon = document.getElementsByClassName('clear')[0];
    clearButon.addEventListener('click', () => {
        document.getElementById('resultOutput').innerText = '';
        document.getElementById('expressionOutput').innerText = '';
    });

}