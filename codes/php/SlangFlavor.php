<?php
/**
 * Slang Flavor
 * User: jcatric
 * Date: 29/12/15
 * Time: 20:16
 */

//On parcours le fichiers en ignorant les lignes vides
$lines = file($argv[1], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

$arFlavor = array(
    ', yeah!',
    ', this is crazy, I tell ya.',
    ', can U believe this?',
    ', eh?',
    ', aw yea.',
    ', yo.',
    '? No way!',
    '. Awesome!'
);

$currentFlavor = 0;

$isMarked = false;

foreach ($lines as $line) {
    $line = trim($line);

    if(strlen($line) > 0 ) {

        $flags = PREG_SPLIT_DELIM_CAPTURE | PREG_SPLIT_NO_EMPTY;
        $arSentences = preg_split('/(\.|\!|\?)/', $line, null, $flags);

        $result = '';
        for ($i = 0; $i < count($arSentences); $i += 2) {
            $sentence = trim($arSentences[$i]);

            if(strlen($sentence) > 0) {
                if(strlen($result) > 0) {
                    $result .= ' ';
                }

                $result .= $sentence;
                if ($isMarked) {
                    $isMarked = false;
                    $result .= $arFlavor[$currentFlavor % count($arFlavor)];
                    $currentFlavor++;
                } else {
                    $isMarked = true;
                    $result .= $arSentences[$i+1];
                }
            }

        }

        print_r($result);
    }

    print_r(PHP_EOL);
}