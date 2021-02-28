function stringLenght(arr1, arr2, arr3) {

    let sum = 0;
    let avrSum = 0;

    let str1lenght = arr1.length;
    let str2lenght = arr2.length;
    let str3lenght = arr3.length;

    sum = str1lenght + str2lenght + str3lenght;
    avrSum = Math.floor(sum / 3);

    console.log(sum);
    console.log(avrSum);

}

stringLenght('chocolate', 'ice cream', 'cake')