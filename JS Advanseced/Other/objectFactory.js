function objectFactory(input) {
    const text=JSON.parse(input)
let result={};
    for (let element of text){
        Object.assign(result,element);
    }
    return result;
}
console.log(objectFactory(`[{"prop1": 1},{"prop2":2},{"prop3":3}]`));