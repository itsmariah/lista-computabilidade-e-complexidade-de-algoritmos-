// 20) Implemente um AFD para strings sobre {a, b} onde a sequência 'ab' aparece exatamente uma vez.

import java.util.Scanner;

public class AFDSequenciaAB {

    public static String getNextState(String currentState, char input) {
        switch (currentState) {
            case "q0":
                if (input == 'a') return "q1";
                else return "q0";
            case "q1":
                if (input == 'a') return "q1";
                else if (input == 'b') return "q2";
                break;
            case "q2":
                if (input == 'a') return "q_reject";
                else return "q2";
            case "q_reject":
                return "q_reject";
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

        
        return currentState.equals("q2");
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
