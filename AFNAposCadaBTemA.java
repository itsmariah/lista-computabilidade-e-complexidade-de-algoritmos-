// 21) Implemente um AFN que aceite todas as strings sobre {a, b} que tenham um 'a' após cada 'b'.

import java.util.Scanner;

public class AFNAposCadaBTemA {

    public static boolean process(String input, int index, String currentState) {
        if (index == input.length()) {
            
            return currentState.equals("q0");
        }

        char currentChar = input.charAt(index);

        switch (currentState) {
            case "q0":
                if (currentChar == 'a') {
                    
                    return process(input, index + 1, "q0");
                } else if (currentChar == 'b') {
                    
                    return process(input, index + 1, "q1");
                }
                break;

            case "q1":
                if (currentChar == 'a') {
                    
                    return process(input, index + 1, "q0");
                }
                
                return false;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string sobre {a, b}:");
        String inputString = scanner.nextLine();

        if (!inputString.matches("[ab]*")) {
            System.out.println("A string deve conter apenas 'a's e 'b's.");
            return;
        }

        boolean result = process(inputString, 0, "q0");
        if (result) {
            System.out.println("A string \"" + inputString + "\" é aceita.");
        } else {
            System.out.println("A string \"" + inputString + "\" não é aceita.");
        }

        scanner.close();
    }
}
