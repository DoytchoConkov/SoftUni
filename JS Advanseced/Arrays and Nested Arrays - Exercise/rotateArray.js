function rotateArray(arr) {
    let rotation = arr.pop();
    rotation=rotation%arr.length;
    for (let i = 0; i < rotation; i++) {
        let element = arr.pop();
        arr.unshift(element);
    }
    console.log(arr.join(' '));
}

rotateArray(['Banana', 
'Orange', 
'Coconut', 
'Apple', 
'15'])