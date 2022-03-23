package hangman_game;

import java.util.Scanner;

/*
    Bonus-Aufgabe

    1.  Schaue dir den Java Scanner an.
    2.  Schreibe ein Hangman-Spiel.

    Tipp: Speichere die aktuell erratenen Buchstaben in einem Char-Array.
* */
public class HangmanGame {
    // Globale Variabel
    public static final String WORD = "Schilddrüse";
    public static int iterator = 0;
    public static int elements;
    public static int choices;
    public static String allLetters = "";
    public static char[] present = new char[WORD.length()];


    public static void main(String[] args) {
        // Neuer WORD String ohne Duplikate
        String str = deleteDup();

        //Wort ohne Duplikate
        elements = str.length();
        choices = str.length();

        // Speichert die Usereingaben ohne wiederholung
        char[] letters = new char[str.length()];
        char letter = ' ';
        System.out.println("\nHANGMAN GAME: Versuche das Wort zu raten!!\n\nAUFPASSEN!!\nBei " + str.length() + " falsche Angaben hast Du Verloren!!!\nDas Gesuchte Wort hat insgesamt " + WORD.length() + " Buchstaben!\nLOS GEHT'S!!\n");
        while (elements > 0) {
            letter = getUserInput(letters);
        }
        getGameResult(letters, str);
    }

    public static char getUserInput(char[] letters) {

        char letter = ' ';

        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie ein Buchstab ein und drücken Sie ENTER:");
        String input = scanner.nextLine();
        if (input.length() == 1) {
            letter = input.charAt(0);
            if (containsLetter(letter, letters) || allLetters.contains(input)) {
                System.out.println("Du hast dieser Buchstab schon eingegeben!!");
                getUserInput(letters);

            } else if (proofUserInput(letter)) {
                setUserInputToCorrectPosition(letter);
                System.out.println("TREFFER!!");
                printCurrentStatus();
                letters[iterator] = letter;
                allLetters += input;
                ++iterator;
                if (WORD.toLowerCase().equals(changeArrayToString(present))) {
                    elements = 0;
                    return letter;
                }

            } else {
                allLetters += input;
                --elements;
                System.out.println("FALSCH! Du hast " + (choices - elements) + " Fehler!");
                if (elements == 0) {
                    return letter;
                }
            }

        } else {
            System.out.println("NUR EIN BUCHSTAB MÖGLICH!!");
            getUserInput(letters);
        }

        return letter;
    }

    public static String changeArrayToString(char[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
        }
        return str;
    }

    public static void printCurrentStatus() {
        System.out.println("Zwischenstand: ");
        for (char c : present) {
            System.out.println(c);
        }
    }

    // Prüft ob Buchstabe in Array vorkommt
    public static boolean containsLetter(char letter, char[] letters) {
        for (char c : letters) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    // Prüft, ob Usereingabe im Wort vorkommt
    public static boolean proofUserInput(char letter) {
        int it = (WORD.toLowerCase()).indexOf(letter);
        if (it >= 0) {
            return true;
        }
        return false;
    }

    // Setzt der Spielereingabe in die richtige Position
    public static void setUserInputToCorrectPosition(char letter) {
        char[] charArrayOfWord = (WORD.toLowerCase()).toCharArray();
        for (int i = 0; i < charArrayOfWord.length; i++) {
            if (letter == charArrayOfWord[i]) {
                present[i] = letter;
            }
        }
    }

    // Entfernt Dupplikate im Wort
    public static String deleteDup() {

        String resultStr = "";
        String strLowerCase = WORD.toLowerCase();
        char[] charArray = strLowerCase.toCharArray();
        int it = 0;
        for (int i = 0; i < strLowerCase.length(); i++) {
            it = charArray[i];
            if (resultStr.indexOf(it) < 0) {
                resultStr += strLowerCase.charAt(i);
            }
        }
        return resultStr;
    }

    // Wertet Ergebnis aus:
    public static void getGameResult(char[] letters, String str) {
        // Letters in String zurückwandeln
        String backStr = "";
        int index;
        if (letters.length == 0) {
            System.out.println("Du hast verloren!");
        } else {
            for (int i = 0; i < letters.length; i++) {
                index = str.indexOf(letters[i]);
                if(index >= 0) {
                    backStr += str.charAt(index);
                }
            }
            if (backStr.length() == str.length()) {
                System.out.println("!!! GLÜCKWUNSCH !!!\nDU HAST GEWONNEN! :-))\n");
            } else {
                System.out.println("\nPECH!! DU HAST VERLOREN! :-(\nVIELLEICHT EIN NÄCHSTES MAL!!");
            }
        }
    }
}
