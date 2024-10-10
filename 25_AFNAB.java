// 25) Crie um AFN que reconheça strings sobre {a, b} onde todas as ocorrências de 'a' aparecem antes de todas as ocorrências de 'b'.

import java.util.Scanner;

public class AFNAB {

    public static String getNextState(String currentState, char input) {
        switch (currentState) {
            case "q0":
                if (input == 'a') return "q1";
                return input == 'b' ? "q2" : null;
            case "q1":
                if (input == 'a') return "q1";
                return input == 'b' ? "q2" : null;
            case "q2":
                return input == 'b' ? "q2" : null;
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

        return currentState.equals("q1") || currentState.equals("q2");
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
