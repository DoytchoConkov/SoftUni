function solve() {
    const button = document.querySelector('button');
    button.addEventListener('click', function () {
        let name = document.querySelector('input').value;
        if (name !== "") {
            let leter=name.toUpperCase().charCodeAt(0);
            let list = document.querySelectorAll('li');
            let text = list[leter - 65].textContent ;
            let name2=name.slice(1).toLowerCase();
            if (text === "") {
                list[leter - 65].textContent  = name[0].toUpperCase()+name2;
            } else {
                list[leter - 65].textContent  = text + ', ' + name[0].toUpperCase()+name2;
            }
        }
        document.querySelector('input').value = "";
    })
}