package escola;


public class Matricula {
    private Aluno aluno;
    private String dataMatricula;
    private String disciplina;

    public Matricula(Aluno aluno, String dataMatricula, String disciplina) {
        this.aluno =  aluno;
        this.dataMatricula = dataMatricula;
        this.disciplina = disciplina;
    }
    public void exibirDetalhes(){
        aluno.exibirDetalhes();
        System.out.println("Data matricula: 0" + getDataMatricula()+"\nDisciplina: "+getDisciplina());
    }
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
