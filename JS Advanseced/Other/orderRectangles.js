function orderRectangles(input) {

    const prototype = {
        area() {
            return this.width * this.height;
        },
        compareTo(other) {
            const currentArea = this.area();
            const otherArea = other.area();
            return  otherArea-currentArea|| other.width - this.width;
        }
    };

    function createRec(width, height) {
        const result = Object.create(prototype);
        result.width = width;
        result.height = height;
        return result;
    };

    return input.reduce(function (acc, [width, height]) {
        return acc.concat(createRec(width, height))
    }, []).sort((a, b) => a.compareTo(b) );
}

let sizes = [[1,20],[20,1],[5,3],[5,3]];

console.log(sizes);


