<?php

function getHiddenDigits($line)
{
    $letters = array(
        'a' => 0,
        'b' => 1,
        'c' => 2,
        'd' => 3,
        'e' => 4,
        'f' => 5,
        'g' => 6,
        'h' => 7,
        'i' => 8,
        'j' => 9,
    );

    $result = '';

    for ($i = 0; $i < strlen($line); $i++) {
        if (preg_match('/[abcdefghij]/', $line[$i])) {
            $result .= $letters[$line[$i]];
        } else if(preg_match('/[0-9]/', $line[$i])) {
            $result .= $line[$i];
        }
    }

    if (strlen($result) == 0) {
        $result = 'NONE';
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(getHiddenDigits($line));
    print_r("\n");
}