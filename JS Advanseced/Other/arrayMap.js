function arrayMap(arr, func) {
    return arr.reduce(function (acc, curr) {
        return acc.concat(func(curr));
    }, [])
}