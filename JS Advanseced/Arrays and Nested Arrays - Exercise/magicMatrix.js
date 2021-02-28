function magicMatrix(arr) {
    let isMagixMatrix = true;
    let firstSum = arr[0].reduce((a, b) => a + b, 0);
    for (let i = 0; i < arr.length; i++) {
        let firstSum = arr[0].reduce((a, b) => a + b, 0);
        let sum = 0;
        sum = arr[i].reduce((a, b) => a + b, 0);
        if (firstSum !== sum) {
            isMagixMatrix = false;
            break;
        }
    }
    for (let i = 0; i < arr[0].length; i++) {
        let sum = 0;
        for (let j = 0; j < arr.length; j++) {
            sum += arr[i][j];
        }
        if (firstSum !== sum) {
            isMagixMatrix = false;
            break;
        }
    }
    console.log(isMagixMatrix)
}