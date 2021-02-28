function increasingSubstring(arr) {
    let element = arr[0];
    let result = [element];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] >= element) {
            result.push(arr[i]);
            element = arr[i];
        }
    }
    console.log(result.join('\n'));
}