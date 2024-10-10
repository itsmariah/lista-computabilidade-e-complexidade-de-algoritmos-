//7) Implemente um AFN que reconheça strings que comecem com '01' e terminem com '10'.

import java.util.HashSet;
import java.util.Set;

public class AFNComeca01Termina10 {
    
    private Set<Integer> currentStates;
    private final int INITIAL_STATE = 0;
    private final int START_STATE = 1;
    private final int MIDDLE_STATE = 2;
    private final int ACCEPTING_STATE = 3;

    public AFNComeca01Termina10() {
        currentStates = new HashSet<>();
        currentStates.add(INITIAL_STATE);
    }

    private void transition(char input) {
        Set<Integer> newStates = new HashSet<>();
        for (int state : currentStates) {
            if (state == INITIAL_STATE) {
                if (input == '0') {
                    newStates.add(START_STATE);
                }
            } else if (state == START_STATE) {
                if (input == '1') {
                    newStates.add(MIDDLE_STATE);
                }
            } else if (state == MIDDLE_STATE) {
                if (input == '0') {
                    newStates.add(MIDDLE_STATE);
                } else if (input == '1') {
                    newStates.add(MIDDLE_STATE);
                }
             
                newStates.add(ACCEPTING_STATE);
            } else if (state == ACCEPTING_STATE) {
                
                if (input == '1' || input == '0') {
                    newStates.add(ACCEPTING_STATE);
                }
            }
        }
        currentStates = newStates;
    }

    public boolean accepts(String input) {
        for (char c : input.toCharArray()) {
            transition(c);
        }
        
        return currentStates.contains(ACCEPTING_STATE);
    }

    public static void main(String[] args) {
        AFNComeca01Termina10 afn = new AFNComeca01Termina10();
        
        String[] testStrings = {"0110", "010", "011", "100", "011010", "0010", "01", "11010", "01101010"};
        
        for (String s : testStrings) {
            System.out.println("A string \"" + s + "\" é aceita? " + afn.accepts(s));
            afn = new AFNComeca01Termina10();
        }
    }
}
