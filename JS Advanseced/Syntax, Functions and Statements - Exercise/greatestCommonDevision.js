function greatestCommoDevision(num1, num2) {

    let a = Math.max(num1, num2);
    let b = Math.min(num1, num2);
    let remainder = 0;
    do {
        remainder = a % b;
        a = b;
        if (remainder!==0) {
            b = remainder;
        }

    } while (remainder !== 0)
    console.log(b)
}

greatestCommoDevision(2154, 458)