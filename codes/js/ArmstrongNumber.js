var fs = require("fs");

fs.readFileSync(process.argv[2]).toString().split('\n').forEach(function (line) {
    line = line.trim();
    if (line !== "") {
        console.log(evalLine(line));
    }
});

function evalLine(line) {
    if (isNaN(line)) {
        return "It must be number";
    }

    return isArmstrongNumber(line);
}

/**
 * Determine s'il sagit d'un nombre armstrong
 *
 * @param strNumber le nombre a tester
 *
 * @returns {String} True si s'est un nombre amstrong, False sinon
 */
function isArmstrongNumber(strNumber) {
    var deg = strNumber.length;
    var n = parseInt(strNumber, 10);

    var sum = 0;
    for (var i = 0; i < strNumber.length; i++) {
        sum += Math.pow(parseInt(strNumber[i], 10), deg);
    }

    if (n === sum) {
        return 'True';
    } else {
        return 'False';
    }
}