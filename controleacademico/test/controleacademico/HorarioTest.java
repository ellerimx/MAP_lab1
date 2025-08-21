package controleacademico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorarioTest {

    private Horario horario;
    private Disciplina disciplinaTeste;
    private Aluno alunoTeste;
    private static final String DIA_PADRAO = "Segunda-feira";
    private static final String HORA_INICIO_PADRAO = "08:00";
    private static final String HORA_FIM_PADRAO = "09:40";

    @BeforeEach
    void setUp() {
        horario = new Horario(DIA_PADRAO, HORA_INICIO_PADRAO, HORA_FIM_PADRAO);
        disciplinaTeste = new Disciplina("Métodos Avançados em Programação", horario);
        alunoTeste = new Aluno(1, "João da Silva");
    }

    // Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        Assertions.assertEquals(DIA_PADRAO, horario.getDiaSemana(), "O dia da semana deve ser o mesmo do construtor.");
        Assertions.assertEquals(HORA_INICIO_PADRAO, horario.getHoraInicio(), "A hora de início deve ser a mesma do construtor.");
        Assertions.assertEquals(HORA_FIM_PADRAO, horario.getHoraFim(), "A hora de fim deve ser a mesma do construtor.");
    }
    
    @Test
    void testSetDiaSemana() {
        String novoDia = "Quarta-feira";
        horario.setDiaSemana(novoDia);
        Assertions.assertEquals(novoDia, horario.getDiaSemana(), "O dia da semana deve ser atualizado.");
    }

    @Test
    void testSetHoraInicio() {
        String novaHoraInicio = "10:00";
        horario.setHoraInicio(novaHoraInicio);
        Assertions.assertEquals(novaHoraInicio, horario.getHoraInicio(), "A hora de início deve ser atualizada.");
    }

    @Test
    void testSetHoraFim() {
        String novaHoraFim = "11:40";
        horario.setHoraFim(novaHoraFim);
        Assertions.assertEquals(novaHoraFim, horario.getHoraFim(), "A hora de fim deve ser atualizada.");
    }

    @Test
    void testSetDisciplinaCorrespondente() {
        horario.setDisciplinaCorrespondente(disciplinaTeste);
        Assertions.assertDoesNotThrow(() -> horario.informarNumeroAlunos());
    }

    @Test
    void testInformarNumeroAlunos_comDisciplina() {
        horario.setDisciplinaCorrespondente(disciplinaTeste);
        
        disciplinaTeste.adicionarAluno(alunoTeste);

        Assertions.assertEquals(1, horario.informarNumeroAlunos(), "O método deve retornar o número de alunos da disciplina correspondente.");
    }

    @Test
    void testInformarNumeroAlunos_semDisciplina() {
        Assertions.assertEquals(0, horario.informarNumeroAlunos(), "Deve retornar 0 se não houver disciplina associada.");
    }
}
