<?php

function evalLine($line)
{
    $n = intval($line, 10);

    return calculateFibonacciSeries($n);
}

function calculateFibonacciSeries($n)
{
    if ($n == 0) {
        return 0;
    } else if ($n == 1) {
        return 1;
    } else {
        return calculateFibonacciSeries($n - 2) + calculateFibonacciSeries($n - 1);
    }
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}