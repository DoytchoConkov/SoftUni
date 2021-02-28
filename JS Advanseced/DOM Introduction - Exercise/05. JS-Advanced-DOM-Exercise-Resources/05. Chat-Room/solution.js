function solve() {
   const button = document.getElementById('send');

   button.addEventListener('click', () => {
      const text = document.getElementById('chat_input');
      if (text.value !== '') {
         let chatBody = document.getElementById('chat_messages');
         let newLine = document.createElement('div');
         newLine.setAttribute("class", "message my-message");
         newLine.innerText = text.value;
         chatBody.appendChild(newLine);
         text.value = '';
      }
   })
}


