<?php

function evalLine($line)
{
    $arDatas = explode(',', $line);

    $n = intval($arDatas[0], 10);
    $p1 = intval($arDatas[1], 10);
    $p2 = intval($arDatas[2], 10);

    return getBitPositions($n, $p1, $p2);
}

function getBitPositions($n, $p1, $p2)
{
    //int to bin
    $nBin = decbin($n);

    if ($nBin[strlen($nBin) - $p1] == $nBin[strlen($nBin) - $p2]) {
        return 'true';
    }

    return 'false';
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}