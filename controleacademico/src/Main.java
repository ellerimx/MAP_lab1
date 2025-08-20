//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // cadastrando horarios
        Horario horario1 = new Horario("Segunda-feira", "07:00", "09:00");
        Horario horario2 = new Horario("Quarta-feira", "11:00", "13:00");

        //cadastrando disciplinas
        Disciplina disciplina1 = new Disciplina("Métodos Avançados de Programação", horario1);
        Disciplina disciplina2 = new Disciplina("Banco de Dados", horario2);

        //cadastrando professor
        Professor professor1 = new Professor(1, "Carlos Silva");
        professor1.adicionarDisciplina(disciplina1);
        professor1.adicionarDisciplina(disciplina2);

        // cadastrando alunos
        Aluno a1 = new Aluno(1, "Ana Souza");
        Aluno a2 = new Aluno(2, "João Pereira");

        // matriculando alunos
        a1.matricular(disciplina1);
        a1.matricular(disciplina2);
        a2.matricular(disciplina2);

        // verificando metodos
        System.out.println("--- PROFESSOR ---");
        professor1.mostrarDisciplinas();
        professor1.mostrarHorario();

        System.out.println("\n--- ALUNO ANA ---");
        a1.mostrarDisciplinasMatriculado();
        a1.mostrarHorario();

        System.out.println("\n--- ALUNO JOÃO ---");
        a2.mostrarDisciplinasMatriculado();
        a2.mostrarHorario();

        System.out.println("\n--- DISCIPLINA BANCO DE DADOS ---");
        System.out.println("Número de alunos: " + disciplina2.informarNumeroAlunos());
        System.out.println("Horário: " + disciplina2.informarHorarioDisciplina());

    }
}