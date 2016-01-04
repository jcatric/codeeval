<?php

function evalLine($line)
{
    $num = intval($line, 10);

    return getEvenNumbers($num);
}

function getEvenNumbers($num)
{
    if ($num % 2 == 0) {
        return 1;
    } else {
        return 0;
    }
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}