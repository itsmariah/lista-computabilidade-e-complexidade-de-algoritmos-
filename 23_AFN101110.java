// 23) Construa um AFN que aceite qualquer string que contenha a sequência "101" ou "110" sobre {0, 1}.

import java.util.Scanner;

public class AFN101110 {


    public static String getNextState(String currentState, char input) {
        switch (currentState) {
            case "q0":
                if (input == '1') return "q1";
                return "q0";
            case "q1":
                if (input == '0') return "q2";
                return "q4";
            case "q2":
                if (input == '1') return "q3";
                return "q0";
            case "q4":
                if (input == '0') return "q0";
                return "q5";
            case "q3":
                return "q3";
            case "q5":
                return "q5";
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

        return currentState.equals("q3") || currentState.equals("q5");
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
