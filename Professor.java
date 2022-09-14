package entities;

// Formação acadêmica:

//Graduação incompleta
//Graduação completa
//Mestrado
//Doutorado

//Experiência em desenvolvimento:

//Front-End
//Back-End
//Full-Stack

//Estado

//Ativo
//Inativo

import java.time.LocalDate;

public class Professor extends Pessoa {
    // atributos - os 3 de cima (olhar enum em java)
    private String formacaoAcademica;
    private String desenvolvimento;
    private String estado;

    @Override
    public String toString() {
        return "\n" + super.toString();
    }

    public Professor(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id, String formacaoAcademica, String desenvolvimento, String  estado) {
        super(nome, telefone, dataNascimento, cpf, id);
        this.formacaoAcademica = formacaoAcademica;
        this.desenvolvimento = desenvolvimento;
        this.estado = estado;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getDesenvolvimento() {
        return desenvolvimento;
    }

    public void setDesenvolvimento(String desenvolvimento) {
        this.desenvolvimento = desenvolvimento;
    }

    public String  getEstado() {
        return estado;
    }

    public void setEstado(String  estado) {
        this.estado = estado;
    }
}
