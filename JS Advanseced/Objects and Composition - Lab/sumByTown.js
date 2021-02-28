function sumByTown(arr) {
    let towns = {};
    for (let i = 0; i < arr.length - 1; i += 2) {
        if (towns[arr[i]] !== undefined) {
            towns[arr[i]] = towns[arr[i]] +  Number(arr[i + 1]);
        } else {
            towns[arr[i]] = Number(arr[i + 1]);
        }
    }
    console.log(JSON.stringify(towns))
}

sumByTown(['Sofia','20','Varna','3','Sofia','5','Varna','4'])