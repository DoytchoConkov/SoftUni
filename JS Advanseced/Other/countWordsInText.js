function countWordsInText(text) {
    let words = {};
    let wordsArray = text[0].split(/\W+/gm);
    for (const word of wordsArray) {
        if (word.length > 0) {
            if (words[word] === undefined) {
                words[word] = 1;
            } else {
                words[word]++;
            }
        }
    }
    console.log(JSON.stringify(words));

}

countWordsInText(["Far too slow, you're far too slow."]);