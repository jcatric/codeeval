<?php
/**
 * Age Distribution
 * User: jcatric
 * Date: 29/12/15
 * Time: 23:45
 */

function evalLine($line)
{
    $age = intval($line, 10);

    $result = '';

    if ($age < 0 || $age > 100) {
        $result = 'This program is for humans';
    } else {
        if ($age <= 2) {
            $result = 'Still in Mama\'s arms';
        } else if ($age <= 4) {
            $result = 'Preschool Maniac';
        } else if ($age <= 11) {
            $result = 'Elementary school';
        } else if ($age <= 14) {
            $result = 'Middle school';
        } else if ($age <= 18) {
            $result = 'High school';
        } else if ($age <= 22) {
            $result = 'College';
        } else if ($age <= 65) {
            $result = 'Working for the man';
        } else if ($age <= 100) {
            $result = 'The Golden Years';
        }
    }

    return $result;
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