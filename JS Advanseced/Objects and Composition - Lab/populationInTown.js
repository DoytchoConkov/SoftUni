function populationInTown(arr){
    let towns={};
    for(let i=0;i<arr.length;i++){
        let token=arr[i].split(' <-> ')
        if (towns[token[0]] !== undefined) {
            towns[token[0]] = towns[token[0]] +  Number(token[1]);
        } else {
            towns[token[0]] = Number(token[1]);
        }
    }
    for (const key in towns) {
        console.log(`${key} : ${towns[key]}`)
    }
}

populationInTown(['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000'])