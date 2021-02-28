function mathOperation(num1, num2, operation) {

    let number1 = Number(num1);
    let number2 = Number(num2);

    let result = 0;

    switch (operation) {
        case '+': result = number1 + number2; break;
        case '-': result = number1 - number2; break;
        case '*': result = number1 * number2; break;
        case '/': result = number1 / number2; break;
        case '%': result = number1 % number2; break;
        case '**': result = number1 ** number2; break;
    }

    console.log(result);

}

mathOperation(5, 6, '+')