<?php

function evalLine($line)
{
    $arDatas = array_map('intval', explode(' ', $line));

    $arNotUnique = array();
    $arUnique = array();

    foreach ($arDatas as $num) {
        if (in_array($num, $arNotUnique)) {
            $arUnique = array_diff($arUnique, array($num));
        } else {
            array_push($arNotUnique, $num);
            array_push($arUnique, $num);
        }
    }

    sort($arUnique, SORT_NUMERIC);

    $result = 0;
    if (count($arUnique) > 0) {
        $key = array_search($arUnique[0], $arDatas);
        $result = $key + 1;
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
