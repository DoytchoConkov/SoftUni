function solution() {
    let sections = document.querySelectorAll('section');
    let giftName = sections[0].querySelector('input');
    let addBtn = sections[0].querySelector('button');
    let giftList = sections[1].querySelector('ul');
    let sendGifts = sections[2].querySelector('ul');
    let discardGifts = sections[3].querySelector('ul');

    addBtn.addEventListener('click', e => {
        e.preventDefault();
        if (giftName.value === '') { return; }
        let li = document.createElement('li');
        li.textContent = giftName.value;
        let sendBtn = document.createElement('button');
        sendBtn.textContent = 'Send'
        sendBtn.id='sendButton'
        let discardBtn = document.createElement('button');
        discardBtn.textContent = 'Discard';
        discardBtn.id='discardButton';
        li.appendChild(sendBtn);
        li.appendChild(discardBtn);

        giftList.appendChild(li);
        let sorted = Array.from(giftList.getElementsByTagName('li')).sort((a, b) => a.textContent.localeCompare(b.textContent));
        while (giftList.firstChild) {
            giftList.removeChild(giftList.firstChild);
        }
        sorted.forEach(e => giftList.appendChild(e));
        giftName.value = '';

        sendBtn.addEventListener('click', e=>{
            let parent=e.target.parentNode;
            parent.removeChild(parent.lastChild);
            parent.removeChild(parent.lastChild);
            let gift=parent.textContent
            parent.remove();
            let li=document.createElement('li');
            li.classList='gift';
            li.textContent=gift;
            sendGifts.appendChild(li);
        });

        discardBtn.addEventListener('click', e=>{
            let parent=e.target.parentNode;
            parent.removeChild(parent.lastChild);
            parent.removeChild(parent.lastChild);
            let gift=parent.textContent
            parent.remove();
            let li=document.createElement('li');
            li.classList='gift';
            li.textContent=gift;
            discardGifts.appendChild(li);
        });
    })
}