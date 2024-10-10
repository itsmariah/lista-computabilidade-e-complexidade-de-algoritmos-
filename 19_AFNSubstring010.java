// 19) Construa um AFN que reconheça a linguagem de todas as strings binárias que contenham a substring '010'.

import java.util.Scanner;

public class AFNSubstring010 {


    public static boolean process(String input, int index, String currentState) {
        if (index == input.length()) {
            
            return currentState.equals("q3");
        }

        char currentChar = input.charAt(index);

        switch (currentState) {
            case "q0":
                if (currentChar == '0') {
                    
                    return process(input, index + 1, "q1") || process(input, index + 1, "q0");
                } else {
                    
                    return process(input, index + 1, "q0");
                }

            case "q1":
                if (currentChar == '0') {
                    return process(input, index + 1, "q1");
                } else if (currentChar == '1') {
                    return process(input, index + 1, "q2");
                }
                break;

            case "q2":
                if (currentChar == '0') {
                    return process(input, index + 1, "q3");
                } else if (currentChar == '1') {
                    return process(input, index + 1, "q0");
                }
                break;

            case "q3":
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string binária:");
        String inputString = scanner.nextLine();

        if (!inputString.matches("[01]*")) {
            System.out.println("A string deve conter apenas '0's e '1's.");
            return;
        }

        boolean result = process(inputString, 0, "q0");
        if (result) {
            System.out.println("A string contém a substring '010' e é aceita.");
        } else {
            System.out.println("A string não contém a substring '010' e não é aceita.");
        }

        scanner.close();
    }
}
