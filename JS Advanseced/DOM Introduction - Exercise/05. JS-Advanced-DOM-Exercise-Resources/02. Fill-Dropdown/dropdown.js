function addItem() {
    const newItemText = document.getElementById('newItemText').value;
    const newItemValue = document.getElementById('newItemValue').value;
    let option = document.createElement('option');
    console.log(newItemText);
    console.log(newItemValue);
    option.textContent = newItemText;
    option.value = newItemValue;
    let menu = document.getElementById('menu');
    menu.appendChild(option);
    document.getElementById('newItemText').value='';
    document.getElementById('newItemValue').value='';
}