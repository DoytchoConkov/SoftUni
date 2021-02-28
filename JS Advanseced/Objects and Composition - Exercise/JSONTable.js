function jsonTable(arr) {
    let result = '<table>\n';
    for (const line of arr) {
        result += '\t<tr>\n';
        let obj = (JSON.parse(line));
        for (const key of Object.keys(obj)) {
            result = result + '\t\t<td>' + obj[key] + '</td>\n';
        }
        result += '\t</tr>\n';
    }
    result += '</table>';
    console.log(result);
}

jsonTable(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}'])