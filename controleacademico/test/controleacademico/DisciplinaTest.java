package controleacademico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DisciplinaTest {

    private Disciplina disciplina;
    private Professor professorTeste;
    private Horario horarioTeste;
    private Aluno alunoTeste;
    private static final String NOME_DISCIPLINA_PADRAO = "Engenharia de Software";
    private static final String NOME_ALUNO_PADRAO = "Mariana Silva";
    private static final String DIA_PADRAO = "Quinta-feira";
    private static final String HORA_INICIO_PADRAO = "14:00";
    private static final String HORA_FIM_PADRAO = "15:40";

    @BeforeEach 
    void setUp() {
        horarioTeste = new Horario(DIA_PADRAO, HORA_INICIO_PADRAO, HORA_FIM_PADRAO);
        disciplina = new Disciplina(NOME_DISCIPLINA_PADRAO, horarioTeste);
        professorTeste = new Professor(101, "Dr. Ricardo");
        alunoTeste = new Aluno(201, NOME_ALUNO_PADRAO);
    }

    //Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        Assertions.assertEquals(NOME_DISCIPLINA_PADRAO, disciplina.getNome(), "O nome da disciplina deve ser o mesmo do construtor.");
        Assertions.assertEquals(horarioTeste, disciplina.getHorario(), "O horário deve ser o mesmo do construtor.");
        Assertions.assertNotNull(disciplina.getAlunos(), "A lista de alunos não deve ser nula.");
        Assertions.assertTrue(disciplina.getAlunos().isEmpty(), "A lista de alunos deve começar vazia.");
    }
    
    @Test
    void testSetNome() {
        String novoNome = "Algoritmos e Estruturas de Dados";
        disciplina.setNome(novoNome);
        Assertions.assertEquals(novoNome, disciplina.getNome(), "O nome da disciplina deve ser atualizado.");
    }

    @Test
    void testSetHorario() {
        Horario novoHorario = new Horario("Terça-feira", "10:00", "11:40");
        disciplina.setHorario(novoHorario);
        Assertions.assertEquals(novoHorario, disciplina.getHorario(), "O horário da disciplina deve ser atualizado.");
    }

    @Test
    void testSetProfessor() {
        disciplina.setProfessor(professorTeste);
        Assertions.assertEquals(professorTeste, disciplina.getProfessor(), "O professor da disciplina deve ser atualizado.");
    }

    // Testes para adição de um aluno
    @Test
    void testAdicionarAluno() {
        disciplina.adicionarAluno(alunoTeste);
        List<Aluno> alunosDaDisciplina = disciplina.getAlunos();
        Assertions.assertEquals(1, alunosDaDisciplina.size(), "O número de alunos deve ser 1 após a adição.");
        Assertions.assertTrue(alunosDaDisciplina.contains(alunoTeste), "A lista deve conter o aluno adicionado.");
    }

    // aluno nulo
    @Test
    void testAdicionarAluno_alunoNulo() {
        int tamanhoInicial = disciplina.getAlunos().size();
        disciplina.adicionarAluno(null);
        Assertions.assertEquals(tamanhoInicial, disciplina.getAlunos().size(), "A lista de alunos não deve ser alterada ao adicionar um aluno nulo.");
    }

    // aluno já existente
    @Test
    void testAdicionarAluno_alunoExistente() {
        disciplina.adicionarAluno(alunoTeste);
        disciplina.adicionarAluno(alunoTeste); // Tenta adicionar o mesmo aluno novamente
        Assertions.assertEquals(1, disciplina.getAlunos().size(), "A mesma disciplina não deve ser adicionada mais de uma vez.");
    }

    @Test
    void testInformarNumeroAlunos() {
        disciplina.adicionarAluno(alunoTeste);
        Assertions.assertEquals(1, disciplina.informarNumeroAlunos(), "O método deve retornar o número correto de alunos.");
    }
    
    @Test
    void testInformarAlunos() {
        // verifica se inicialmente a lista está vazia 
        List<Aluno> alunosInicial = disciplina.informarAlunos();
        Assertions.assertTrue(alunosInicial.isEmpty(), "A lista de alunos deve estar vazia inicialmente.");

        // adiciona um aluno e verifica se a lista o contém
        disciplina.adicionarAluno(alunoTeste);
        List<Aluno> alunosAtualizada = disciplina.informarAlunos();
        Assertions.assertEquals(1, alunosAtualizada.size(), "A lista retornada deve conter 1 aluno.");
        Assertions.assertTrue(alunosAtualizada.contains(alunoTeste), "A lista retornada deve conter o aluno adicionado.");

        // adiciona um segundo aluno
        Aluno segundoAluno = new Aluno(202, "Pedro Silva");
        disciplina.adicionarAluno(segundoAluno);
        List<Aluno> alunosComDois = disciplina.informarAlunos();
        Assertions.assertEquals(2, alunosComDois.size(), "A lista retornada deve conter 2 alunos.");
        Assertions.assertTrue(alunosComDois.contains(segundoAluno), "A lista retornada deve conter o segundo aluno adicionado.");
    }

    // informarHorarioDisciplina() - com horário definido
    @Test
    void testInformarHorarioDisciplina_comHorario() {
        String horarioEsperado = DIA_PADRAO + ", de " + HORA_INICIO_PADRAO + "-" + HORA_FIM_PADRAO;
        Assertions.assertEquals(horarioEsperado, disciplina.informarHorarioDisciplina(), "A string do horário deve ser formatada corretamente.");
    }

    // informarHorarioDisciplina() - sem horário
    @Test
    void testInformarHorarioDisciplina_semHorario() {
        disciplina.setHorario(null);
        Assertions.assertEquals("Disciplina sem horário definido.", disciplina.informarHorarioDisciplina(), "A mensagem deve indicar que o horário não está definido.");
    }
}