function solve() {
   const searchButton = document.querySelector('#searchBtn');
   const textSearch = document.getElementById('searchField');
   searchButton.addEventListener('click', () => {
      const tableBody = document.querySelector('tbody');
      const elements = tableBody.querySelectorAll('td')
      for (const element of elements) {
         if (element.innerText.includes(textSearch.value)) {
            element.parentNode.classList.add('select');
            console.log(element.parentNode);
         }
      }
   })
}