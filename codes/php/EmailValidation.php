<?php

function isEmailValid($email)
{
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        return 'false';
    } else {
        return 'true';
    }
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(isEmailValid($line));
    print_r("\n");
}
