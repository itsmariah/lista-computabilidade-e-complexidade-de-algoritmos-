//3)Construa um AFD que reconheça a linguagem de strings que contenham exatamente dois '1's sobre o alfabeto {0, 1}.

import java.util.Scanner;

public class AFDExatamenteDois1s {
    
    enum Estado {
        q0, q1, q2, q3
    }

    public static Estado transicao(Estado estadoAtual, char simbolo) {
        switch (estadoAtual) {
            case q0:
                if (simbolo == '0') return Estado.q0;
                if (simbolo == '1') return Estado.q1;
                break;
            case q1:
                if (simbolo == '0') return Estado.q1;
                if (simbolo == '1') return Estado.q2;
                break;
            case q2:
                if (simbolo == '0') return Estado.q2;
                if (simbolo == '1') return Estado.q3;
                break;
            case q3:
                return Estado.q3;
        }
        return estadoAtual;
    }

    public static boolean aceita(String entrada) {
        Estado estadoAtual = Estado.q0;

        for (char simbolo : entrada.toCharArray()) {
            estadoAtual = transicao(estadoAtual, simbolo);
        }

        return estadoAtual == Estado.q2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma string sobre o alfabeto {0, 1}: ");
        String entrada = scanner.nextLine();

        if (aceita(entrada)) {
            System.out.println("A string é aceita (contém exatamente dois '1's).");
        } else {
            System.out.println("A string não é aceita (não contém exatamente dois '1's).");
        }

        scanner.close();
    }
}