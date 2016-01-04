<?php

function calculateDistance($line)
{
    $line = preg_replace('/(\s+)/i', '', $line);
    $line = preg_replace('/\)\(/i', ',', $line);
    $line = preg_replace('/(\(|\))/i', '', $line);

    $xy = explode(',', $line);

    $xa = intval($xy[0], 10);
    $ya = intval($xy[1], 10);
    $xb = intval($xy[2], 10);
    $yb = intval($xy[3], 10);

    $ab = sqrt(pow(($xb - $xa), 2) + pow(($yb - $ya), 2));

    return $ab;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(calculateDistance($line));
    print_r("\n");
}