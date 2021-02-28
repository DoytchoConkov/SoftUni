function circleArea(arg) {

    let result = typeof (arg);

    if (result === 'number') {
        let area = Math.pow(arg, 2) * Math.PI;
        console.log(area.toFixed(2));
    } else {
        console.log(`We can not calculate the circle area, because we receive a ${result}.`);
    }
}

circleArea(5);