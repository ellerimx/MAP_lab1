public class Horario {
    private String horaInicio;
    private String horaFim;
    private String diaSemana;

    private Disciplina disciplinaCorrespondente;

    public Horario(String diaSemana, String horaInicio, String horaFim) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFim() { return horaFim; }
    public void setHoraFim(String horaFim) { this.horaFim = horaFim; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public void setDisciplinaCorrespondente(Disciplina disciplina) {
        this.disciplinaCorrespondente = disciplina;
    }

    public int informarNumeroAlunos() {
        return (disciplinaCorrespondente == null) ? 0 : disciplinaCorrespondente.informarNumeroAlunos();
    }
}
