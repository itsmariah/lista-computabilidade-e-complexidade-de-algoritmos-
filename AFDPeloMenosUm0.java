//4) Desenvolva um AFD que aceite strings com pelo menos um '0'.

import java.util.Scanner;

public class AFDPeloMenosUm0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite uma string composta apenas por 0s e 1s: ");
        String input = scanner.nextLine();
        
        if (accepts(input)) {
            System.out.println("A string aceita (contém pelo menos um '0').");
        } else {
            System.out.println("A string não aceita (não contém '0').");
        }
        
        scanner.close();
    }

    public static boolean accepts(String input) {
        int state = 0;

        for (char c : input.toCharArray()) {
            switch (state) {
                case 0:
                    if (c == '0') {
                        state = 1;
                    }
                   
                    break;
                case 1:
                    
                    state = 1;
                    break;
                default:
                    break;
            }
        }
        
        return state == 1;
    }
}