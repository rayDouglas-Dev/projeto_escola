package aplicacao;

import escola.Aluno;
import escola.Matricula;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // metodos estaticos
    static Scanner tc = new Scanner(System.in);
    static Aluno aluno;
    static Matricula matricula;

    // listas de alunos e matriculas
    static List<Aluno> alunos = new ArrayList<>();
    static List<Matricula> matriculas = new ArrayList<>();

    public static void main(String[] args) {
        boolean loop = true;
        while(loop){
            System.out.println("--- MENU ---");
            System.out.println("1 - cadastrar aluno\n" +
                               "2 - matricular aluno" +
                             "\n3 - remover aluno" +
                             "\n4 - exibir informações" +
                             "\n5 - Sair ");
            System.out.println("Escolha uma opção: ");
            int op = tc.nextInt();
            tc.nextLine();
            switch (op){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    realizarMatricula();
                    break;
                case 3:
                    removerMatricula();
                    break;
                case 4:
                    exibirInformacoes();
                    break;
                case 5:
                    System.out.println("Sair so programa");
                    loop = false;
                default:
            }
        }
    }
    static void cadastrarAluno(){
        System.out.println("Informe o nome: ");
        //aluno.setNome(tc.nextLine());
        String nome = tc.nextLine();
        System.out.println("Informe o cpf: ");
        //aluno.setCpf(tc.nextLine());
        String cpf = tc.nextLine();
        System.out.println("Informe matricula: ");
        //aluno.setMatricula(tc.nextLine());
        String matricula = tc.nextLine();
        System.out.println("Informe o curso: ");
        String curso = tc.nextLine();
        aluno = new Aluno(nome,cpf,matricula,curso);
        // aqui adiciona mais 1 aluno na lista
        alunos.add(aluno);
        System.out.println("Cadastro realizado com sucesso!");
    }
    static void realizarMatricula(){
        if (alunos.isEmpty()){ // o comando .isEmpty verifica se a lista ta vazia.
            System.out.println("Não há nenhum aluno cadastrado.");
        }else{
            // lista de alunos cadastrados
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println(i+" - "+alunos.get(i).getNome());
            }
            System.out.println("Escolha um dos alunos para realizar a matricula: ");
            int indice = tc.nextInt() - 1;
            Aluno alunoSelecionado = alunos.get(indice);

            System.out.println("### Realizar Matrícula ###");
            System.out.println("Data de Nascimento (dd/mm/aaaa) : ");
            String dataMatricula = tc.next();
            System.out.println("Disciplina: ");
            String disciplina = tc.next();

            matricula = new Matricula(alunoSelecionado, dataMatricula, disciplina);
            // aqui adiciona mais 1 da lista de alunos matriculados
            matriculas.add(matricula);
            System.out.println("Matricula realizada com sucesso!");
        }
    }
    static void removerMatricula(){
        if (matriculas.isEmpty()){ // o comando .isEmpty verifica se a lista ta vazia.
            System.out.println("Não há nenhum aluno matriculado.");
        }else{
            // lista de alunos matriculados
            for (int i = 0; i < matriculas.size(); i++) {
                System.out.println(i+" - "+matriculas.get(i).getAluno().getNome());
            }
            System.out.println("Escolha um dos alunos para remover a matricula: ");
            int indice = tc.nextInt() - 1;

            matriculas.remove(indice);
            System.out.println("Matricula removida com sucesso!");
        }
    }
    static void exibirInformacoes(){
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
        }else {
            if (matriculas.isEmpty()){
                System.out.println("Não há nenhum aluno Matriculados");
            }else {
                matricula.exibirDetalhes();
            }
        }
    }
}