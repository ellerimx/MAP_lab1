package main;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String idTurma;
    private Disciplina disciplina;
    private List<Aluno> listaDeAlunos = new ArrayList<>();
    private Professor professor;
    private String horario;

    public Turma(Disciplina disciplina, String idTurma) {
        this.disciplina = disciplina;
        this.idTurma = idTurma;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !listaDeAlunos.contains(aluno)) {
            listaDeAlunos.add(aluno);
        }
    }

    public int getNumeroDeAlunos() {
        return listaDeAlunos.size();
    }
}
