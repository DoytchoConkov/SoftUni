function solve() {
    const form = document.getElementById('container');
    const pets = document.querySelector('#adoption > ul');
    const adoped = document.querySelector('#adopted > ul');

    let [name, age, kind, owner, addBtn] = Array.from(form.children);

    addBtn.addEventListener('click', addPet);

    function addPet(e) {
        e.preventDefault();
        if (!(name.value && Number(age.value) && kind.value && owner.value)) {
            return;
        }
        let li = document.createElement('li');
        let p = document.createElement('p');
        p.innerHTML = `<strong>${name.value}</strong> is a <strong>${age.value}</strong> year old <strong>${kind.value}</strong>`;
        let spanOwner = document.createElement('span');
        spanOwner.textContent = `Owner: ${owner.value}`;
        let contactBtn = document.createElement('button');
        contactBtn.textContent = 'Contact with owner';

        li.appendChild(p);
        li.appendChild(spanOwner);
        li.appendChild(contactBtn);
        pets.appendChild(li);
        contactBtn.addEventListener('click', makeContact)
    }
    function makeContact(e) {
        const parent = e.target.parentElement;
        e.target.remove();
        const takeBtn = document.createElement('button');
        takeBtn.textContent = 'Yes! I take it!';
        const div = document.createElement('div');
        const inputElement = document.createElement('input');
        inputElement.placeholder = 'Enter your names';
        div.appendChild(inputElement);
        div.appendChild(takeBtn);
        parent.appendChild(div);
        takeBtn.addEventListener('click', (e) => {
            if (!inputElement.value) {
                return;
            }
            e.target.textContent = 'Checked';
            adoped.appendChild(e.target.parentElement.parentElement);
            const span = e.target.parentElement.parentElement.querySelector('span');
            span.textContent = `New Owner: ${inputElement.value}`;
            const checkBtn = document.createElement('button');
            checkBtn.textContent = 'Checked';
            e.target.parentElement.parentElement.appendChild(checkBtn);
            e.target.parentElement.remove();
            checkBtn.addEventListener('click', (action) => {
                action.target.parentElement.remove();
            })
        })
    }
}

