<?php
/**
 * Knight Moves
 * User: jcatric
 * Date: 29/12/15
 * Time: 21:28
 */

function evalLine($line)
{
    $arCoord = str_split($line);

    $x = intval($arCoord[1], 10);
    $y = ord($arCoord[0]) - 96; //char to int

    return implode(' ', knightMove($x, $y));
}

function knightMove($x, $y){

    $result = array();

    if($y-1 >= 1) {
        if ($x-2 >= 1) {
            array_push($result, chr(96 + $y-1) . ($x-2));
        }

        if ($x+2 <= 8) {
            array_push($result, chr(96 + $y-1) . ($x+2));
        }
    }

    if($y-2 >= 1) {
        if ($x-1 >= 1) {
            array_push($result, chr(96 + $y-2) . ($x-1));
        }

        if ($x+1 <= 8) {
            array_push($result, chr(96 + $y-2) . ($x+1));
        }
    }

    if($y+1 <= 8) {
        if ($x-2 >= 1) {
            array_push($result, chr(96 + $y+1) . ($x-2));
        }

        if ($x+2 <= 8) {
            array_push($result, chr(96 + $y+1) . ($x+2));
        }
    }

    if($y+2 <= 8) {
        if ($x-1 >= 1) {
            array_push($result, chr(96 + $y+2) . ($x-1));
        }

        if ($x+1 <= 8) {
            array_push($result, chr(96 + $y+2) . ($x+1));
        }
    }

    sort($result, SORT_ASC);

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);

    if(strlen($line) > 0 ) {
        print_r(evalLine($line));
    }

    print_r(PHP_EOL);
}