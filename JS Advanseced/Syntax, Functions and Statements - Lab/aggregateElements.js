function aggregateElements(arg) {

    let sum = 0;
    let sumInverse = 0;
    let result = '';
    for (let index = 0; index < arg.length; index++) {
        sum += arg[index];
        sumInverse = sumInverse + 1 / arg[index];
        result=result+arg[index];
    }

    console.log(sum);
    console.log(sumInverse)
    console.log(result);

}

aggregateElements([1, 2, 3])