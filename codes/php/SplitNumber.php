<?php
/**
 * Split Number
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:01
 */

function evalLine($line)
{
    $arData = explode(' ', $line);

    $res = 0;

    if (preg_match('/\-/', $arData[1])) {
        $pos = strpos($arData[1], '-');

        $a = substr($arData[0], 0, $pos);
        $b = substr($arData[0], $pos, strlen($arData[0]));

        $res = intval($a, 10) - intval($b, 10);

    } else if (preg_match('/\+/', $arData[1])) {
        $pos = strpos($arData[1], '+');

        $a = substr($arData[0], 0, $pos);
        $b = substr($arData[0], $pos, strlen($arData[0]));

        $res = intval($a, 10) + intval($b, 10);
    }

    return $res;

}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}