function solve() {
   let creator = document.getElementById('creator');
   let title = document.getElementById('title');
   let category = document.getElementById('category');
   let content = document.getElementById('content');
   let createBtn = document.querySelector('.btn.create');
   let archives = document.querySelector('h2')
   let arch = document.getElementsByClassName('archive-section')[0];


   createBtn.addEventListener('click', (e => {
      e.preventDefault();
      if (creator.value === '' || title.value === '' || category.value === '' || content.value === '') { return; }
      let article = document.createElement('article');
      let h1 = document.createElement('h1');
      h1.textContent = title.value;
      article.appendChild(h1);
      let p1 = document.createElement('p');
      p1.textContent = `Category:`;
      let strong1 = document.createElement('strong');
      strong1.textContent = category.value;
      p1.appendChild(strong1);
      article.appendChild(p1);
      let p2 = document.createElement('p');
      p2.textContent = `Creator:`;
      let strong2 = document.createElement('strong');
      strong2.textContent = creator.value;
      p2.appendChild(strong2);
      article.appendChild(p2);
      let p3 = document.createElement('p');
      p3.textContent = content.value;
      article.appendChild(p3);
      let divBtn = document.createElement('div');
      divBtn.classList = 'buttons';
      let deleteBtn = document.createElement('button');
      deleteBtn.textContent = 'Delete';
      deleteBtn.classList = 'btn delete';
      divBtn.appendChild(deleteBtn);
      let archiveBtn = document.createElement('button');
      archiveBtn.textContent = 'Archive';
      archiveBtn.classList = 'btn archive';
      divBtn.appendChild(archiveBtn);
      article.appendChild(divBtn);
      archives.parentElement.appendChild(article);

      deleteBtn.addEventListener('click', e => e.target.parentElement.parentElement.remove());

      archiveBtn.addEventListener('click', e => {
         let parent = e.target.parentNode.parentNode;
         let name = parent.querySelector('h1');
         let li = document.createElement('li');
         li.textContent = name.textContent;
         let ul = arch.querySelector('ul');
         ul.appendChild(li);
         console.log(ul.getElementsByTagName('li'));
         let sorted = Array.from(ul.getElementsByTagName('li')).sort((a, b) => a.textContent.localeCompare(b.textContent));
         console.log(sorted);
         while (ul.firstChild) {
            ul.removeChild(ul.firstChild);
         }
         sorted.forEach(e => ul.appendChild(e));
         e.target.parentElement.parentElement.remove()
      });
   }));

}
