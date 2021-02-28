function JSONtoHTML(json) {
    let arr = JSON.parse(json);
    let titles = Object.keys(arr[0]);
    let result = '<table>\n<tr>';
    for (let i = 0; i < titles.length; i++) {
        result = result + `<th>${titles[i]}</th>`;
    }
    result += '</tr>\n';
    for (let i = 0; i < arr.length; i++) {
        result+='<tr>'
        for (let j = 0; j < titles.length; j++) {
            let element=''+arr[i][titles[j]];
            result = result + '<td>' + element.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;").replace(/'/g,"&#39;") + '</td>';
        }
        result += '</tr>\n';
    }
    result+='</table>';
    console.log(result);
}
JSONtoHTML(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]'])