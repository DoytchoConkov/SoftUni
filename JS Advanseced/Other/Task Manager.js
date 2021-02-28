function solve() {
    let sections = document.querySelectorAll('section');
    let addBtn = document.querySelector('#add');
    let task = document.querySelector('#task');
    let description = document.querySelector('#description');
    let date = document.querySelector('#date');

    let openSection = sections[1].querySelectorAll('div')[1];
    let progresSection = sections[2].querySelectorAll('div')[1];
    let completeSection = sections[3].querySelectorAll('div')[1];

    addBtn.addEventListener('click', (e) => {
        e.preventDefault();
        if (task.value !== '' && description.value !== '' && date.value !== '') {
            let article = document.createElement('article');
            let h3 = document.createElement('h3');
            h3.textContent = task.value;
            let p1 = document.createElement('p');
            p1.textContent = 'Description: ' + description.value;
            let p2 = document.createElement('p');
            p2.textContent = 'Due Date: ' + date.value;
            let div = document.createElement('div');
            div.classList = 'flex';
            let startBtn = document.createElement('button');
            startBtn.textContent = 'Start';
            startBtn.classList = 'green';
            let deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Delete';
            deleteBtn.classList = 'red';
            let finishBtn = document.createElement('button');
            finishBtn.textContent = 'Finish';
            finishBtn.classList = 'orange';

            div.appendChild(startBtn);
            div.appendChild(deleteBtn);
            article.appendChild(h3);
            article.appendChild(p1);
            article.appendChild(p2);
            article.appendChild(div);
            openSection.appendChild(article);

            startBtn.addEventListener('click', () => {
                progresSection.appendChild(article);
                startBtn.remove();
                div.appendChild(finishBtn);
            });

            deleteBtn.addEventListener('click', () => {
                article.remove();
            });

            finishBtn.addEventListener('click', () => {
                completeSection.appendChild(article);
                div.remove();
            });
        }
    });
}