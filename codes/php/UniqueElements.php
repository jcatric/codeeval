<?php
/**
 * Unique Elements
 * User: jcatric
 * Date: 28/12/15
 * Time: 19:04
 */

function evalLine($line)
{
    $arNumbers = array_map('intval', explode(',', $line));

    return implode(',', array_unique($arNumbers));
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}