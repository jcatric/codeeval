<?php

function capitalizeWords($line)
{
    $result = '';
    $words = explode(' ', $line);

    foreach ($words as $word) {
        if (strlen($result) > 0) {
            $result .= ' ';
        }

        $result .= ucfirst($word);
    }

    return $result;
}


//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(capitalizeWords($line));
    print_r("\n");
}