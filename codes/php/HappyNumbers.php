<?php

function evalLine($line)
{
    $n = intval($line, 10);

    return isHappyNumber($n);
}

function isHappyNumber($n) {
    $arNumbers = array();

    while (!in_array($n, $arNumbers)) {
        array_push($arNumbers, $n);

        if ($n != 1) {
            $sum = 0;
            $strNum = "$n";

            for ($i=0; $i < strlen($strNum); $i++) {
                $digit = intval($strNum[$i], 10);
                $sum += pow($digit, 2);
            }

            $n = $sum;
        } else {
            return 1;
        }
    }

    return 0;
}


//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}