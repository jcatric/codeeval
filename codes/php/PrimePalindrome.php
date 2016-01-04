<?php
//Le plus grand palindrome d'un nombre premier
$palindrome = '';

$nbr = 2;
while ($nbr < 1000) {
    $estPremier = true;
    $limit = sqrt($nbr);
    $limit = ceil($limit);

    for ($i = 2; $i <= $limit; $i++) {
        if ($nbr % $i == 0) {
            $estPremier = false;
            break;
        }
    }

    if ($estPremier) {
        $strNum = "$nbr";

        if (strlen($strNum) == 1) {
            $palindrome = $strNum;
        } else {
            $left = null;
            $right = null;
            $q = (int)(strlen($strNum) / 2);

            if (strlen($strNum) % 2 == 0) {
                $left = substr($strNum, 0, $q);
                $right = substr($strNum, $q, strlen($strNum));
            } else {
                $left = substr($strNum, 0, $q);
                $right = substr($strNum, $q + 1, strlen($strNum));
            }

            if ($left == strrev($right)) {
                $palindrome = $strNum;
            }
        }
    }

    $nbr++;
}

print_r($palindrome);
print_r("\n");