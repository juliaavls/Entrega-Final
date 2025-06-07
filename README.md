# Sistema CRUD de Pacientes em Java

Esse projeto implementa um sistema básico de cadastro de pacientes utilizando Java. Ele permite realizar operações CRUD (Criar, Ler, Atualizar, Excluir), com persistência dos dados em arquivo texto.

Trabalho final da disciplina -Programação e Soluções Computacionais-, desenvolvido pelas alunas *Giulia Hellen* e *Julia Alves*.

# Funcionalidades

- Criar novo paciente  
- Listar todos os pacientes  
- Buscar paciente por ID  
- Editar dados do paciente  
- Excluir paciente  
- Validar CPF  
- Persistência dos dados em arquivo pacientes.txt

# Estrutura do Projeto

- Paciente.java — Classe que representa a entidade Paciente  
- PacienteRepositorio.java — Responsável por armazenar, e gerenciar os dados dos pacientes  
- Main.java — Classe principal com menu interativo e a execução das operações  
- pacientes.txt — Arquivo criado automaticamente após o primeiro cadastro

# Como compilar e executar

-- Pré-requisitos

- Java JDK 8 ou superior  
- Terminal ou prompt de comando

1. Abra a pasta do projeto no editor de código de sua preferência.
2. Deixe todos os arquivos ".java" na mesma pasta.
3. Clique com o botão direito no "Main.java" e escolha *Run Java ou *Executar Java.
4. O programa vai aparecer no terminal com um menu simples.
5. Use o menu para cadastrar, listar, remover pacientes, etc.