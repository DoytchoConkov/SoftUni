function scoreToHTML(input) {
    let obj = JSON.parse(input);
    let keysArr = Object.keys(obj[0]);
    let result = '<table>\n<tr>';
    for (const key of keysArr) {
        result += '<th>' + key + '</th>';
    }
    result += '</tr>\n';
    for (const line of obj) {
        result += '<tr>';
        for (const key of keysArr) {
            let element=''+line[key];
            result += '<td>' + element.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;").replace(/'/g,"&#39;") + '</td>';
        }
        result += '</tr>\n';
    }
    result += '</table>';
    console.log(result);
}


scoreToHTML(['[{"name":"Pesho","score":479},{"name":"Gosho","score":205}]'])
// .replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;").replace(/'/g,"&#39;")