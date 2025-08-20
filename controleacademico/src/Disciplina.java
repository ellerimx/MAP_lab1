import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {

    private String nome;
    private String horarioDisciplina;

    private Professor professor; //1..n com Professor
    private Horario horario; // 1..1 com composição
    private final List<Aluno> alunos = new ArrayList<>(); // 1..n com Aluno

    public Disciplina(String nome, Horario horario) {
        this.nome = nome;
        setHorario(horario);
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getHorarioDisciplina() { return horarioDisciplina; }
    public void setHorarioDisciplina(String horarioDisciplina) { this.horarioDisciplina = horarioDisciplina; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public Horario getHorario() { return horario; }
    public void setHorario(Horario horario) {
        this.horario = horario;
        if (horario != null) {
            horario.setDisciplinaCorrespondente(this); // para uso de composição
        }
    }

    public List<Aluno> getAlunos() { return Collections.unmodifiableList(alunos); }

    void adicionarAluno(Aluno a) {
        if (a != null && !alunos.contains(a)) alunos.add(a);
    }

    public int informarNumeroAlunos() {
        return alunos.size();
    }

    public List<Aluno> informarAlunos() {
        return getAlunos();
    }

    public String informarHorarioDisciplina() {
        if (horario == null) return "Disciplina sem horário definido.";
        return horario.getDiaSemana() + ", horário: " + horario.getHoraInicio() + "–" + horario.getHoraFim();
    }
}
