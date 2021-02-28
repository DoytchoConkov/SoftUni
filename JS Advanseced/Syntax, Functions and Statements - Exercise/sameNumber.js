function samuNumber(number) {

    let samedigits = true;
    let digit = number % 10;
    let sum = digit;
    number = Math.floor(number/ 10) ;
    while (number > 0) {
        let currentDigit = number % 10;
        number = Math.floor(number/ 10) ;
        if (currentDigit !== digit) {
            samedigits = false;
        }
        sum += currentDigit;
    }
    if (samedigits){
        console.log('true');
    }else {
        console.log('false')
    }
    console.log(sum);
}

samuNumber(2222)