<?php

function decodeMorse($line)
{
    $arMorseToAscii = array(
        '.-' => 'A',
        '-...' => 'B',
        '-.-.' => 'C',
        '-..' => 'D',
        '.' => 'E',
        '..-.' => 'F',
        '--.' => 'G',
        '....' => 'H',
        '..' => 'I',
        '.---' => 'J',
        '-.-' => 'K',
        '.-..' => 'L',
        '--' => 'M',
        '-.' => 'N',
        '---' => 'O',
        '.--.' => 'P',
        '--.-' => 'Q',
        '.-.' => 'R',
        '...' => 'S',
        '-' => 'T',
        '..-' => 'U',
        '...-' => 'V',
        '.--' => 'W',
        '-..-' => 'X',
        '-.--' => 'Y',
        '--..' => 'Z',
        '.----' => '1',
        '..---' => '2',
        '...--' => '3',
        '....-' => '4',
        '.....' => '5',
        '-....' => '6',
        '--...' => '7',
        '---..' => '8',
        '----.' => '9',
        '-----' => '0'
    );

    $arLetterEncoded = explode(' ', $line);

    $result = '';
    foreach ($arLetterEncoded as $letterEncoded) {
        if('' == $letterEncoded) {
            $result .= ' ';
        } else {
            $result .= $arMorseToAscii[$letterEncoded];
        }
    }

    return $result;
}

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

foreach ($lines as $line) {
    $line = trim($line);
    print_r(decodeMorse($line));
    print_r("\n");
}