<?php

/**
 * Méthode permettant de détermniner s'il s'agit d'un nombre armstrong
 *
 * @param String $strNumber nombre
 * @return bool true si c'est un nombre armstrong
 */
function isArmstrongNumber($strNumber)
{
    $deg = strlen($strNumber);
    $n = intval($strNumber, 10);
    $sum = 0;

    for ($i = 0; $i < strlen($strNumber); $i++) {
        $digit = intval($strNumber[$i], 10);
        $sum += pow($digit, $deg);
    }

    if ($n == $sum) {
        return 'true';
    } else {
        return 'false';
    }
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(ucfirst(isArmstrongNumber($line)));
    print_r("\n");
}