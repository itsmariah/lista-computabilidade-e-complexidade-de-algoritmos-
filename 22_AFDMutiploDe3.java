// 22) Desenvolva um AFD que reconheça uma linguagem onde a diferença entre o número de 'a's e 'b's seja múltipla de 3.

import java.util.Scanner;

public class AFDMutiploDe3 {


    public static String getNextState(String currentState, char input) {
        switch (currentState) {
            case "q0":
                if (input == 'a') return "q1";
                if (input == 'b') return "q2";
                break;
            case "q1":
                if (input == 'a') return "q2";
                if (input == 'b') return "q0";
                break;
            case "q2":
                if (input == 'a') return "q0";
                if (input == 'b') return "q1";
                break;
        }
        return null;
    }

 
    public static boolean accepts(String inputString) {
        String currentState = "q0";

        
        for (char ch : inputString.toCharArray()) {
            currentState = getNextState(currentState, ch);
            if (currentState == null) {
                return false;
            }
        }

        return currentState.equals("q0");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string sobre {a, b}:");
        String inputString = scanner.nextLine();

        if (!inputString.matches("[ab]*")) {
            System.out.println("A string deve conter apenas 'a's e 'b's.");
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
