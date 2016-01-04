<?php
/**
 * Swap Case
 * User: jcatric
 * Date: 28/12/15
 * Time: 18:42
 */

function evalLine($line)
{
    $result = '';

    for ($i = 0; $i < strlen($line); $i++) {
        if (ctype_upper($line[$i])) {
            $result .= strtolower($line[$i]);
        } else {
            $result .= strtoupper($line[$i]);
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