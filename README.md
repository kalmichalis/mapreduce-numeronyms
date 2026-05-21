# MapReduce Numeronyms

A MapReduce implementation for generating and counting numeronyms from text in Java.

## What is a Numeronym?
A numeronym is formed by taking the first and last character of a word and placing the count of characters in between.
For example: internationalization → i18n, localization → l10n

## Features
- MapReduce-based word processing
- Generates numeronyms for words with 3 or more characters
- Case-insensitive, ignores punctuation
- Filters results by minimum occurrence count k

## How to Run

Compile with Maven:
mvn compile
Run the program:
mvn exec:java -Dexec.mainClass="Numeronyms" -Dexec.args="SherlockHolmes.txt k"
Replace `k` with the minimum number of occurrences you want to display.

## Technologies
Java, MapReduce, Maven
