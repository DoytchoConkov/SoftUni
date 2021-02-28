function focus() {
    let elements = document.querySelectorAll('input');
    for (const element of elements) {
        element.addEventListener('focus', (e) => {
            console.log(element);
            element.parentElement.className = 'focused';
        });
        for (const element of elements) {
            element.addEventListener('blur', () => { element.parentElement.classList.remove('focused') });
        }
    }
}