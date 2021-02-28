function attachEventsListeners() {
    const butonDays = document.getElementById('daysBtn');
    const butonHours = document.getElementById('hoursBtn');
    const butonMinutes = document.getElementById('minutesBtn');
    const butonSeconds = document.getElementById('secondsBtn');

    document.getElementById('minutes');;
    butonDays.addEventListener('click', () => {
        let days = document.getElementById('days').value;
        document.getElementById('hours').value = days * 24;
        document.getElementById('minutes').value = days * 24 * 60;
        document.getElementById('seconds').value = days * 3600;
        console.log(days);
    });
    butonHours.addEventListener('click', () => {
        let hours = document.getElementById('hours').value;
        document.getElementById('days').value = hours / 24;
        document.getElementById('minutes').value = hours * 60;
        document.getElementById('seconds').value = hours * 3600;
        console.log(hours);
    });
    butonMinutes.addEventListener('click', () => {
        let minutes = document.getElementById('minutes').value;
        document.getElementById('days').value = minutes / 60 / 24;
        document.getElementById('hours').value = minutes / 60;
        document.getElementById('seconds').value = minutes * 60;
        console.log(hours);
    });
    butonSeconds.addEventListener('click', () => {
        let seconds = document.getElementById('seconds').value;
        document.getElementById('days').value = seconds / 3600 / 24;
        document.getElementById('hours').value = seconds / 3600;
        document.getElementById('minutes').value = seconds / 60;
        console.log(hours);
    });
}