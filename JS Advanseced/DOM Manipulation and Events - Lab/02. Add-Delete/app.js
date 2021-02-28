function addItem() {
    const text = document.getElementById('newText');
    let resultArea=document.getElementById('items');
    resultArea.addEventListener('click', deleteItem)
    let newLine = document.createElement('li');
    newLine.innerHTML = `${text.value} <a href="#">[Delete]</a>`;
    document.getElementById('items').appendChild(newLine);;
    document.getElementById('newText').value = '';

    function deleteItem(item) {
        console.log(item);
        let element = item.target.parentNode
        element.remove();
    }
}