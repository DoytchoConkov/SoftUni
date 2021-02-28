function sortArray(arr, sortDirection) {
    if (sortDirection === 'asc') {
        return arr.sort((a, b) => a - b);
    }
    return arr.sort((a, b) => b - a)
}