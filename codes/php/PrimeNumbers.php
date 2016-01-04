<?php

function isPrime($n)
{
    $limit = ceil(sqrt($n));

    for ($i = 3; $i <= $limit; $i += 2) {
        if ($n % $i == 0) {
            return false;
        }
    }

    return true;
}

function getPrimeNumbers($max)
{
    $result = '2';

    $nbr = 2;
    while ($nbr <= $max) {
        if ($nbr % 2 != 0) {
            if (isPrime($nbr)) {
                $result .= ',' . $nbr;
            }
        }

        $nbr++;
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    $max = intval($line, 10);

    if ($max > 2) {
        print_r(getPrimeNumbers($max));
    }

    print_r("\n");
}