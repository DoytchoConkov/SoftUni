function heroicInventory(arr) {
    let result = [];
    for (const line of arr) {
        let [name, level, items] = line.split(' / ');
        level = Number(level);
        if (items.length > 0) {
            items = items.split(', ');
        } else {
            items = [];
        }
        result.push({name,level,items});
    }
console.log(JSON.stringify(result));
}