function carFactory(obj) {
    let engine = {};
    let carriage = {};
    let wheels = [];
    if (obj.power <= 90) {
        engine = { power: 90, volume: 1800 };
    } else if (obj.power <= 120) {
        engine = { power: 120, volume: 2400 };
    } else {
        engine = { power: 200, volume: 3500 };
    }
    carriage = { type: obj.carriage, color: obj.color }
    if (obj.wheelsize % 2 === 0) {
        wheels=new Array(4).fill(obj.wheelsize - 1);
    } else {
        wheels=new Array(4).fill(obj.wheelsize);
    }
    return {
        model: obj.model,
        engine: engine,
        carriage: carriage,
        wheels: wheels
    }
}

console.log(carFactory({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}));