function createArticle() {
	const title = document.getElementById('createTitle');
	const content = document.getElementById('createContent');
	const articlesList = document.getElementById('articles');

	if (title.value !== '' && content.value !== '') {
		const article = document.createElement('article');
		const h3 = document.createElement('h3');
		const p = document.createElement('p');
		article.appendChild(h3);
		article.appendChild(p);
		articlesList.appendChild(article);
		h3.innerText = title.value;
		p.innerText = content.value;
		title.value = '';
		content.value = '';
	}
}