import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        gerenciador.setTarefas(ArquivoUtil.carregar());

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Editar tarefa");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Marcar como concluída");
            System.out.println("5. Listar tarefas");
            System.out.println("6. Salvar");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    gerenciador.adicionarTarefa(desc);
                    break;
                case 2:
                    System.out.print("ID da tarefa: ");
                    int idEdit = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDesc = scanner.nextLine();
                    gerenciador.editarTarefa(idEdit, novaDesc);
                    break;
                case 3:
                    System.out.print("ID da tarefa: ");
                    int idRemover = scanner.nextInt();
                    gerenciador.removerTarefa(idRemover);
                    break;
                case 4:
                    System.out.print("ID da tarefa: ");
                    int idConcluir = scanner.nextInt();
                    gerenciador.marcarComoConcluida(idConcluir);
                    break;
                case 5:
                    gerenciador.listarTarefas();
                    break;
                case 6:
                    ArquivoUtil.salvar(gerenciador.getTarefas());
                    break;
                case 0:
                    ArquivoUtil.salvar(gerenciador.getTarefas());
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
