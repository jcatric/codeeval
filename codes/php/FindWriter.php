<?php

function findWriter($line)
{
    $arData = explode('|', $line);
    $letters = $arData[0];
    $arNumbers = explode(' ', trim($arData[1]));

    $result = '';

    foreach ($arNumbers as $number) {
        $num = intval($number, 10);
        $result .= $letters[$num - 1];
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(findWriter($line));
    print_r("\n");
}
