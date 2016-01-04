<?php

function evalLine($line)
{
    $arDara = explode(',', $line);

    $arWords = array();
    $arNumbers = array();

    foreach ($arDara as $data) {
        if (preg_match('/^[a-zA-Z]+$/', $data)) {
            array_push($arWords, $data);
        } else if (preg_match('/^[0-9]+$/', $data)) {
            array_push($arNumbers, $data);
        }
    }

    $result = implode(',', $arWords);

    if (count($arWords) > 0 && count($arNumbers) > 0 ) {
        $result .= '|';
    }

    $result .= implode(',', $arNumbers);

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}