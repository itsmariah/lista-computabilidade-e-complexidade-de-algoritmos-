//15) Implemente um AFN que reconheça a linguagem de todas as strings sobre {a, b} com comprimento par.

import java.util.Scanner;

public class AFNReconheceComComprimentoPar {
    
    private enum State {
        Q0, Q1
    }

    private State currentState;

    public AFNReconheceComComprimentoPar() {
    
        currentState = State.Q0;
    }

    
    public void transition(char inputChar) {
        switch (currentState) {
            case Q0:
                if (inputChar == 'a' || inputChar == 'b') {
                    currentState = State.Q1;
                }
                break;
            case Q1:
                if (inputChar == 'a' || inputChar == 'b') {
                    currentState = State.Q0;
                }
                break;
        }
    }

    public boolean accepts(String input) {
        currentState = State.Q0;

        for (char c : input.toCharArray()) {
            transition(c);
        }

        return currentState == State.Q0;
    }

    public static void main(String[] args) {
        AFNReconheceComComprimentoPar automaton = new AFNReconheceComComprimentoPar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite uma string sobre {a, b} ou 'exit' para sair:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (automaton.accepts(input)) {
                System.out.println("A string \"" + input + "\" é aceita (comprimento par).");
            } else {
                System.out.println("A string \"" + input + "\" não é aceita (comprimento ímpar).");
            }
        }

        scanner.close();
    }
}

