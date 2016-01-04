<?php
/**
 * The Major Element
 * User: jcatric
 * Date: 29/12/15
 * Time: 18:43
 */

function evalLine($line)
{
    $arNumbers = array_map('intval', explode(',', $line));


    $arNumberFrequency = array_count_values($arNumbers);
    arsort($arNumberFrequency, SORT_NUMERIC);

    $max = 'NONE';

    foreach ($arNumberFrequency as $number => $frequency) {
         if ($frequency > count($arNumbers) / 2) {
             $max = $number;
        }

        break;
    }

    return $max;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);

    if (strlen($line) > 0) {
        print_r(evalLine($line));
    }

    print_r(PHP_EOL);
}