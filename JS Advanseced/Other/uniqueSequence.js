function uniqueSequence(arr) {
    let arrayObj = {};
    let i = 0;
    for (const line of arr) {
        arrayObj[i] = {};
        let lineArray = line.replace(/\[/g, '').replace(/\]/g, '').split(',');
        for (const element of lineArray) {
            arrayObj[i][Number(element)] = true;
        }
        i++;
    }
    for (let j = 0; j < arr.length - 1; j++) {
        for (const number of Object.keys(arrayObj[j])) {
            for (let k = j + 1; k < arr.length; k++) {
                if (arrayObj[k][number] === true) {
                    arrayObj[j][number] = false;
                }
            }
        }
    }
    let validArray = [];
    for (let j = 0; j < arr.length; j++) {
       
        for (const key of Object.keys(arrayObj[j])) {
            if (arrayObj[j][key] === true) {
                validArray.push(Object.keys(arrayObj[j]));
                break;
            }
        }
    }
    validArray=validArray.sort((a,b)=>a.length-b.length);
    for (const element of validArray){
        console.log(element.map(e=>Number(e)).sort((a,b)=>b-a));
    }
}

uniqueSequence(["[7.14, 7.180, 7.339, 80.099]",
"[7.339, 80.0990, 7.140000, 7.18]",
"[7.339, 7.180, 7.14, 80.099]"])