
/**
 * Function to reverse a string
 *
 * @param s the string to reverse
 *
 * @returns {string} the string reversed
 */
function strrev(s) {
    var r = '';

    for (var i = s.length -1; i >=0; i--) {
        r += s[i];
    }

    return r;
}

//Le plus grand palindrome d'un nombre premier
var palindrome = '';

var nbr = 2;
while (nbr < 1000) {
    var estPremier = true;
    var limit = Math.sqrt(nbr);
    limit = Math.ceil(limit);

    for (var i = 2; i <= limit; i++) {
        if (nbr % i === 0) {
            estPremier = false;
            break;
        }
    }

    if (estPremier) {
        var strNum = '' + nbr;

        if (strNum.length === 1) {
            palindrome = strNum;
        } else {
            var left = null;
            var right = null;
            var q = (strNum.length / 2 >> 0); //Division entiere

            if (strNum.length % 2 === 0) {
                left = strNum.substring(0, q);
                right = strNum.substring(q, strNum.length);
            } else {
                left = strNum.substring(0, q);
                right = strNum.substring(q + 1, strNum.length);
            }

            if (left == strrev(right)) {
                palindrome = strNum;
            }
        }
    }

    nbr++;
}

console.log(palindrome);
