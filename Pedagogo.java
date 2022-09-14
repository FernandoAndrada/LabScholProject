package entities;

// Total de atendimentos pedagógicos realizados:
//Este item é um contador que inicia em zero. Sempre que um pedagogo realiza um atendimento este valor deve ser incrementado
//O sistema deve perguntar qual foi o pedagogo e aluno participaram do atendimento

import java.time.LocalDate;

public class Pedagogo extends Pessoa {

    private Integer atendimento;

    private Integer contadorPedagogo;

    public Integer getContadorPedagogo() {
        return contadorPedagogo;
    }

    public void setContadorPedagogo(Integer contadorPedagogo) {
        this.contadorPedagogo = contadorPedagogo;
    }

    @Override
    public String toString() {
        return "\n" + super.toString();
    }

    public Pedagogo(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id, Integer atendimento, Integer contadorPedagogo) {
        super(nome, telefone, dataNascimento, cpf, id);
        this.atendimento = atendimento;
        this.contadorPedagogo= contadorPedagogo;
    }

    public Integer getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Integer atendimento) {
        this.atendimento = atendimento;
    }
}
