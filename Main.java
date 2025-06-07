

 import java.util.*;

public class Main {
    
    private static PacienteRepositório repositorio = new PacienteRepositório();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Pacientes! <3");

        int opcao;
        
        do {
            System.out.println("\n>>> MENU PRINCIPAL <<<");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Listar todos os Pacientes");
            System.out.println("3. Buscar paciente por ID");
            System.out.println("4. Editar paciente");
            System.out.println("5. Excluir paciente");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

           
            switch (opcao) {
                case 1 -> criarPaciente();
                case 2 -> listarPacientes();
                case 3 -> buscarPaciente();
                case 4 -> editarPaciente();
                case 5 -> excluirPaciente();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
        System.out.println("Programa encerrado.");
    }

   
    private static void criarPaciente() {
        try {
            System.out.println("\n--- Novo Paciente ---");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            String cpf;
        while (true) {
            System.out.print("CPF (somente números e 11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.matches("\\d{11}")) {  
                break; 
            } else {
                System.out.println("CPF inválido! Deve conter exatamente 11 números. Tente novamente.");
            }
        }
            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            String data = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Diagnóstico: ");
            String diag = scanner.nextLine();
           
            int id = repositorio.getTodos().size() > 0 ? repositorio.getTodos().get(repositorio.getTodos().size() - 1).getId() + 1 : 1;
            Paciente novo = new Paciente(id, nome, cpf, data, telefone, diag);
            repositorio.adicionar(novo);
            System.out.println("Paciente adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    
    private static void listarPacientes() {
        System.out.println("\n--- Lista de Pacientes ---");
        List<Paciente> pacientes = repositorio.getTodos();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            pacientes.forEach(System.out::println);
        }
    }

    
    private static void buscarPaciente() {
        System.out.print("\nInforme o ID do paciente: ");
        int id = Integer.parseInt(scanner.nextLine());
        Paciente p = repositorio.buscarPorId(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    
    private static void editarPaciente() {
        System.out.print("\nInforme o ID do paciente para editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Paciente p = repositorio.buscarPorId(id);
        if (p != null) {
            try {
                System.out.print("Novo nome (" + p.getNome() + "): ");
                p.setNome(scanner.nextLine());
                System.out.print("Novo CPF (" + p.getCpf() + "): ");
                p.setCpf(scanner.nextLine());
                System.out.print("Nova data nascimento (" + p.getDataNascimento() + "): ");
                p.setDataNascimento(scanner.nextLine());
                System.out.print("Novo telefone (" + p.getTelefone() + "): ");
                p.setTelefone(scanner.nextLine());
                System.out.print("Novo diagnóstico (" + p.getDiagnostico() + "): ");
                p.setDiagnostico(scanner.nextLine());
                repositorio.atualizar();
                System.out.println("Paciente atualizado!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    
    private static void excluirPaciente() {
        System.out.print("\nInforme o ID do paciente para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        Paciente p = repositorio.buscarPorId(id);

        
        if (p != null) {
            repositorio.remover(p);
            System.out.println("Paciente excluído com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
