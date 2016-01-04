<?php

function evalLine($line)
{
    $arDatas = explode(' ', $line);

    if (count($arDatas) == 0) {
        $result = '';
    } else if (count($arDatas) == 1) {
        $result = $arDatas[0];
    } else {
        $result = $arDatas[count($arDatas) - 2];
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