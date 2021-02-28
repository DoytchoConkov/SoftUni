function solve() {
    let input = document.querySelectorAll('input');
    let onScrBtn = document.querySelector('button');
    let sections = document.querySelectorAll('section');
    let movieSection = sections[0].children[1];
    let archiveSection = sections[1].children[1];

    let name = input[0];
    let hall = input[1];
    let price = input[2];

    onScrBtn.addEventListener('click', (e) => {
        e.preventDefault();
        console.log(name.value);
        if (name.value === '' || hall.value === '' || price.value === '') {
            return
        } else {
            let li = document.createElement('li');
            let span = document.createElement('span');
            span.textContent = name.value;
            let strong = document.createElement('strong');
            strong.textContent = 'Hall: ' + hall.value;
            let div = document.createElement('div');
            let strong2 = document.createElement('strong');
            strong2.textContent = price.value;
            let input = document.createElement('input');
            input.placeholder = 'Tickets Sold';
            let archBtn = document.createElement('button');
            archBtn.textContent = 'Archive';

            div.appendChild(strong2);
            div.appendChild(input);
            div.appendChild(archBtn);
            li.appendChild(span);
            li.appendChild(strong);
            li.appendChild(div);
            movieSection.appendChild(li);

            name.value = '';
            hall.value = '';
            price.value = '';

            archBtn.addEventListener('click', e => {
                if (input.value === '' || Number.isNaN(Number(input.value))) {
                    return;
                } else {
                    li.removeChild(div);
                    let delBtn = document.createElement('button');
                    delBtn.textContent = 'Delete';
                    strong.textContent = `Total amount: ${(Number(input.value) * Number(strong2.textContent)).toFixed(2)}`;
                    li.appendChild(delBtn);
                    archiveSection.appendChild(li);

                    delBtn.addEventListener('click', e => {
                        let parent = e.target.parentNode.parentNode;
                        parent.removeChild(li);
                    });
                }
            });
        }
    });
    let clrBtn = sections[1].children[2];
    clrBtn.addEventListener('click', () => { archiveSection.innerHTML = ''; })
}