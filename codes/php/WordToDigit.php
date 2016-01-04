<?php
/**
 * Word To Digit
 * User: jcatric
 * Date: 28/12/15
 * Time: 19:08
 */

function evalLine($line)
{
    $arNumbers = array(
        'zero' => 0,
        'one' => 1,
        'two' => 2,
        'three' => 3,
        'four' => 4,
        'five' => 5,
        'six' => 6,
        'seven' => 7,
        'eight' => 8,
        'nine' => 9
    );

    $arWords = explode(';', $line);

    $result = '';
    foreach ($arWords as $world) {
        $result .= $arNumbers[$world];
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}