public class Paciente {
   
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String diagnostico;

    
    public Paciente(int id, String nome, String cpf, String dataNascimento, String telefone, String diagnostico) {
        this.id = id;
        this.nome = nome;
        setCpf(cpf);
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.diagnostico = diagnostico;
    }

    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos numéricos.");
        }
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    
    @Override
    public String toString() {
        return id + ";" + nome + ";" + cpf + ";" + dataNascimento + ";" + telefone + ";" + diagnostico;
    }

    
    public static Paciente fromString(String linha) {
        String[] partes = linha.split(";");

        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String cpf = partes[2];
        String dataNascimento = partes[3];
        String telefone = partes[4];
        String diagnostico = partes[5];
        return new Paciente(id, nome, cpf, dataNascimento, telefone, diagnostico);
    }
}

