package aplication;

// Listar todas as pessoas cadastradas.
// O usuário deverá informar quais categorias de pessoas deseja listar (deve-se listar Código, Nome e CPF):
//Alunos
//Professores
//Funcionários
//Todos

//Relatório dos Alunos.
// O usuário deve escolher qual categoria apresentar
// (deve-se listar código, nota e total de atendimentos pedagógicos):
//Ativo
//Irregular
//Atendimento pedagógico
//Inativo
//Todos

//Relatório dos professores. O usuário deve escolher qual categoria apresentar:
//Front-End
//Back-End
//Full-Stack
//Todos

//Alunos com mais atendimentos pedagógicos
//Pedagogos com mais atendimentos pedagógicos

import entities.Aluno;
import entities.DigitarNumeroException;
import entities.Pedagogo;
import entities.Professor;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class LabScholMain {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    static List<Aluno> alunos = new ArrayList<>();
    static List<Professor> professores = new ArrayList<>();
    static List<Pedagogo> pedagogos = new ArrayList<>();
    static String telefone = "";

    static String cpf = "";

    static String matricula;
    static String formacaoAcademica;
    static String desenvolvimento;
    static String estado;

    static String data;

    static Integer idPedagogo;

    static Integer contadorAluno;

    public static void main(String[] args) {

        // lista para testes

        Integer id;
        String data2="28/12/1966";

        Aluno teste1 = new Aluno("Fernando Teste1","48-1-9999-9999",parseLocalDate(data2),"012-345-678/91", id=10,"Ativo",10.0,"sim",18,0);
        Aluno teste2 = new Aluno("Fernando Teste2","48-2-9999-9999",parseLocalDate(data2),"013-345-678/92", id=11,"Irregular",9.0,"não",0,0);
        Aluno teste3 = new Aluno("Fernando Teste3","48-3-9999-9999",parseLocalDate(data2),"014-345-678/92", id=12,"Em atendimento Pedagógico.",8.0,"sim",20,0);
        Aluno teste4 = new Aluno("Fernando Teste4","48-4-9999-9999",parseLocalDate(data2),"015-345-678/92", id=13,"Inativo",7.0,"não",0,0);
        alunos.add(teste1);
        alunos.add(teste2);
        alunos.add(teste3);
        alunos.add(teste4);

        Professor professor1 = new Professor("Fernando Prof Teste1", "48-1-2222-2222", parseLocalDate(data2), "111-222-333-44", id=14, "Graduação incompleta","Front-End", "sim" );
        Professor professor2 = new Professor("Fernando Prof Teste2", "48-2-2222-2222", parseLocalDate(data2), "222-222-333-44", id=15, "Graduação completa","Back-End", "não" );
        Professor professor3 = new Professor("Fernando Prof Teste3", "48-3-2222-2222", parseLocalDate(data2), "333-222-333-44", id=16, "Mestrado","Full-Stack", "sim" );
        Professor professor4 = new Professor("Fernando Prof Teste4", "48-4-2222-2222", parseLocalDate(data2), "444-222-333-44", id=17, "Doutorado","Front-End", "não" );
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
        professores.add(professor4);

        Pedagogo pedagogo1 = new Pedagogo ("Fer Pedag Teste1", "48-5-5555-5555", parseLocalDate(data2), "555-666-777-88", id=18, 0, 0);
        Pedagogo pedagogo2 = new Pedagogo ("Fer Pedag Teste2", "48-6-5555-5555", parseLocalDate(data2), "666-666-777-88", id=19, 1,0);
        Pedagogo pedagogo3 = new Pedagogo ("Fer Pedag Teste3", "48-7-5555-5555", parseLocalDate(data2), "777-666-777-88", id=20, 0,0);
        Pedagogo pedagogo4 = new Pedagogo ("Fer Pedag Teste4", "48-8-5555-5555", parseLocalDate(data2), "888-666-777-88", id=21, 1,0);
        pedagogos.add( pedagogo1);
        pedagogos.add( pedagogo2);
        pedagogos.add( pedagogo3);
        pedagogos.add( pedagogo4);

        // final lista teste.




        menuBoasVindas();




    }

    private static void menuBoasVindas() {

        try {


        System.out.println("<<<<<<<<<<<< Lab School >>>>>>>>>>>>");
        System.out.println("Bem-vindo, escolha a opção desejada:" +
                "\n------------------------------------" +
                "\n1 - Fazer Cadastro" +
                "\n2 - Visualizar Cadastros" +
                "\n3 - Relatórios Alunos" +
                "\n4 - Relatórios Professores" +
                "\n5 - Relatórios Pedagógicos" +
                "\n6 - Alterar condição de matrícula" +
                "\n7 - Marcar atendimento pedagógico" +
                "\n8 - Encerrar a sessão");

        int boasVindas = scanner.nextInt();
        switch (boasVindas) {
            case 1:
                fazerCadastros();
                break;

            case 2:
                listarCadastros();
                break;

            case 3:
                relatorioAlunos();

                break;
            case 4:
                relatorioProfessores();

                break;
            case 5:
                relatorioPedagogico();

                break;

            case 6:

                System.out.println("Digite o id do aluno: ");
                int idaluno = scanner.nextInt();

                for(int i = 0; i < alunos.size(); i++) {
                    if(alunos.get(i).getId().equals(idaluno)){
                        System.out.println(alunos.get(i));
                        System.out.println("Condição atual: " + alunos.get(i).getMatricula());
                        System.out.println("");
                    }

                }
                condicaoAluno();


                for(int i = 0; i < alunos.size(); i++) {
                    if (alunos.get(i).getId().equals(idaluno)) {
                        alunos.get(i).setMatricula(matricula);

                        System.out.println("Condição alterada com sucesso.");
                        System.out.println("");
                    }
                }
                menuBoasVindas();

            case 7:

                marcarAtendimentoPedagogico();

                menuBoasVindas();



            case 8:
                System.out.println("Agradecemos sua presença.");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida!");





        }
        }catch (InputMismatchException e){
            System.out.println("Você tem que digitar um número");
        }finally {
            System.out.println("Programa encerrado!");
        }
    }

    private static void marcarAtendimentoPedagogico() {

        System.out.println("<<<<* Atendimento Pedagogico *>>>>");
        System.out.println("Para agendar um atendimento,");
        System.out.println("digite o Id do Aluno: ");
        int idAluno = scanner.nextInt();
        System.out.println("Digite o Id do Pedagogo: ");
        int idPedagogo = scanner.nextInt();


        for (int i = 0; i < alunos.size(); i++) {
            if ((alunos.get(i).getId().equals(idAluno))) {
                Integer auxiliar = ((alunos.get(i).getContadorAluno()+1));
                alunos.get(i).setContadorAluno(auxiliar);
                System.out.println("cont aluno: " + alunos.get(i).getContadorAluno());
            }

        }
        for (int i = 0; i < pedagogos.size(); i++) {
            if ((pedagogos.get(i).getId().equals(idPedagogo))) {
                Integer auxiliar = ((pedagogos.get(i).getContadorPedagogo()+1));
                pedagogos.get(i).setContadorPedagogo(auxiliar);
                System.out.println("cont pedagogo: " + pedagogos.get(i).getContadorPedagogo());
            }
        }
        System.out.println("Agendamento efetuado com sucesso!");
        menuBoasVindas();
    }

    private static void relatorioPedagogico() {
        System.out.println("Escolha uma opção:" +
                "\n1 - Alunos com mais atendimentos pedagógicos" +
                "\n2 - Pedagogos com mais atendimentos pedagógicos");
        int relatPedagogico = scanner.nextInt();
        switch (relatPedagogico){
            case 1:

                for(int i = 0; i < alunos.size(); i++) {
                    if ((alunos.get(i).getMatricula().equals("Em atendimento Pedagógico."))
                            ||((alunos.get(i).getAtendimento().equals("sim")))) {
                        System.out.println("Aluno: "+ alunos.get(i).getNome());
                        int idped = (alunos.get(i).getIdPedagogo());
                        pedagogos.get(i).getId().equals(idped);
                        System.out.println("Nome do Pedagogo: " + pedagogos.get(i).getNome());
                        System.out.println("Contador: " + alunos.get(i).getContadorAluno());
                        System.out.println("");

                    }
                }
                        menuBoasVindas();

                break;

            case 2:

                for(int i = 0; i < alunos.size(); i++) {
                    if ((alunos.get(i).getMatricula().equals("Em atendimento Pedagógico."))
                            ||((alunos.get(i).getAtendimento().equals("sim")))) {

                        int idped = (alunos.get(i).getIdPedagogo());
                        pedagogos.get(i).getId().equals(idped);
                        System.out.println("Nome do Pedagogo: " + pedagogos.get(i).getNome());
                        System.out.println("Nome do(s) Aluno(s): " + alunos.get(i).getNome());
                        System.out.println("Contador: " + pedagogos.get(i).getContadorPedagogo());
                        System.out.println("");
                    }
                }
                        menuBoasVindas();

                break;



            default:
                System.out.println("Opção inválida");
        }
    }

    private static void relatorioProfessores() {
        try {


            System.out.println("Escolha o relatório a ser listado:" +
                    "\n-----------------------------------------" +
                    "\n1 - Front-End" +
                    "\n2 - Back-End" +
                    "\n3 - Full-Stack" +
                    "\n4 - Todos");
            int relatorioProfessor = scanner.nextInt();
            switch (relatorioProfessor) {
                case 1:

                    for(int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getDesenvolvimento().equals("Front-End")) {
                            System.out.println(professores.get(i));
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();


                    break;

                case 2:

                    for(int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getDesenvolvimento().equals("Back-End")) {
                            System.out.println(professores.get(i));
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();

                    break;

                case 3:

                    for(int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getDesenvolvimento().equals("Full-Stack")) {
                            System.out.println(professores.get(i));
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();


                    break;

                case 4:
                    // se condição matricula for igual a Inativo imprime professores
                    System.out.println("Professores:");
                    professores.forEach(System.out::print);
                    System.out.println("");
                    System.out.println("");
                    menuBoasVindas();

                    break;

                default:
                    System.out.println("Opção inválida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Você tem que digitar um número");
        }


    }

    private static void relatorioAlunos() {

        try {


            System.out.println("Escolha o relatório a ser listado:" +
                    "\n-----------------------------------------" +
                    "\n1 - Alunos Ativos" +
                    "\n2 - Alunos Irregulares" +
                    "\n3 - Alunos em Atendimento pedagógico" +
                    "\n4 - Alunos Inativos");
            int relatAlunos = scanner.nextInt();

            switch (relatAlunos) {
                case 1:
//
                    for(int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula().equals("Ativo")) {
                            System.out.println(alunos.get(i));
                            System.out.println("Nota: " + alunos.get(i).getNota());
                            System.out.println("Atendimento: " + alunos.get(i).getAtendimento());
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();



                    break;

                case 2:

                    // se condição matricula for igual a Irregulares imprime alunos
                    for(int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula().equals("Irregular")) {
                            System.out.println(alunos.get(i));
                            System.out.println("Nota: " + alunos.get(i).getNota());
                            System.out.println("Atendimento: " + alunos.get(i).getAtendimento());
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();


                    break;

                case 3:
                    // se condição matricula for igual a Atendimento pedag imprime alunos
                    for(int i = 0; i < alunos.size(); i++) {
                        if ((alunos.get(i).getMatricula().equals("Em atendimento Pedagógico."))
                        ||((alunos.get(i).getAtendimento().equals("sim")))) {
                            System.out.println(alunos.get(i));
                            System.out.println("Nota: " + alunos.get(i).getNota());
                            System.out.println("Atendimento: " + alunos.get(i).getAtendimento());
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();


                    break;

                case 4:
                    // se condição matricula for igual a Inativo imprime alunos
                    for(int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula().equals("Inativo")) {
                            System.out.println(alunos.get(i));
                            System.out.println("Nota: " + alunos.get(i).getNota());
                            System.out.println("Atendimento: " + alunos.get(i).getAtendimento());
                        }
                    }
                            System.out.println(" ");
                            menuBoasVindas();


                    break;

                default:
                    System.out.println("Opção inválida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Você tem que digitar um número");
        }


    }

    private static void listarCadastros() {
        System.out.println("<<<<<<* Lista Cadastros *>>>>>>");
        System.out.println(" Digite um número para ver " +
                "\n as pessoas cadastradas:" +
                "\n1 - Alunos" +
                "\n2 - Professores" +
                "\n3 - Funcionários" +
                "\n4 - Todos");
        Integer listarCadastro = scanner.nextInt();
        switch (listarCadastro){
            case 1:

                System.out.println("Alunos:");
                alunos.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                menuBoasVindas();
                break;

            case 2:

                System.out.println("Professores:");
                professores.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                menuBoasVindas();
                break;

            case 3:

                System.out.println("Professores:");
                professores.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                System.out.println("Pedagogos:");
                pedagogos.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                menuBoasVindas();
                break;

            case 4:

                System.out.println("Alunos:");
                alunos.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                System.out.println("Professores:");
                professores.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                System.out.println("Pedagogos:");
                pedagogos.forEach(System.out::print);
                System.out.println("");
                System.out.println("");

                menuBoasVindas();
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void fazerCadastros() {

        try {


            System.out.println("<<<<<<<<<<<< Cadastros >>>>>>>>>>>>");
            System.out.println("  Bem-vindo ao setor de cadastro," +
                    "\n  por favor escolha uma opção:" +
                    "\n----------------------------------" +
                    "\n1 - Cadastrar Aluno" +
                    "\n2 - Cadastrar Professor" +
                    "\n3 - Cadastrar Pedagogo");
            int cadastro = scanner.nextInt();
            switch (cadastro) {
                case 1:
                    condicaoAluno();
                    cadastroAluno();
                    break;
                case 2:
                    cadastroProfessor();
                    break;
                case 3:
                    cadastroPedagogo();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }catch (InputMismatchException e){
            System.out.println("Você tem que digitar um número!");
        }
    }

    private static void condicaoAluno() {

        try {


            System.out.println("Escolha a condição de matrícula do aluno:" +
                    "\n-----------------------------------------" +
                    "\n1 - Ativo" +
                    "\n2 - Irregular" +
                    "\n3 - Atendimento pedagógico" +
                    "\n4 - Inativo");
            int condicaoMatricula = scanner.nextInt();
            switch (condicaoMatricula) {
                case 1:

                    matricula = "Ativo";
                    System.out.println("O aluno encontra-se " + matricula + ".");

                    break;

                case 2:

                    matricula = "Irregular";
                    System.out.println("O aluno encontra-se " + matricula + ".");
                    break;

                case 3:
                    matricula = "Em atendimento Pedagógico.";
                    System.out.println("O aluno encontra-se " + matricula + ".");
                    atendimentoPedagogico();
                    break;

                case 4:
                    matricula = "Inativo";
                    System.out.println("O aluno encontra-se " + matricula + ".");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Você tem que digitar um número");
        }

    }

    private static void atendimentoPedagogico() {
        System.out.println("Digite o nome do Pedagogo:");
        System.out.println("--------------------------");
        String pedagogo = scanner2.nextLine();
        System.out.println("Digite o nome do Aluno");
        System.out.println("----------------------");
        String alunopedagogo = scanner2.nextLine();
    }

    private static void cadastroPedagogo() {

        try {
            Integer id = pedagogos.size() + 1;
            System.out.println("id= " + id);
            System.out.println("------* Cadastro do Pedagogo *------");
            System.out.println("Nome completo: ");
            String nome = scanner2.nextLine();

            do {
                System.out.println("Telefone XX-X-XXXX-XXXX: ");
                telefone = scanner.next();
                if (telefone.length() < 14) {
                    System.out.println("Digite corretamente o número do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/mês/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o número do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Atendimento (1 ou 2): ");
            Integer atendimento = scanner.nextInt();
            if(atendimento==1){
                System.out.println("sim");
            }else {
                System.out.println("não");
            }

            Pedagogo pedagogoInstanciados = new Pedagogo (nome, telefone, parseLocalDate(data), cpf, id, atendimento,0);
            pedagogos.add( pedagogoInstanciados);
            //String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id, Integer atendimento

        }catch (InputMismatchException e){
            System.out.println("Você não pode inserir um número");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Você informou a data de nascimento errada." +
                    "\nEscolha a opção novamente.");

        }
        menuBoasVindas();
    }

    private static void cadastroProfessor() {
        try {
            Integer id = professores.size() + 1;
            System.out.println("id= " + id);
            System.out.println("------* Cadastro do Professor *------");
            System.out.println("Nome completo: ");
            String nome = scanner2.nextLine();

            do {
                System.out.println("Telefone XX-X-XXXX-XXXX: ");
                telefone = scanner.next();
                if (telefone.length() < 14) {
                    System.out.println("Digite corretamente o número do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/mês/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o número do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Formação acadêmica (escolha uma opção): " +
                    "\n1 - Graduação incompleta" +
                    "\n2 - Graduação completa" +
                    "\n3 - Mestrado" +
                    "\n4 - Doutorado");
            int graduacao = scanner.nextInt();
            switch (graduacao){
                case 1:
                    formacaoAcademica = "Graduação incompleta";
                    break;

                case 2:
                    formacaoAcademica = "Graduação completa";
                    break;

                case 3:
                    formacaoAcademica = "Mestrado";
                    break;

                case 4:
                    formacaoAcademica = "Doutorado";
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }

            System.out.println("Experiência em desenvolvimento (escolha uma opção): " +
                    "\n1 - Front-End" +
                    "\n2 - Back-End" +
                    "\n3 - Full-Stack")
                    ;

            int desenvolv = scanner.nextInt();
            switch (desenvolv){
                case 1:
                    desenvolvimento = "Front-End";
                    break;

                case 2:
                    desenvolvimento = "Back-End";
                    break;

                case 3:
                    desenvolvimento = "Full-Stack";
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }


            System.out.println("Ativo? (sim ou não): ");
            String  atividade = scanner.next();
            estado = atividade;


            Professor professoresInstanciados = new Professor(nome, telefone, parseLocalDate(data), cpf, id,
                    formacaoAcademica, desenvolvimento, estado );
            professores.add(professoresInstanciados);

//(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id,
// String formacaoAcademica, String desenvolvimento, Boolean estado) {



            }catch (InputMismatchException e){
            System.out.println("Você não pode inserir um número");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Você informou a data de nascimento errada." +
                    "\nEscolha a opção novamente.");

        }
        menuBoasVindas();

    }

    private static void cadastroAluno() {

        try {
            Integer id = alunos.size() + 1;
            System.out.println("id= " + id);
            System.out.println("------* Cadastro do Aluno *------");
            System.out.println("Nome completo: ");
            String nome = scanner2.nextLine();

            do {
                System.out.println("Telefone XX-X-XXXX-XXXX: ");
                telefone = scanner.next();
                if (telefone.length() < 14) {
                    System.out.println("Digite corretamente o número do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/mês/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o número do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Nota (0 - 10): ");
            Double nota = scanner.nextDouble();
            System.out.println("Atendimento Pedagógico (sim ou não): ");
            String atendimento = scanner.next();
            if (atendimento.equals("sim")) {
                pedagogos.forEach(System.out::print);
                System.out.println("");
                System.out.println("Digite o id do Pedagogo: ");

                idPedagogo = scanner.nextInt();
                Integer contadorAluno = +1;
            } else {
                idPedagogo = 0;
            }


            Aluno alunosInstanciados = new Aluno(nome, telefone, parseLocalDate(data), cpf, id, matricula, nota, atendimento, idPedagogo, contadorAluno);


            alunos.add(alunosInstanciados);

            throw new DigitarNumeroException();

        }catch (DigitarNumeroException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Você não pode inserir um número");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Você informou a data de nascimento errada." +
                    "\nEscolha a opção novamente.");
            //menuBoasVindas();
        }

        menuBoasVindas();




        //String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id,
        // String matricula, Double nota, Integer atendimento


        }


    private static LocalDate parseLocalDate(String data) {
        String[] arrayData = data.split("/");
        int[] arrayDataInt = new int[3];
        for (int i = 0; i < arrayData.length; i++) {
            arrayDataInt[i] = Integer.parseInt(arrayData[i]);
        }
        return LocalDate.of(arrayDataInt[2], arrayDataInt[1], arrayDataInt[0]);
    }


}

