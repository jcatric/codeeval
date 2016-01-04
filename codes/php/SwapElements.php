<?php
/**
 * Swap Elements
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:50
 */

function evalLine($line)
{
    $arDatas = explode(':', $line);

    // La chaine de caractères que l'on souhaite échanger les éléments
    $arElements = explode(' ', trim($arDatas[0]));

    // Les paramètres d'inversion
    $arMixed = explode(',', str_replace(' ', '', $arDatas[1]));

    foreach ($arMixed as $mixed) {
        $arPos = array_map('intval', explode('-', $mixed));
        $tmp = $arElements[$arPos[0]];
        $arElements[$arPos[0]] = $arElements[$arPos[1]];
        $arElements[$arPos[1]] = $tmp;
    }

    return implode(' ', $arElements);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}