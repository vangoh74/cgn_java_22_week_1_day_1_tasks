package tasks;
/*
    Aufgabe 4: Methoden 1
    1.  Schreibe eine Methode, die zwei int Parameter
        entgegennimmt und die Summe dieser zurückgibt
    2.  Schreibe eine 2. Methode, die einen int Parameter
        entgegennimmt und einen String
        "Summe: <int-parameter>" zurückgibt
    3.  Führe beide Methoden in der main-Methode
        nacheinander aus und gib den String auf
        der Konsole aus

    BONUS: Prüfe, ob einer der int Werte größer als 100 ist.
**/
public class Task_4_Methods {
    public static void main(String[] args) {
        int a = 123;
        int b = 99;
        int sum = sum(a, b);

        System.out.println(getSumStatement(sum));
        System.out.println(a + " > 100: " + isValueGraeterThan100(a));
        System.out.println(b + " > 100: " + isValueGraeterThan100(b));
    }

    public static int sum(int sumand_a, int sumand_b) {
        return sumand_a + sumand_b;
    }

    public static String getSumStatement(int sum) {
        return ("Summe: " + sum);
    }

    public static boolean isValueGraeterThan100(int value) {
        if (value > 100) {
            return true;
        }
        return false;
    }
}
