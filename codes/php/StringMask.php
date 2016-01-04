<?php
/**
 * String Mask
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:23
 */

function evalLine($line)
{
    $arDatas = explode(' ', $line);
    $letters = str_split($arDatas[0]);
    $digits = array_map('intval', str_split($arDatas[1]));

    $result = '';
    for ($i = 0; $i < count($digits); $i++) {

        if ($digits[$i]) {
            $result .= strtoupper($letters[$i]);
        } else {
            $result .= strtolower($letters[$i]);
        }
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