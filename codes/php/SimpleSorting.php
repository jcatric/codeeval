<?php
/**
 * Simple Sorting
 * User: jcatric
 * Date: 28/12/15
 * Time: 17:55
 */

function evalLine($line)
{
    $arNumbers = explode(' ', $line);

    sort($arNumbers, SORT_NUMERIC);

    return implode(' ', $arNumbers);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}