<?php

function evalLine($line)
{
    $arDatas = explode(',', $line);

    $a = intval($arDatas[0], 10);
    $b = intval($arDatas[1], 10);

    return calculateNmodM($a, $b);
}

function calculateNmodM($a, $b)
{
    $res = 0;

    if ($b != 0) {
        $q = (int)($a / $b);
        $res = $a - ($q * $b);
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