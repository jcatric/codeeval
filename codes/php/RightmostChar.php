<?php

function evalLine($line)
{
    $arDatas = explode(',', $line);

    $res = strrpos($arDatas[0], $arDatas[1]);

    if ($res) {
        return $res;
    } else {
        return -1;
    }
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}