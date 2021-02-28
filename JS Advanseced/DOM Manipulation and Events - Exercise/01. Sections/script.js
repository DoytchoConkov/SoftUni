function create(words) {
   const content = document.getElementById('content');
   for (const word of words) {
      let divLine = document.createElement('div');

      let paragraph = document.createElement('p');
      paragraph.innerText = word;
      paragraph.style.display = "none";
      divLine.appendChild(paragraph);
      content.appendChild(divLine);
   }
   const divElements = document.querySelectorAll('div div');
   for (const divElement of divElements) {
      divElement.addEventListener('click', (e) => {
         e.target.children[0].style.display = 'block';

      })
   }
}