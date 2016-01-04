<?php
for ($x = 1; $x <= 12; $x++) {
    $line = '';

    for ($y = 1; $y <= 12; $y++) {
        $strNb = $x * $y;

        for ($i = strlen($strNb); $i < 4; $i++) {
            $line .= ' ';
        }

        $line .= $strNb;
    }

    print_r($line);
    print_r("\n");
}