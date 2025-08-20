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
        Disciplina disciplina3 = new Disciplina("TAAL", null);

        //cadastrando professor
        Professor professor1 = new Professor(1, "Carlos Silva");
        professor1.adicionarDisciplina(disciplina1);
        professor1.adicionarDisciplina(disciplina2);

        // cadastrando alunos
        Aluno a1 = new Aluno(1, "Ana Souza");
        Aluno a2 = new Aluno(2, "João Pereira");
        Aluno a3 = new Aluno(3, "Luisa Moura");

        // matriculando alunos
        a1.matricular(disciplina1);
        a1.matricular(disciplina2);
        a2.matricular(disciplina2);
        a3.matricular(disciplina2);

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
        
        System.out.println("\n--- ALUNO LUISA ---");
        a3.mostrarDisciplinasMatriculado();
        a3.mostrarHorario();

        
        System.out.println("\n--- DISCIPLINA MÉTODOS AVANÇADOS DE PROGRAMAÇÃO ---");
        System.out.println("Número de alunos: " + disciplina1.informarNumeroAlunos());
        System.out.println("Horário: " + disciplina1.informarHorarioDisciplina());
        System.out.println("Alunos matriculados: "+ disciplina1.getAlunos());
        
        
        System.out.println("\n--- DISCIPLINA BANCO DE DADOS ---");
        System.out.println("Número de alunos: " + disciplina2.informarNumeroAlunos());
        System.out.println("Horário: " + disciplina2.informarHorarioDisciplina());
        System.out.println("Alunos matriculados: "+ disciplina2.getAlunos());
        
        System.out.println("\n--- DISCIPLINA TAAL---");
        System.out.println("Número de alunos: " + disciplina3.informarNumeroAlunos());
        System.out.println("Horário: " + disciplina3.informarHorarioDisciplina());
        System.out.println("Alunos matriculados: "+ disciplina3.getAlunos());
        
      
    }
}