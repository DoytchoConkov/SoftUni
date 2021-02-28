function stopwatch() {
    let startBut = document.getElementById('startBtn');
    let endBut = document.getElementById('stopBtn');
    startBut.addEventListener('click', () => {
        endBut.disabled = false;
        startBut.disabled = true;
        document.getElementById('time').innerText = '00:00';
        let seconds = 0;
        let minutes = 0;
        let myWatch = setInterval(timer, 1000);
        function timer() {
            seconds++;
            if (seconds === 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes < 10) {
                minutes = '0' + Number(minutes);
            }
            if (seconds < 10) {
                seconds = '0' + seconds;
            }
            document.getElementById('time').innerText = minutes + ':' + seconds;
        }
        endBut.addEventListener('click', () => {
            endBut.disabled = true;
            startBut.disabled = false;
            clearInterval(myWatch);
            // document.getElementById('time').innerText = '00:00';
        });
    });
}