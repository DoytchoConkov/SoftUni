function attachGradientEvents() {
    let mousePosition = document.getElementById('gradient');
    mousePosition.addEventListener('mousemove', (e) => {
        let gradient = Math.trunc((e.offsetX / (e.target.clientWidth - 1)) * 100);
        document.getElementById('result').textContent = gradient + '%';
    });
    mousePosition.addEventListener('mouseout', () => {
        document.getElementById('result').textContent = '';
    });
}