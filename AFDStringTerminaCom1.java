//1) Crie um autômato finito determinístico (AFD) que reconheça a linguagem sobre o alfabeto {0, 1}, onde todas as strings terminam com "1".

import java.util.Scanner;

public class AFDStringTerminaCom1 {
   
    enum Estado {
        q0, q1, q2
    }

    
    public static Estado transicao(Estado estadoAtual, char simbolo) {
        switch (estadoAtual) {
            case q0:
                if (simbolo == '0') return Estado.q0;
                if (simbolo == '1') return Estado.q1;
                break;
            case q1:
                if (simbolo == '0') return Estado.q2;
                if (simbolo == '1') return Estado.q1;
                break;
            case q2:
                if (simbolo == '0') return Estado.q0;
                if (simbolo == '1') return Estado.q0;
                break;
        }
        return estadoAtual;
    }

    
    public static boolean aceita(String entrada) {
        Estado estadoAtual = Estado.q0;

        for (char simbolo : entrada.toCharArray()) {
            estadoAtual = transicao(estadoAtual, simbolo);
        }

        return estadoAtual == Estado.q1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma string sobre o alfabeto {0, 1}: ");
        String entrada = scanner.nextLine();

        if (aceita(entrada)) {
            System.out.println("A string é aceita (termina com '1').");
        } else {
            System.out.println("A string não é aceita (não termina com '1').");
        }

        scanner.close();
    }
}