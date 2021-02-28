function equalNeighbors(arr) {
    let equalPairs = 0;
    for (let i = 0; i < arr.length; i++) {
        let element = arr[i][0];
        for (let j = 1; j < arr[i].length; j++) {
            if (element === arr[i][j]) {
                equalPairs++;
                element = arr[i][j];
            } else if (i < arr.length - 1 && arr[i][j] === arr[i + 1][j]) {
                equalPairs++;
            } else {
                element = arr[i][j];
            }
        }
    }
    console.log(equalPairs);
}

equalNeighbors([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']])
