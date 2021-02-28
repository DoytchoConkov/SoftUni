import monkeys from './monkeys.js';

const monkeysBody = document.querySelector('div.monkeys');
const source = document.getElementById('monkey-template').textContent;
const template = Handlebars.compile(source);
const resultHTML = template({ monkeys });
monkeysBody.innerHTML = resultHTML;

addEventLisener();

function addEventLisener() {
    monkeysBody.addEventListener('click', (e) => {
        const { target } = e;
        if (target.nodeName !== "BUTTON") {
            return
        }
        const infoTab = target.parentNode.querySelector('p');
        if (infoTab.style.display === "block") {
            infoTab.style.display = "none";
            e.target.textContent = "Info";
        } else {
            infoTab.style.display = "block";
            e.target.textContent = "Hide";
        }

    });
}