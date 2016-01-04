<?php

function evalLine($line)
{
    $arLetterCount = array(
        'A' => 0, 'B' => 0, 'C' => 0, 'D' => 0, 'E' => 0, 'F' => 0, 'G' => 0, 'H' => 0, 'I' => 0,
        'J' => 0, 'K' => 0, 'L' => 0, 'M' => 0, 'N' => 0, 'O' => 0, 'P' => 0, 'Q' => 0, 'R' => 0,
        'S' => 0, 'T' => 0, 'U' => 0, 'V' => 0, 'W' => 0, 'X' => 0, 'Y' => 0, 'Z' => 0
    );

    $line = strtoupper($line);
    for ($i = 0;  $i < strlen($line); $i++) {
        $letter =$line[$i];

        if (preg_match('/[A-Z]/', $letter)) {
            if (array_key_exists($letter, $arLetterCount)) {
                $arLetterCount[$letter]++;
            }
        }
    }

    rsort($arLetterCount, SORT_NUMERIC);

    //beauty of the current letter
    $letterValue = 26;

    $result = 0;
    foreach ($arLetterCount as $value) {
        $result += $letterValue * $value;
        $letterValue--;
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