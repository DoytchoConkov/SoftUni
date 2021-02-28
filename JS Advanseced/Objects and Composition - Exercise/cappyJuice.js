function cappyJuice(arr) {
    let juices = {};
    let bottels = new Set();
    for (const element of arr) {
        let [juice, quantity] = element.split(' => ');
        if (juices[juice] === undefined) {
            juices[juice] = 0;
        }
        juices[juice] += Number(quantity);
        if (juices[juice]>1000){
            bottels.add(juice);
        }
    }
    for(const bottle of bottels){
        console.log(`${bottle} => ${Math.floor(juices[bottle]/1000)}`)
    }
}