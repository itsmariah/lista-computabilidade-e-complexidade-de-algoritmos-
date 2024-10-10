// 24) Implemente um AFD que aceite strings sobre {0, 1} onde a sequência "010" aparece pelo menos duas vezes.

import java.util.Scanner;

public class AFDDouble010 {

    public static String getNextState(String currentState, char input) {
        switch (currentState) {
            case "q0":
                if (input == '0') return "q1";
                return "q0";
            case "q1":
                if (input == '1') return "q2";
                return "q0";
            case "q2":
                if (input == '0') return "q1";
                return "q2";
            default:
                return null;
        }
    }

    public static boolean accepts(String inputString) {
        String currentState = "q0";

        for (char ch : inputString.toCharArray()) {
            currentState = getNextState(currentState, ch);
            if (currentState == null) {
                return false;
            }
        }

        return currentState.equals("q2");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string sobre {0, 1}:");
        String inputString = scanner.nextLine();

        if (!inputString.matches("[01]*")) {
            System.out.println("A string deve conter apenas '0's e '1's.");
            return;
        }

        boolean result = accepts(inputString);
        if (result) {
            System.out.println("A string \"" + inputString + "\" é aceita.");
        } else {
            System.out.println("A string \"" + inputString + "\" não é aceita.");
        }

        scanner.close();
    }
}
