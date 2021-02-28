function solve() {
    const menuTo = document.getElementById('selectMenuTo');
    menuTo.innerHTML = 0;
    let lineBinary = document.createElement('option');
    lineBinary.innerText = 'Binary';
    lineBinary.value = 'binary';
    menuTo.appendChild(lineBinary);
    let lineHex = document.createElement('option');
    lineHex.innerText = 'Hexadecimal';
    lineHex.value = 'hexadecimal';
    menuTo.appendChild(lineHex);
    let button = document.getElementsByTagName('button')[0];
    button.addEventListener('click', () => {
        let value = Number(document.getElementById('input').value);
        if (value > 0) {
            if (menuTo.value === 'binary') {
                document.getElementById('result').value = value.toString(2);
            } else if (menuTo.value === 'hexadecimal'){
                document.getElementById('result').value = value.toString(16);
            }
        }
    })
}