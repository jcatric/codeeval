<?php

function evalLine($line)
{
    $arDatas = explode(',', $line);

    $x = intval($arDatas[0], 10);
    $n = intval($arDatas[1], 10);

    return getMultiplesNumber($x, $n);
}

function getMultiplesNumber($x, $n)
{
    $i = 1; //multiple
    $mul = $n;
    while ($x > $mul) {
        // Calcul multiple de n
        $mul = $n * $i;
        // Incrémentation du multiple de n
        $i++;
    }

    return $mul;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}