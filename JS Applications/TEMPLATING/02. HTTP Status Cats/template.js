const source = document.getElementById('cat-template').textContent;
template = Handlebars.compile(source);
const resultHTML = template({ cats });
const section = document.getElementById('allCats');
section.innerHTML = resultHTML;
addEventLisener();

function addEventLisener() {
    section.addEventListener('click', (e) => {
        const { target } = e;
        if (target.nodeName === "BUTTON" && target.className === "showBtn") {
            let divStatus = target.parentElement.querySelector('div.status');
            if (divStatus.style.display === "block") {
                divStatus.style.display = "none";
                e.target.textContent = "Show status code";
            } else {
                divStatus.style.display = "block";
                e.target.textContent = "Hide status code";
            }
        }
    })
}