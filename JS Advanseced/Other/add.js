function add(number) {
    this.number = number;
    function add2(number2) {
        return number + number2;
    }
    return add2;
}