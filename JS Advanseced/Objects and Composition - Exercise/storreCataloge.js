function storeCatalog(arr) {
    let catalog = {};
    for (const line of arr) {
        let [name, price] = line.split(' : ');
        catalog[name] = Number(price);
    }
    let letter = "";
    for (const key of Object.keys(catalog).sort()) {
        let startLeter=''+key[0]
        if (letter !== startLeter) {
            console.log(key[0]);
            letter = key[0];
        } 
        console.log('  '+key + ': ' + catalog[key]);
    }
}

storeCatalog(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
)