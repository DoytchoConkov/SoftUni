function listProcesor(command) {
    return command.reduce(function (acc, curr) {
        const [cmd, ...text] = curr.split(' ');
        const words = text.join(' ');
        if (cmd === 'add') {
            return acc.concat(words);
        } else if (cmd === 'remove') {
            return acc.filter(i =>i!==words)
        }
        console.log(acc);
        return acc
    }, []).toString
}