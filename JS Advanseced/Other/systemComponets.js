function systemComponets(arr) {
    let systems = {};
    for (const line of arr) {
        let [system, component, subcomponent] = line.split(' | ');
        if (systems[system] === undefined) {
            systems[system] = {};
        }
        if (systems[system][component] === undefined) {
            systems[system][component] = [];
        }
        systems[system][component].push(subcomponent);
    }
    let systemKeys=Object.keys(systems);
    systemKeys.sort((a,b)=>{
        return Object.keys(systems[b]).length-Object.keys(systems[a]).length || a.localeCompare(b);
    })
    for (const key of systemKeys) {
        console.log(key);
        for (const component of Object.keys(systems[key])) {
            console.log('|||' + component);
            for (const subelement of systems[key][component]) {
                console.log('||||||'+subelement);
            }
        }
    }
}

systemComponets(['SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security'])