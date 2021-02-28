function townsToJSON(arr) {
    let towns = [];
    let regex = /\s*\|\s*/;
    for (let i = 1; i < arr.length; i++) {
        let townArray = arr[i].split(regex);
        let town = {
            Town: townArray[1],
            Latitude: +(Number(townArray[2]).toFixed(2)),
            Longitude: +(Number(townArray[3]).toFixed(2))
        }
        towns.push(town);
    }
    console.log(JSON.stringify(towns))
}

townsToJSON(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
);