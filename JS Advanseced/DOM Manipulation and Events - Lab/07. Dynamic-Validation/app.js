function validate() {
    const reg = /[a-z]+@[a-z]+.[a-z]/;
    let email = document.getElementById('email');
    email.addEventListener('change', (e) => {
        if (reg.test(e.target.value)) {
            return;
        } else {
            console.log(e);
            e.target.className = 'error';
        }
    });
}