function lockedProfile() {
    const buttons = document.getElementsByTagName('button');
    for (const btn of buttons) {
        btn.addEventListener('click', (e) => {
            const button = e.target;
            const profile = button.parentNode;
            const information = profile.getElementsByTagName('div')[0];
            const lockStatus = profile.querySelector('input[type="radio"]:checked').value;
            console.log(lockStatus);
            if (lockStatus === 'unlock') {
                if (button.textContent === 'Show more') {
                    information.style.display = 'inline-block';
                    button.textContent = 'Hide it';
                } else if (button.textContent === 'Hide it') {
                    information.style.display = 'none';
                    button.textContent = 'Show more';
                }
            }
        });
    }
}