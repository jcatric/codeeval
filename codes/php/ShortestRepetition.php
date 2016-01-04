<?php
/**
 * Shortest Repetition
 *
 * User: jcatric
 * Date: 28/12/15
 * Time: 17:48
 */

function evalLine($line)
{
    $isFinish = false;
    $rep = '';
    $n = 1;

    while (!$isFinish && $n <= strlen($line)) {
        $rep = substr($line, 0, $n);
        $res = str_replace($rep, '', $line);

        if (strlen($res) == 0) {
            $isFinish = true;
        }

        $n++;
    }

    return strlen($rep);
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}