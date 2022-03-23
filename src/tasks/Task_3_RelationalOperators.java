package tasks;

/*
    Aufgabe 3: Relational Operatoren
    1.  Führe Rechenoperationen mit int Werten aus
        (Addition, Subtraktion, Multiplikation, Division)
    2.  Prüfe die Werte auf: größer, kleiner, Gleichheit
    3.  Mache das selbe mit float und double Werten.
        Was fällt dir auf?
**/
public class Task_3_RelationalOperators {

    public static void main(String[] args) {
        int x = 235;
        int y = 23414;

        int sum = x + y;
        int sub = x - y;
        int multi = x * y;
        int div = x / y;

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + sub);
        System.out.println("Multiplication: " + multi);
        System.out.println("Division: " + div);

        double doubleX = 3.66;
        double doubleY = 3.44;
        float floatX = 2.55f;
        float floatY = 2.66f;

        doubleX = 10.0;
        doubleY = 23.0;

        System.out.println("Double Addition: " + (doubleX + doubleY));
        System.out.println("Double + Float: " + (floatX + doubleY));
        System.out.println("Floats Division: " + (floatX + floatY));
        System.out.println("Doubles Division: " + (doubleX / doubleY));

        if (doubleX < floatX) {
            System.out.println(doubleX + " < " + floatX + ": JA");
        } else {
            System.out.println(floatX + " < " + doubleX + ": NEIN");
        }
    }
}
