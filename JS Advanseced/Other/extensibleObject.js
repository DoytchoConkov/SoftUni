function extensibleObject() {
    const proto = {};
    const instance = Object.create(proto);

    instance.extend = function (template) {
        for (let element in template) {
            if (typeof template[element] === 'function') {
                proto[element] = template[element];
            } else {
                instance[element] = template[element];                   
            }
        }
    }
    return instance
}