package entities;

// mensagens de erro no swich

import java.time.LocalDate;

public abstract class Pessoa {
    public static int setId;

    // Atributos

    private String nome;
    private String telefone;

    private LocalDate dataNascimento;
    private String cpf;
    private Integer id = 1; // deve ser gerado alutomaticamente pelo sistema

    @Override
    public String toString() {
        return  " id= " + id +
                " nome= " + nome +
                " cpf= " + cpf
                ;
    }

    public Pessoa() {
    }


    public Pessoa(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public Integer setId() {
        return id;
    }
}
