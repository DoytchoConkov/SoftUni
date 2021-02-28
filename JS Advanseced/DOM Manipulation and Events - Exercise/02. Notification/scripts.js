function notify(message) {
    const notificationMasage = document.getElementById('notification');
    notificationMasage.innerText = message;
    notificationMasage.style.display = 'block';
    setTimeout(() => {
        notificationMasage.style.display = 'none';
    }, 2000);
}