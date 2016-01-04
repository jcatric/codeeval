<?php

function evalLine($line)
{
    $arDatas = explode('|', $line);

    $leftNum = array_map('intval', explode(' ', trim($arDatas[0])));
    $rightNum = array_map('intval', explode(' ', trim($arDatas[1])));

    return getMultiplyLists($leftNum, $rightNum);
}

function getMultiplyLists($arLeft, $arRight)
{
    $result = array();

    for ($i = 0; $i < count($arLeft); $i++) {
        $mul = $arLeft[$i] * $arRight[$i];
        array_push($result, $mul);
    }

    return implode(' ', $result);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}