<?php
/**
 * JsonMenuIds
 * User: jcatric
 * Date: 28/12/15
 * Time: 19:17
 */

function evalLine($line)
{
    $json = json_decode($line, true);

    $sum = 0;
    if (array_key_exists('menu', $json)) {
        if (array_key_exists('items', $json['menu'])) {
            foreach ($json['menu']['items'] as $item) {
                if($item != null && is_array($item)) {
                    if (array_key_exists('label', $item) && array_key_exists('id', $item)) {
                        if(is_numeric($item['id'])){
                            $sum += intval($item['id'], 10);
                        }
                    }
                }
            }
        }
    }


    return $sum;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(evalLine($line));
    print_r("\n");
}