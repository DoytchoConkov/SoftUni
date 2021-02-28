function lowerPriceCity(townsArr) {
    let towns = {};
    for (const town of townsArr) {
        const [city, product, price] = town.split(' | ');
        if (towns[city] === undefined) { towns[city] = {}; }
        towns[city][product] = Number(price);
    }
    let townArray = new Set(Object.keys(towns));
    let productsArray = [];
    for (const town of townArray) {
        productsArray.push(Object.keys(towns[town]));
    }
    let productSet = new Set(productsArray.flat())


    for (const product of productSet) {
        let minPrice = 10000000;
        let cheapCity=''
        for (const town of townArray) {
            if (towns[town][product]<minPrice){
                cheapCity=town;
                minPrice=towns[town][product];
            }
        }
console.log(`${product} -> ${minPrice} (${cheapCity})`)
    }
}



lowerPriceCity(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10'])