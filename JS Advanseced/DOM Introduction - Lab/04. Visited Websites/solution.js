function solve() {
  const visitedSites = document.querySelectorAll('.link-1');
  for (let site of visitedSites) {
    site.addEventListener('click', () => {
      let counterTextElement = site.children[1];
      let counterText=counterTextElement.innerText.toString();
      let counter=counterText.match(/\d+/)[0];
      console.log(counter);
      counterText=counterText.replace(counter,(Number(counter)+1).toString());
      counterTextElement.innerText=counterText;
    })
  }
}