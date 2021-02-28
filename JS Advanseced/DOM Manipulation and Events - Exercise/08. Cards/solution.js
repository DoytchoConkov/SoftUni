function solve() {
   let firstCard = '';
   let seconCard = '';
   const cards = document.getElementsByTagName('img');
   const spans = document.getElementsByTagName('span');
   for (const card of cards) {
      card.addEventListener('click', () => {
         const player = card.parentElement;
         if (player.id === 'player1Div') {
            spans[0].innerText = card.name;
            firstCard = card;
         } else {
            spans[2].innerText = card.name;
            seconCard = card;
         }
         card.src = 'images/whiteCard.jpg'
         if (spans[0].innerText !== '' && spans[2].innerText !== '') {
            if (Number(spans[0].innerText) > Number(spans[2].innerText)) {
               firstCard.style.border = '2px solid green';
               seconCard.style.border = '2px solid red';
            } else {
               firstCard.style.border = '2px solid red';
               seconCard.style.border = '2px solid green';
            }
            let result = '[' + spans[0].innerText + ' vs ' + spans[2].innerText + '] ';
            console.log(result);
            document.getElementById('history').innerText += result;
            history.innerText = document.getElementById('history');
            spans[0].innerText = '';
            spans[2].innerText = '';
         }
      });
   }
}