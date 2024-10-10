//2)Implemente um AFD que reconheça strings com número par de '0's sobre o alfabeto {0, 1}.

import java.util.Scanner;

public class AFDNumeroParDeZeros {
    
    enum Estado {
        q0, q1
    }

    public static Estado transicao(Estado estadoAtual, char simbolo) {
        switch (estadoAtual) {
            case q0:
                if (simbolo == '0') return Estado.q1;
                if (simbolo == '1') return Estado.q0;
                break;
            case q1:
                if (simbolo == '0') return Estado.q0;
                if (simbolo == '1') return Estado.q1;
                break;
        }
        return estadoAtual;
    }

    public static boolean aceita(String entrada) {
        Estado estadoAtual = Estado.q0;

        for (char simbolo : entrada.toCharArray()) {
            estadoAtual = transicao(estadoAtual, simbolo);
        }

        return estadoAtual == Estado.q0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma string sobre o alfabeto {0, 1}: ");
        String entrada = scanner.nextLine();

        if (aceita(entrada)) {
            System.out.println("A string é aceita (número par de '0's).");
        } else {
            System.out.println("A string não é aceita (número ímpar de '0's).");
        }

        scanner.close();
    }
}
