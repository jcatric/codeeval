<?php
/**
 * Sum Digits.
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:31
 */

function evalLine($line)
{
    $arDigits = array_map('intval', str_split($line));

    return array_sum($arDigits);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}