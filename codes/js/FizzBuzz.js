var fs = require("fs");

fs.readFileSync(process.argv[2]).toString().split('\n').forEach(function (line) {
    line = line.trim();
    if (line !== "") {
        console.log(evalLine(line));
    }
});

function evalLine(line) {
    var arDatas = line.split(' ');

    if (isNaN(arDatas[0]) || isNaN(arDatas[1]) || isNaN(arDatas[2])) {
        return "x, y and n must be number";
    }

    var x = parseInt(arDatas[0], 10);
    var y = parseInt(arDatas[1], 10);
    var n = parseInt(arDatas[2], 10);

    if (x < 1 || x > 20) {
        return "x must be in range [1, 20]";
    }

    if (y < 1 || y > 20) {
        return "y must be in range [1, 20]";
    }

    if (n < 21 || n > 100) {
        return "n must be in range [21, 100]";
    }

    return getFizzBuzz(x, y, n);
}

function getFizzBuzz(x, y, n) {
    var result = '';

    for (var i = 1; i <= n; i++) {

        if ((i % x === 0) && (i % y === 0)) {
            result += 'FB';
        } else if (i % x === 0) {
            result += 'F';
        } else if (i % y === 0) {
            result += 'B';
        } else {
            result += i;
        }

        result += ' ';
    }

    return result.trim();
}