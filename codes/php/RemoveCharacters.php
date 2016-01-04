<?php

function evalLine($line)
{
    $arDatas = explode(',', $line);

    $pattern = '/['. trim($arDatas[1]) .']/';

    return preg_replace($pattern, '', $arDatas[0]);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}

