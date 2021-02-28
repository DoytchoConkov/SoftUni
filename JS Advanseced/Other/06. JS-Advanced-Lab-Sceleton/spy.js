function Spy(obj, metodName) {
    const spy = { count: 0 };
    const metod = obj[metodName];
    if (!metod) { return; }
    obj[metodName] = function (...args) {
        this.count++;
        return metod.apply(obj, args);
    }.bind(spy);
    return spy;
}


let obj = {
    method: () => "invoked"
}
let spy = Spy(obj, "method");
obj.method();
obj.method();
obj.method();
console.log(spy)