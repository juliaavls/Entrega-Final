import java.io.*;
import java.util.*;

public class PacienteRepositório {
    private static final String ARQUIVO = "pacientes.txt"; 
    private List<Paciente> pacientes = new ArrayList<>(); 

    
    public PacienteRepositório() {
        carregar();
    }

    
    public List<Paciente> getTodos() {
        return pacientes;
    }

    
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
        salvar();
    }

    
    public void remover(Paciente paciente) {
        pacientes.remove(paciente);
        salvar();
    }

    
    public void atualizar() {
        salvar();
    }

    
    public Paciente buscarPorId(int id) {
        return pacientes.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    
    private void carregar() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pacientes.add(Paciente.fromString(linha));
            }
        } catch (IOException e) {
            
        }
    }

    
    private void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Paciente p : pacientes) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}

