function squareStars(arg = 5) {
    for (let i = 1; i <= arg; i++) {
        let result = '';
        for (let j = 1; j <= arg; j++) {
            result = result + '* ';
        }
        console.log(result);
    }
}

squareStars (3)