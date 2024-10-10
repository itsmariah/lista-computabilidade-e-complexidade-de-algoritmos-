// 16) Construa um AFD para reconhecer strings sobre {0, 1} onde os '0's aparecem em blocos consecutivos.

import java.util.Scanner;

public class AFD0sBlocosConsecutivos {
    
    private enum State {
        Q0, Q1, Q2, REJECT
    }

    
    private State currentState;

    public AFD0sBlocosConsecutivos() {
        
        currentState = State.Q0;
    }

    
    public void transition(char inputChar) {
        switch (currentState) {
            case Q0:
                if (inputChar == '0') {
                    currentState = State.Q1;
                } else if (inputChar == '1') {
                    currentState = State.Q0;
                }
                break;
            case Q1:
                if (inputChar == '0') {
                    currentState = State.Q1;
                } else if (inputChar == '1') {
                    currentState = State.Q2;
                }
                break;
            case Q2:
                if (inputChar == '0') {
                    currentState = State.REJECT;
                } else if (inputChar == '1') {
                    currentState = State.Q2;
                }
                break;
            case REJECT:
                
                currentState = State.REJECT;
                break;
        }
    }

    
    public boolean accepts(String input) {
        currentState = State.Q0;

        for (char c : input.toCharArray()) {
            transition(c);
        }

        return currentState == State.Q0 || currentState == State.Q1 || currentState == State.Q2;
    }

    public static void main(String[] args) {
        AFD0sBlocosConsecutivos automaton = new AFD0sBlocosConsecutivos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite uma string sobre {0, 1} ou 'exit' para sair:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (automaton.accepts(input)) {
                System.out.println("A string \"" + input + "\" é aceita.");
            } else {
                System.out.println("A string \"" + input + "\" é rejeitada.");
            }
        }

        scanner.close();
    }
}
