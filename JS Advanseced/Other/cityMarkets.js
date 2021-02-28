function cityMarket(arr) {
    let towns = {};
    for (const element of arr) {
        let [city, product, amountSinglePrice] = element.split(' -> ');
        let [amount ,singlePrice]=amountSinglePrice.split(':');
        if (towns[city] === undefined) {
            towns[city] = {};
        }
        if (towns[city][product] === undefined) {
            towns[city][product] = {};
        }
        towns[city][product]['amount'] = Number(amount);
        towns[city][product]['price'] = Number(singlePrice);
    }
    let townsArr = Object.keys(towns);
    for (const city of townsArr) {
        console.log('Town - ' + city);
        let productsArr = Object.keys(towns[city]);
        for (const product of productsArr) {
            let totalPrice = towns[city][product]['amount'] * towns[city][product]['price'];
            console.log('$$$' + product + ' : ' + totalPrice);
        }
    }

}
cityMarket(['Sofia -> Laptops HP -> 200 : 2000',
    'Sofia -> Raspberry -> 200000 : 1500',
    'Sofia -> Audi Q7 -> 200 : 100000',
    'Montana -> Portokals -> 200000 : 1',
    'Montana -> Qgodas -> 20000 : 0.2',
    'Montana -> Chereshas -> 1000 : 0.3'])