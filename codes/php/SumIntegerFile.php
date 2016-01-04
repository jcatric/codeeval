<?php
/**
 * Sum of Integers from File
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:36
 */

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

$sum = 0;
foreach ($lines as $line) {
    $line = trim($line);

    if (strlen($line) > 0) {
        $sum += intval($line, 10);
    }
}

print_r($sum);
print_r("\n");