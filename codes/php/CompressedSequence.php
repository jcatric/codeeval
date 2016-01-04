<?php

function getCompressedSequence($line)
{
    $arData = explode(' ', $line);

    $arNumbers = array();
    $arOccurences = array();

    foreach ($arData as $data) {
        $currentNumber = intval($data, 10);

        if (count($arNumbers) == 0 || end($arNumbers) != $currentNumber) {
            array_push($arNumbers, $currentNumber);
            array_push($arOccurences, 1);
        } else {
            $idx = count($arOccurences) - 1;
            $arOccurences[$idx]++;
        }
    }

    $result = '';
    for ($i = 0; $i < count($arNumbers); $i++) {
        if (strlen($result) > 0) {
            $result .= ' ';
        }

        $result .= $arOccurences[$i] . ' ' . $arNumbers[$i];
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(getCompressedSequence($line));
    print_r("\n");
}
