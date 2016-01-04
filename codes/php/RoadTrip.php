<?php

function evalLine($line)
{
    // Suppression du ; qui traine en fin de ligne
    $line = rtrim($line, ';');

    //On a pas besoin des nom de villes donc on vire
    $line = preg_replace('/[^0-9;]/', '', $line);

    // transformation de la ligne en un tableau en découpant par rapport au ;
    $arDistance = array_map('intval', explode(';', $line));

    sort($arDistance, SORT_NUMERIC);

    $result = $arDistance[0];
    for ($i = 1; $i<count($arDistance); $i++) {
        $result .= ',';
        $result .= abs($arDistance[$i-1] - $arDistance[$i]);
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);

    if (strlen($line) > 0) {
        print_r(evalLine($line));
    }

    print_r(PHP_EOL);
}