function getArticleGenerator(article) {
    const content = document.querySelector('#content');
    function showNext() {
        if (article.length > 0) {
            const articles = document.createElement('article');
            articles.textContent = article.shift();
            content.appendChild(articles);
        }
    }
    return showNext
}