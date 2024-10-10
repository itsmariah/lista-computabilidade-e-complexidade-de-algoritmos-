//8) Desenvolva um AFN que aceite strings onde o número de '0's é divisível por 3.

import java.util.HashSet;
import java.util.Set;

public class AFNNumeroDe0sDivisivelPor3 {
    
    private Set<Integer> currentStates;
    private final int STATE_0 = 0;
    private final int STATE_1 = 1;
    private final int STATE_2 = 2;

    public AFNNumeroDe0sDivisivelPor3() {
        currentStates = new HashSet<>();
        currentStates.add(STATE_0);
    }

    private void transition(char input) {
        Set<Integer> newStates = new HashSet<>();
        for (int state : currentStates) {
            if (input == '0') {
                
                if (state == STATE_0) {
                    newStates.add(STATE_1);
                } else if (state == STATE_1) {
                    newStates.add(STATE_2);
                } else if (state == STATE_2) {
                    newStates.add(STATE_0);
                }
            } else if (input == '1') {
            
                newStates.add(state);
            }
        }
        currentStates = newStates;
    }


    public boolean accepts(String input) {
        for (char c : input.toCharArray()) {
            transition(c);
        }
        
        return currentStates.contains(STATE_0);
    }

    public static void main(String[] args) {
        AFNNumeroDe0sDivisivelPor3 afn = new AFNNumeroDe0sDivisivelPor3();
        
        String[] testStrings = {
            "1",
            "0",
            "00",
            "000",
            "0000",
            "00000",
            "111",
            "010101",
            "110011",
            "10010",
            "000111",
            "1100",
            "001110"
        };
        
        for (String s : testStrings) {
            System.out.println("A string \"" + s + "\" é aceita? " + afn.accepts(s));
            afn = new AFNNumeroDe0sDivisivelPor3();
        }
    }
}
