function usernames(arr) {
    let names = {};
    let nameArr = []
    for (const name of arr) {
        if (names[name] !== true) {
            names[name] = true;
            nameArr.push(name);
        }
    }
    console.log(nameArr.sort((a, b) => {
        let result = a.length - b.length;
        if (result === 0) {
            let a1 = '' + a;
            let b1 = '' + b;
            return a1.localeCompare(b1);
        }
        return result;
    }).join('\n'));
}

usernames(['Ashton',
    'Kutcher',
    'Ariel',
    'Lilly',
    'Keyden',
    'Aizen',
    'Billy',
    'Braston'])