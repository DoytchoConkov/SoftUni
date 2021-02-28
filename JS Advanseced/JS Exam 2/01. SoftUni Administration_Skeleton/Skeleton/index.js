function solve() {
    let inputs = document.querySelector('form').querySelectorAll('input');
    let module = document.querySelector('form').querySelector('select');
    let addBtn = document.querySelector('form').querySelector('button');
    addBtn.addEventListener('click', e => {
        e.preventDefault();
        if (inputs[0].value === '' || inputs[1].value === '' || module.value === 'Select module') {
            return;
        }
        let trainings = document.querySelectorAll('section')[0].querySelector('div');
        let h3Array = trainings.getElementsByTagName('h3');
        let index = -1
        for (let i = 0; i < h3Array.length; i++) {
            if (h3Array[i].textContent === module.value.toUpperCase() + "-MODULE") {
                index = i;
                break;
            }
        }
        if (index > -1) {
            let ul = document.createElement('ul');
            let li = document.createElement('li');
            li.classList = 'flex';
            let h4 = document.createElement('h4');
            h4.textContent = inputs[0].value + ' - ' + inputs[1].value.replace(/^(\d{4})-(\d{2})-(\d{2})T(\d{2}:\d{2})$/, "$1\/$2\/$3 - $4");
            let delBtn = document.createElement('button');
            delBtn.classList = 'red';
            delBtn.textContent = 'Del';
            li.appendChild(h4);
            li.appendChild(delBtn);
            ul.appendChild(li);
            let abc = h3Array[index].parentElement;
            abc.appendChild(ul);
            delBtn.addEventListener('click', e => {
                let toDel = e.target.parentElement;
                console.log(toDel.parentElement.querySelectorAll('div').length)
                if (toDel.querySelectorAll('div').length = 0) {
                    toDel.parentElement.remove();
                    let mModule = toDel.parentElement.parentElement;
                } else {
                    let mModule = toDel.parentElement;
                    mModule.remove();
                }
            });
            let ulArray = abc.querySelectorAll('ul');
            let ul2 = []
            for (let i = 0; i < ulArray.length; i++) {
                ul2.push(ulArray[i]);
            }
            let ul3 = ul2.sort((a, b) => {
                let a1 = a.querySelector('h4').textContent;
                a1 = a1.slice(a1.length - 16, a1.length - 8);
                let b1 = b.querySelector('h4').textContent;
                b1 = b1.slice(b1.length - 16, b1.length - 8);
                return a1.localeCompare(b1);
            })
            for (let i = 0; i < ul3.length; i++) {
                abc.parentElement.appendChild(ul3[i]);
            }
        } else {
            let div = document.createElement('div');
            div.classList = 'module';
            let h3 = document.createElement('h3');
            h3.textContent = module.value.toUpperCase() + "-MODULE";
            let ul = document.createElement('ul');
            let li = document.createElement('li');
            li.classList = 'flex';
            let h4 = document.createElement('h4');
            h4.textContent = inputs[0].value + ' - ' + inputs[1].value.replace(/^(\d{4})-(\d{2})-(\d{2})T(\d{2}:\d{2})$/, "$1\/$2\/$3 - $4");
            let delBtn = document.createElement('button');
            delBtn.classList = 'red';
            delBtn.textContent = 'Del';
            li.appendChild(h4);
            li.appendChild(delBtn);
            ul.appendChild(li);
            div.appendChild(h3);
            div.appendChild(ul);
            trainings.appendChild(div);
            delBtn.addEventListener('click', e => {
                let toDel = e.target.parentElement;
                toDel.parentElement.remove();

                console.log(e.target.parentElement.parentElement)


            });
        }
    });
};