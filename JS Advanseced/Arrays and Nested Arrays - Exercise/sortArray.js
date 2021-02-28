function sortArray(arr) {
    arr.sort(compareElements);
    console.log(arr.join('\n'));

    function compareElements(a, b) {
        if (a.length === b.length) {
            return a.localeCompare(b);
        }
        return a.length - b.length;
    }

}