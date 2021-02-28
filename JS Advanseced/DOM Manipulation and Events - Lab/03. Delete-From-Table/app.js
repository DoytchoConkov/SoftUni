function deleteByEmail() {
    let text = document.querySelector('input').value;
    let tableElements = document.querySelectorAll('td');
let flag=false;
    for (let element of tableElements) {
        if (text === element.innerText) {
            element.parentElement.remove();
            flag=true;
        }
    }
    if (!flag){
        document.getElementById('result').innerText='Not found.';
    }else {
        document.getElementById('result').innerText='';
    }
    document.querySelector('input').value='';
}