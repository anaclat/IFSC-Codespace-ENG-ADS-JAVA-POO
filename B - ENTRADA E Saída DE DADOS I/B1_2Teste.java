import java.util.Scanner;

public class B1_2Teste {
    public static void main(String[] args) {
        Scanner palavradigitada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String entrada = palavradigitada.next(); // Lê apenas uma palavra
        System.out.println("Você digitou: " + entrada);

        palavradigitada.close();
    }
}

