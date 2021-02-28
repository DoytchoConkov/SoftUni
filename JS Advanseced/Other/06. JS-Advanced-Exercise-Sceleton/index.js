function solve() {
   const tb = document.querySelector('tbody');
   const rows=document.querySelectorAll('tr');
   tb.addEventListener('click', (e) => {
      console.log(e.target.parentNode);
      if (e.target.parentNode.nodeName === 'TR') {
         if (e.target.parentNode.style.backgroundColor === '') {
            [...rows].forEach(i=>i.style.backgroundColor='');
            e.target.parentNode.style.backgroundColor = '#413f5e';
         }else {
            e.target.parentNode.style.backgroundColor ='';
         }
      }
   });
}
