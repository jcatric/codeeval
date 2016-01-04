<?php
/**
 * Self Describing Numbers
 *
 * User: jcatric
 * Date: 28/12/15
 * Time: 17:24
 */

function evalLine($line)
{
    $arData =  array_map('intval', str_split($line));

    $result = 1;
    for ($p = 0; $p <count($arData); $p++) {
        $currentCount = 0;

        for ($c = 0; $c <count($arData); $c++) {
            if ($p == $arData[$c]) {
                $currentCount++;
            }
        }

        if ($arData[$p] != $currentCount) {
            $result = 0;
            break;
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