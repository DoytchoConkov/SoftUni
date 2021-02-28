function solve() {
    const button = document.getElementById('btnLoadTowns');
    button.addEventListener('click', loadForm);
    function loadForm(e) {
        e.preventDefault();
        const towns = document.getElementById('towns').value.split(', ');
        getTemplate().then(res => {
            const template = Handlebars.compile(res);
            const resultHTML = template({ towns });
            const div = document.getElementById('root');
            div.innerHTML = resultHTML;
        });
    }

    function getTemplate() {
        return fetch('./template.nbs').then(res => res.text())
    }
}

solve()