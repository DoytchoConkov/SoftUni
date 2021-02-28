function autoCompany(arr) {
    let companies = {};
    for (const line of arr) {
        let [brand, model, quantity] = line.split(' | ');
        if (companies[brand] === undefined) {
            companies[brand] = {};
        }
        if (companies[brand][model] === undefined) {
            companies[brand][model] = 0;
        }
        companies[brand][model] += Number(quantity);
    }
    for (const key of Object.keys(companies)) {
        console.log(key);
        for (const car of Object.keys(companies[key])) {
            console.log('###' + car + ' -> ' + companies[key][car]);
        }
    }
}

autoCompany(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10'])