import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeSenhas gerenciador = new GerenciadorDeSenhas("senhas.dat");

        while (true) {
            System.out.println("\nGerenciador de Senhas");
            System.out.println("1. Adicionar senha");
            System.out.println("2. Exibir todas as senhas");
            System.out.println("3. Buscar senha por site");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do site: ");
                    String site = scanner.nextLine();
                    System.out.print("Digite o nome de usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = scanner.nextLine();
                    gerenciador.adicionarSenha(site, usuario, senha);
                    break;
                case 2:
                    gerenciador.exibirSenhas();
                    break;
                case 3:
                    System.out.print("Digite o nome do site para buscar: ");
                    String buscaSite = scanner.nextLine();
                    gerenciador.buscarSenha(buscaSite);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
