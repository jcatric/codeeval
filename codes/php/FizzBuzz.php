<?php

function evalLine($line)
{
    $arDatas = explode(' ', $line);
    $x = intval($arDatas[0], 10);
    $y = intval($arDatas[1], 10);
    $n = intval($arDatas[2], 10);

    return getFizzBuzz($x, $y, $n);
}

function getFizzBuzz($x, $y, $n)
{
    $result = '';

    for ($i = 1; $i <= $n; $i++) {
        if (($i % $x == 0) && ($i % $y == 0)) {
            $result .= 'FB';

        } else if ($i % $x == 0) {
            $result .= 'F';
        } else if ($i % $y == 0) {
            $result .= 'B';
        } else {
            $result .= $i;
        }
        $result .= ' ';
    }

    return trim($result);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}