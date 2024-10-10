//6) Construa um autômato finito não-determinístico (AFN) que aceite strings que contenham pelo menos um '0' sobre o alfabeto {0, 1}.

import java.util.HashSet;
import java.util.Set;

public class AFNPeloMenosUm0 {
    
    private Set<Integer> currentStates;
    private final int INITIAL_STATE = 0;
    private final int ACCEPTING_STATE = 1;

    public AFNPeloMenosUm0 () {
        currentStates = new HashSet<>();
        currentStates.add(INITIAL_STATE);
    }

    
    private void transition(char input) {
        Set<Integer> newStates = new HashSet<>();
        for (int state : currentStates) {
            if (state == INITIAL_STATE) {
                if (input == '0') {
                    newStates.add(ACCEPTING_STATE);
                }
              
                newStates.add(INITIAL_STATE);
            } else if (state == ACCEPTING_STATE) {
                newStates.add(ACCEPTING_STATE);
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
        AFNPeloMenosUm0 afn = new AFNPeloMenosUm0();
        
        String[] testStrings = {"1", "11", "0", "01", "10", "111", "101", "1001"};
        
        for (String s : testStrings) {
            System.out.println("A string \"" + s + "\" é aceita? " + afn.accepts(s));
            afn = new AFNPeloMenosUm0(); 
        }
    }
}
