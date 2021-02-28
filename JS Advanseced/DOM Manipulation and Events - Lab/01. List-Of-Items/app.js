function addItem() {
    const text = document.getElementById('newItemText').value;
    let newLine = document.createElement('li');
    newLine.innerText = text;
    document.getElementById('items').appendChild(newLine);
    document.getElementById('newItemText').value='';
}