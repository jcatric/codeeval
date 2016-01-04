<?php

function evalLine($line)
{
    $arWords = explode(' ', $line);

    $result = '';
    foreach ($arWords as $word) {
        if (strlen($word) > strlen($result)) {
            $result = $word;
        }
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}