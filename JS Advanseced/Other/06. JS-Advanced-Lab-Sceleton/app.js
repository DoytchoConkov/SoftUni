function solve() {
    const elements = document.getElementById('dropdown-ul');
    window.addEventListener('click', function (e) {
        console.log(e.target);
        if (e.target.id === 'dropdown') {
            elements.style.display = 'block';
            return;
        }
        if (e.target.parentNode.id === 'dropdown-ul') {
            const boxStyle = e.target.textContent;
            document.getElementById('box').style.backgroundColor = boxStyle;
            document.getElementById('box').style.color=black;
        }
        elements.style.display = '';
    });
}