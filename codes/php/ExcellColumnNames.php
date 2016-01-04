<?php

function evalLine($line)
{
    $n = intval($line, 10);

    return getExcellColumnNames($n);
}

function getExcellColumnNames($n)
{
    $res = '';

    while ($n > 0) {
        // modulo
        $mod = $n % 26;

        if ($mod == 0) {
            $res .= 'Z';
            $n = (int)($n / 26);
            $n = $n - 1;
        } else {
            $res .= chr(64 + $mod); // int to char
            $n = (int)($n / 26);
        }

    }

    return strrev($res);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r(PHP_EOL);
}