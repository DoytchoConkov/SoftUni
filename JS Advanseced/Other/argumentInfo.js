function argumentInfo() {
    const type = {};
    for (let element of arguments) {
        const elementType = typeof (element);
        console.log(`${elementType}: ${element}`)
        if (type[elementType] === undefined) {
             type[elementType]=0;
        }
        type[elementType]++;
    }
    Object.entries(type).sort((a,b)=>b[1]-a[1]).forEach((e)=>console.log(`${e[0]} = ${e[1]}`))
}

argumentInfo('dog','cat', 42, function () { })