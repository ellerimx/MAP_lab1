import java.util.ArrayList;
import java.util.List;

public class Professor {

    private int id;
    private String nome;
    private String disciplina;

    private final List<Disciplina> disciplinas = new ArrayList<>(); // professor 1..n Disciplinas

    public Professor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    public List<Disciplina> getDisciplinas() { return disciplinas; }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.setProfessor(this);
        }
    }

    public void mostrarDisciplinas() {
        System.out.println("Disciplinas lecionadas por " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(" - " + disciplina.getNome());
        }
    }

    public void mostrarHorario() {
        System.out.println("Horários das disciplinas de " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            Horario h = disciplina.getHorario();
            if (h != null) {
                System.out.println(" - " + disciplina.getNome() + ": " + h.getDiaSemana()
                        + " " + h.getHoraInicio() + "–" + h.getHoraFim());
            }
        }
    }
}
