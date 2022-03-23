package tasks;
/*
    Aufgabe 5: String Methoden

    Schreibe eine Methode, die prüft, ob ein String

    1.  länger als 20 Zeichen ist
    2.  die Zeichenfolge "fancy" enthält
    3.  Schreibe eine Methode, die eine andere
        Methode von dir aufruft.
* */
public class Task_5_StringMethods {
    public static void main(String[] args) {
        String str = "jasfölksffan";
        callMethod(str);
    }

    public static void callMethod(String str) {
        int strLength = 20;
        String subStr = "fancy";

        if (proofStringLength(strLength, str)) {
            System.out.println("String hat genau oder mehr als " + strLength + " Zeichen");
        } else {
            System.out.println("String hat weniger als " + strLength + " Zeichen");
        }

        if (containsSubStr(str, subStr)) {
            System.out.println("Zeichenfolge " + subStr + " in String enthalten");
        } else {
            System.out.println("String enthält keine Zeichenfolge " + subStr);
        }
    }

    public static boolean proofStringLength(int strLength, String str) {
        if (str.length() >= strLength) {
            return true;
        }
        return false;
    }

    public static boolean containsSubStr(String str, String subStr) {

        if (str.contains(subStr)) {
            return true;
        }
        return false;
    }
}
