var fs = require("fs");

fs.readFileSync(process.argv[2]).toString().split('\n').forEach(function (line) {
    line = line.trim();
    if (line !== "") {
        console.log(evalLine(line));
    }
});

function evalLine(line) {
    if (isNaN(line)) {
       return "It's not a number";
    }

    var age = parseInt(line, 10);

    var result = '';

    if (age < 0 || age > 100) {
        result = 'This program is for humans';
    } else {
        if (age <= 2) {
            result = 'Still in Mama\'s arms';
        } else if (age <= 4) {
            result = 'Preschool Maniac';
        } else if (age <= 11) {
            result = 'Elementary school';
        } else if (age <= 14) {
            result = 'Middle school';
        } else if (age <= 18) {
            result = 'High school';
        } else if (age <= 22) {
            result = 'College';
        } else if (age <= 65) {
            result = 'Working for the man';
        } else if (age <= 100) {
            result = 'The Golden Years';
        }
    }

    return result;
}