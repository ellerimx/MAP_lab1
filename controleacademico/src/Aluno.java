import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private int id;
    private String nome;
    private String disciplina;

    private final List<Disciplina> disciplinas = new ArrayList<>(); // 1..n disciplinas


    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }


    public List<Disciplina> getDisciplinas() { return disciplinas; }
    public void matricular(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.adicionarAluno(this);
        }
    }

    public void mostrarDisciplinasMatriculado() {
        System.out.println("Disciplinas de " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(" - " + disciplina.getNome());
        }
    }

    public void mostrarHorario() {
        System.out.println("Horários de " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            Horario horario = disciplina.getHorario();
            if (horario != null) {
                System.out.println(" - " + disciplina.getNome() + ": " + horario.getDiaSemana()
                        + " " + horario.getHoraInicio() + "–" + horario.getHoraFim());
            }
        }
    }
}
