import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private int opcao;

    public void loopPrincipal() {
        do {
            mostrarMenu();
            try {
                switch (opcao) {
                    case 1:
                        calcularCustos();
                        break;

                    default:
                    limpa();
                    System.out.println("Opção inválida!");
                    voltarMenu();
                    break;
                    }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                voltarMenu();
            }

        } while (opcao != 0);
    }

    public void mostrarMenu() {
        limpa();
        System.out.println("*** Menu de Custos AWS***");
        System.out.println("1- Calcular Custos");
        System.out.println("0- Sair");
        System.out.print("Opção: ");
        opcao = scan.nextInt(); scan.nextLine();
    }

    public void calcularCustos() {
        limpa();
        double custoPorHoraServidor = 0.15;
        double custoPorHoraBancoDados = 0.05;
        int quantidadeServidores;
        int quantidadeBancosDados;

        System.out.println("*** Calcular Custos***");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("O custo por hora de um servidor é de R$ 0,15.");
        System.out.println("O custo por hora de um banco de dados é de R$ 0,05.");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.print("Qual é a quantidade de servidores: ");
        quantidadeServidores = scan.nextInt(); scan.nextLine();
        System.out.print("Qual é a quantidade de Banco de dados: ");
        quantidadeBancosDados = scan.nextInt(); scan.nextLine();

        double custoTotal = (quantidadeServidores * custoPorHoraServidor) + (quantidadeBancosDados * custoPorHoraBancoDados);

        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("Custo total de uso da AWS por hora: R$ %.2f%n", custoTotal);
        voltarMenu();
    }

    public void limpa(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void voltarMenu(){
        System.out.println("Digite [ENTER] para voltar ao menu");
        scan.nextLine();
        scan.nextLine();
    }
}
