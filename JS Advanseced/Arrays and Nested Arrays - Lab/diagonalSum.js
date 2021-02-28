function solve(arr) {
    let mainDiagonalSum = 0;
    let secondDiagonalSum = 0;
    for (let i = 0; i < arr.length; i++) {
        mainDiagonalSum += arr[i][i];
        secondDiagonalSum += arr[i][arr.length - i - 1];
    }
    console.log(mainDiagonalSum + ' ' + secondDiagonalSum);
}