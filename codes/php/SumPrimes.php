<?php

$sum = 0;
$cpt = 1;
$nbr = 2;

while ($cpt <= 1000) {
    $estPremier = true;
    $limit = (int)sqrt($nbr);
    $limit = $limit + 1;

    for ($i = 2; $i < $limit; $i++) {
        if ($nbr % $i == 0) {
            $estPremier = false;
            break;
        }
    }

    if ($estPremier) {
        $sum += $nbr;
        $cpt++;
    }

    $nbr++;
}

print_r($sum);
print_r("\n");
