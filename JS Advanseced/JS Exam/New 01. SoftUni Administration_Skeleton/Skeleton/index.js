function solve() {
    let addBtn = document.querySelector('form').querySelector('button');
    addBtn.addEventListener('click', addLecture);

    function addLecture(e) {
        e.preventDefault();
        let inputs = document.querySelector('form').querySelectorAll('input');
        let lecture = inputs[0].value;
        let date = inputs[1].value.replace(/^(\d{4})-(\d{2})-(\d{2})T(\d{2}:\d{2})$/, "$1\/$2\/$3 - $4");
        let module = document.querySelector('form').querySelector('select').value.toUpperCase() + "-MODULE";
        if (lecture === '' || date === '' || module === 'Select module') {
            return;
        }

        let li = document.createElement('li');
        li.classList = 'flex';
        let h4 = document.createElement('h4');
        h4.textContent = lecture + ' - ' + date;
        let delBtn = document.createElement('button');
        delBtn.classList = 'red';
        delBtn.textContent = 'Del';
        delBtn.addEventListener('click', delBt);
        li.appendChild(h4);
        li.appendChild(delBtn);

        let mainSection = document.querySelector('.modules');
        let modules = mainSection.getElementsByTagName('div');

        let foundH3 = false;
        let modLength = modules.length;
        for (let i = 0; i < modLength; i++) {
            if (modules[i].querySelector('h3').textContent === module) {
                foundH3 = true;
                modules[i].querySelector('ul').appendChild(li);
                let abc = modules[i].querySelector('ul');
                let toSort = abc.querySelectorAll('li');
                let ul2 = []
                for (let i = 0; i < toSort.length; i++) {
                    ul2.push(toSort[i]);
                }
                let ul3 = ul2.sort((a, b) => {
                    let a1 = a.querySelector('h4').textContent;
                    a1 = a1.slice(a1.length - 16, a1.length - 8);
                    let b1 = b.querySelector('h4').textContent;
                    b1 = b1.slice(b1.length - 16, b1.length - 8);
                    return a1.localeCompare(b1);
                })
                for (let i = 0; i < ul3.length; i++) {
                    abc.appendChild(ul3[i]);
                }
            }
        }
        
        if (!foundH3) {
            let div = document.createElement('div');
            div.classList = 'module';
            let h3 = document.createElement('h3');
            h3.textContent = module;
            let ul = document.createElement('ul');
            ul.appendChild(li);
            div.appendChild(h3);
            div.appendChild(ul);
            mainSection.appendChild(div);
        }
    };

    function delBt(e) {
        console.log(e.target.parentElement.parentElement)
        if (e.target.parentElement.parentElement.querySelectorAll('li').length > 1) {
            e.target.parentElement.remove();
        } else { e.target.parentElement.parentElement.parentElement.remove(); }
    }
}
