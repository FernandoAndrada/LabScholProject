package aplication;

// Listar todas as pessoas cadastradas.
// O usu�rio dever� informar quais categorias de pessoas deseja listar (deve-se listar C�digo, Nome e CPF):
//Alunos
//Professores
//Funcion�rios
//Todos

//Relat�rio dos Alunos.
// O usu�rio deve escolher qual categoria apresentar
// (deve-se listar c�digo, nota e total de atendimentos pedag�gicos):
//Ativo
//Irregular
//Atendimento pedag�gico
//Inativo
//Todos

//Relat�rio dos professores. O usu�rio deve escolher qual categoria apresentar:
//Front-End
//Back-End
//Full-Stack
//Todos

//Alunos com mais atendimentos pedag�gicos
//Pedagogos com mais atendimentos pedag�gicos

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
        Aluno teste2 = new Aluno("Fernando Teste2","48-2-9999-9999",parseLocalDate(data2),"013-345-678/92", id=11,"Irregular",9.0,"n�o",0,0);
        Aluno teste3 = new Aluno("Fernando Teste3","48-3-9999-9999",parseLocalDate(data2),"014-345-678/92", id=12,"Em atendimento Pedag�gico.",8.0,"sim",20,0);
        Aluno teste4 = new Aluno("Fernando Teste4","48-4-9999-9999",parseLocalDate(data2),"015-345-678/92", id=13,"Inativo",7.0,"n�o",0,0);
        alunos.add(teste1);
        alunos.add(teste2);
        alunos.add(teste3);
        alunos.add(teste4);

        Professor professor1 = new Professor("Fernando Prof Teste1", "48-1-2222-2222", parseLocalDate(data2), "111-222-333-44", id=14, "Gradua��o incompleta","Front-End", "sim" );
        Professor professor2 = new Professor("Fernando Prof Teste2", "48-2-2222-2222", parseLocalDate(data2), "222-222-333-44", id=15, "Gradua��o completa","Back-End", "n�o" );
        Professor professor3 = new Professor("Fernando Prof Teste3", "48-3-2222-2222", parseLocalDate(data2), "333-222-333-44", id=16, "Mestrado","Full-Stack", "sim" );
        Professor professor4 = new Professor("Fernando Prof Teste4", "48-4-2222-2222", parseLocalDate(data2), "444-222-333-44", id=17, "Doutorado","Front-End", "n�o" );
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
        System.out.println("Bem-vindo, escolha a op��o desejada:" +
                "\n------------------------------------" +
                "\n1 - Fazer Cadastro" +
                "\n2 - Visualizar Cadastros" +
                "\n3 - Relat�rios Alunos" +
                "\n4 - Relat�rios Professores" +
                "\n5 - Relat�rios Pedag�gicos" +
                "\n6 - Alterar condi��o de matr�cula" +
                "\n7 - Marcar atendimento pedag�gico" +
                "\n8 - Encerrar a sess�o");

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
                        System.out.println("Condi��o atual: " + alunos.get(i).getMatricula());
                        System.out.println("");
                    }

                }
                condicaoAluno();


                for(int i = 0; i < alunos.size(); i++) {
                    if (alunos.get(i).getId().equals(idaluno)) {
                        alunos.get(i).setMatricula(matricula);

                        System.out.println("Condi��o alterada com sucesso.");
                        System.out.println("");
                    }
                }
                menuBoasVindas();

            case 7:

                marcarAtendimentoPedagogico();

                menuBoasVindas();



            case 8:
                System.out.println("Agradecemos sua presen�a.");
                System.exit(0);
                break;

            default:
                System.out.println("Op��o inv�lida!");





        }
        }catch (InputMismatchException e){
            System.out.println("Voc� tem que digitar um n�mero");
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
        System.out.println("Escolha uma op��o:" +
                "\n1 - Alunos com mais atendimentos pedag�gicos" +
                "\n2 - Pedagogos com mais atendimentos pedag�gicos");
        int relatPedagogico = scanner.nextInt();
        switch (relatPedagogico){
            case 1:

                for(int i = 0; i < alunos.size(); i++) {
                    if ((alunos.get(i).getMatricula().equals("Em atendimento Pedag�gico."))
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
                    if ((alunos.get(i).getMatricula().equals("Em atendimento Pedag�gico."))
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
                System.out.println("Op��o inv�lida");
        }
    }

    private static void relatorioProfessores() {
        try {


            System.out.println("Escolha o relat�rio a ser listado:" +
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
                    // se condi��o matricula for igual a Inativo imprime professores
                    System.out.println("Professores:");
                    professores.forEach(System.out::print);
                    System.out.println("");
                    System.out.println("");
                    menuBoasVindas();

                    break;

                default:
                    System.out.println("Op��o inv�lida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Voc� tem que digitar um n�mero");
        }


    }

    private static void relatorioAlunos() {

        try {


            System.out.println("Escolha o relat�rio a ser listado:" +
                    "\n-----------------------------------------" +
                    "\n1 - Alunos Ativos" +
                    "\n2 - Alunos Irregulares" +
                    "\n3 - Alunos em Atendimento pedag�gico" +
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

                    // se condi��o matricula for igual a Irregulares imprime alunos
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
                    // se condi��o matricula for igual a Atendimento pedag imprime alunos
                    for(int i = 0; i < alunos.size(); i++) {
                        if ((alunos.get(i).getMatricula().equals("Em atendimento Pedag�gico."))
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
                    // se condi��o matricula for igual a Inativo imprime alunos
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
                    System.out.println("Op��o inv�lida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Voc� tem que digitar um n�mero");
        }


    }

    private static void listarCadastros() {
        System.out.println("<<<<<<* Lista Cadastros *>>>>>>");
        System.out.println(" Digite um n�mero para ver " +
                "\n as pessoas cadastradas:" +
                "\n1 - Alunos" +
                "\n2 - Professores" +
                "\n3 - Funcion�rios" +
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
                System.out.println("Op��o inv�lida!");
        }
    }

    private static void fazerCadastros() {

        try {


            System.out.println("<<<<<<<<<<<< Cadastros >>>>>>>>>>>>");
            System.out.println("  Bem-vindo ao setor de cadastro," +
                    "\n  por favor escolha uma op��o:" +
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
                    System.out.println("Op��o Inv�lida!");
            }
        }catch (InputMismatchException e){
            System.out.println("Voc� tem que digitar um n�mero!");
        }
    }

    private static void condicaoAluno() {

        try {


            System.out.println("Escolha a condi��o de matr�cula do aluno:" +
                    "\n-----------------------------------------" +
                    "\n1 - Ativo" +
                    "\n2 - Irregular" +
                    "\n3 - Atendimento pedag�gico" +
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
                    matricula = "Em atendimento Pedag�gico.";
                    System.out.println("O aluno encontra-se " + matricula + ".");
                    atendimentoPedagogico();
                    break;

                case 4:
                    matricula = "Inativo";
                    System.out.println("O aluno encontra-se " + matricula + ".");
                    break;

                default:
                    System.out.println("Op��o inv�lida!");

            }
        }catch (InputMismatchException e){
            System.out.println("Voc� tem que digitar um n�mero");
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
                    System.out.println("Digite corretamente o n�mero do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/m�s/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o n�mero do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Atendimento (1 ou 2): ");
            Integer atendimento = scanner.nextInt();
            if(atendimento==1){
                System.out.println("sim");
            }else {
                System.out.println("n�o");
            }

            Pedagogo pedagogoInstanciados = new Pedagogo (nome, telefone, parseLocalDate(data), cpf, id, atendimento,0);
            pedagogos.add( pedagogoInstanciados);
            //String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id, Integer atendimento

        }catch (InputMismatchException e){
            System.out.println("Voc� n�o pode inserir um n�mero");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Voc� informou a data de nascimento errada." +
                    "\nEscolha a op��o novamente.");

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
                    System.out.println("Digite corretamente o n�mero do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/m�s/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o n�mero do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Forma��o acad�mica (escolha uma op��o): " +
                    "\n1 - Gradua��o incompleta" +
                    "\n2 - Gradua��o completa" +
                    "\n3 - Mestrado" +
                    "\n4 - Doutorado");
            int graduacao = scanner.nextInt();
            switch (graduacao){
                case 1:
                    formacaoAcademica = "Gradua��o incompleta";
                    break;

                case 2:
                    formacaoAcademica = "Gradua��o completa";
                    break;

                case 3:
                    formacaoAcademica = "Mestrado";
                    break;

                case 4:
                    formacaoAcademica = "Doutorado";
                    break;

                default:
                    System.out.println("Op��o Inv�lida!");
            }

            System.out.println("Experi�ncia em desenvolvimento (escolha uma op��o): " +
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
                    System.out.println("Op��o Inv�lida!");
            }


            System.out.println("Ativo? (sim ou n�o): ");
            String  atividade = scanner.next();
            estado = atividade;


            Professor professoresInstanciados = new Professor(nome, telefone, parseLocalDate(data), cpf, id,
                    formacaoAcademica, desenvolvimento, estado );
            professores.add(professoresInstanciados);

//(String nome, String telefone, LocalDate dataNascimento, String cpf, Integer id,
// String formacaoAcademica, String desenvolvimento, Boolean estado) {



            }catch (InputMismatchException e){
            System.out.println("Voc� n�o pode inserir um n�mero");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Voc� informou a data de nascimento errada." +
                    "\nEscolha a op��o novamente.");

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
                    System.out.println("Digite corretamente o n�mero do telefone.");
                } else {

                }
            } while (!(telefone.length() == 14));

            System.out.println("Data de Nascimento dia/m�s/ano");
            String data = scanner.next();

            do {
                System.out.println("CPF XXX-XXX-XXX/XX: ");
                cpf = scanner.next();
                if (cpf.length() < 14) {
                    System.out.println("Digite corretamente o n�mero do CPF.");
                } else {

                }
            } while (!(cpf.length() == 14));

            System.out.println("Nota (0 - 10): ");
            Double nota = scanner.nextDouble();
            System.out.println("Atendimento Pedag�gico (sim ou n�o): ");
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
            System.out.println("Voc� n�o pode inserir um n�mero");
            //menuBoasVindas();

        }catch (DateTimeException e){
            System.out.println("Voc� informou a data de nascimento errada." +
                    "\nEscolha a op��o novamente.");
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

