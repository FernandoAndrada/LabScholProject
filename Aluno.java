package entities;

//Um aluno pode estar com a matrícula nas seguintes condições:

//Ativo
//Irregular
//Atendimento pedagógico
//Inativo

//O usuário do sistema poderá alterar esta condição sempre que necessário

//O aluno deve armazenar a nota do processo seletivo de entrada (0 até 10)

//Esta nota deve ser inserida no momento do cadastro do aluno

//Total de atendimentos pedagógicos realizados
//Este item é um contador que inicia em zero.
// Sempre que um pedagogo realiza um atendimento este valor deve ser incrementado

import java.time.LocalDate;

public class Aluno extends Pessoa {

    // Atributos - matricula, -nota, -atenditmento (contador zero incremento +1)
    private String matricula;
    private Double nota;
    private String atendimento;

    private Integer idPedagogo;

    private Integer contadorAluno;

    public Integer getIdPedagogo() {
        return idPedagogo;
    }

    public Integer getContadorAluno() {
        return contadorAluno;
    }



    public void setContadorAluno(Integer contadorAluno) {
        this.contadorAluno = contadorAluno;
    }

    public void setIdPedagogo(Integer idPedagogo) {
        this.idPedagogo = idPedagogo;
    }
//    public String escreva() {
//        return
//                " matricula= " + matricula + '\'' +
//                " nota= " + nota +
//                " atendimento= " + atendimento;
//    }

    public Aluno(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id, String matricula, Double nota, String atendimento, Integer idPedagogo, Integer contadorAluno) {
        super(nome, telefone, dataNascimento, cpf, id);
        this.matricula = matricula;
        this.nota = nota;
        this.atendimento = atendimento;
        this.idPedagogo = idPedagogo;
        this.contadorAluno = contadorAluno;
    }


    @Override
    public String toString() {
        return "\n" + super.toString();
    }

    public String getMatricula() {
        return matricula;
    }

    public String setMatricula(String matricula) {
        this.matricula = matricula;
        return matricula;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }
}
