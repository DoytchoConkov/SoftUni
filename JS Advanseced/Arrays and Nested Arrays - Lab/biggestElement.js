function solve(arr) {
    let maxNumber = arr[0][0];
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            if (arr[i][j] > maxNumber) {
                maxNumber = arr[i][j];
            }
        }
    }
    console.log(maxNumber);
}