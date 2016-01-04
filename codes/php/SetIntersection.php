<?php
/**
 * Set Intersection
 *
 * User: jcatric
 * Date: 28/12/15
 * Time: 17:42
 */

function evalLine($line)
{
    $arDatas = explode(';', $line);
    $arLeft = explode(',', $arDatas[0]);
    $arRight = explode(',', $arDatas[1]);

    $arResult = array_intersect($arLeft, $arRight);

    return implode(',', $arResult);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}