function cars(input) {
    return input.reduce(function (acc, curr) {
        const [cmd, v1, v2, v3] = curr.split(' ');
        if (cmd === 'create') {
            if (!acc[v3] ) {
                acc[v1] = {};
                return acc;
            }
            acc[v1] = Object.create(acc[v3]);
            return acc;
        } else if (cmd === 'set') {
            acc[v1][v2] = v3;
            return acc;
        }
        const prop = acc[v1];
        let result = [];
        for (let key in acc[v1]) {
            result.push(`${key}:${acc[v1][key]}`);
        }
        console.log(result.join(', '));
        return acc;
    }, [])
}

let commands = ['create c1','create c2 inherit c1','set c1 color red','set c2 model new','print c1','print c2'];

let text = "";
let res=cars(commands)