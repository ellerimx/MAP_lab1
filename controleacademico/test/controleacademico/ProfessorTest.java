package controleacademico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProfessorTest {

    private Professor professor;
    private Disciplina disciplinaTeste1;
    private Disciplina disciplinaTeste2;
    private Horario horarioTeste;
    private static final int ID_PADRAO = 101;
    private static final String NOME_PADRAO = "Sabrina de Figueirêdo Souto";
    private static final String NOME_DISCIPLINA_1 = "Engenharia de Software";
    private static final String NOME_DISCIPLINA_2 = "Sistemas Operacionais";
    
    @BeforeEach
    void setUp() {
        professor = new Professor(ID_PADRAO, NOME_PADRAO);
        horarioTeste = new Horario("Segunda-feira", "14:00", "15:40");
        disciplinaTeste1 = new Disciplina(NOME_DISCIPLINA_1, horarioTeste);
        disciplinaTeste2 = new Disciplina(NOME_DISCIPLINA_2, null); //disciplina sem horário
    }

    @Test
    void testConstrutorEGetters() {
        Assertions.assertEquals(ID_PADRAO, professor.getId(), "O ID deve ser o mesmo do construtor.");
        Assertions.assertEquals(NOME_PADRAO, professor.getNome(), "O nome deve ser o mesmo do construtor.");
        Assertions.assertNotNull(professor.getDisciplinas(), "A lista de disciplinas não deve ser nula.");
        Assertions.assertTrue(professor.getDisciplinas().isEmpty(), "A lista de disciplinas deve estar vazia inicialmente.");
    }
    
    @Test
    void testSetDisciplina() {
        String novaDisciplinaEsperada = "Lógica de Programação";
        professor.setDisciplina(novaDisciplinaEsperada);

        Assertions.assertEquals(novaDisciplinaEsperada, professor.getDisciplina(), "O campo disciplina deve ser atualizado.");
    }

    @Test
    void testAdicionarDisciplina() {
        professor.adicionarDisciplina(disciplinaTeste1);
        List<Disciplina> disciplinasDoProfessor = professor.getDisciplinas();
        Assertions.assertEquals(1, disciplinasDoProfessor.size(), "O número de disciplinas deve ser 1 após a adição.");
        Assertions.assertTrue(disciplinasDoProfessor.contains(disciplinaTeste1), "A lista deve conter a disciplina adicionada.");
    }

    // adicionar disciplina nula
    @Test
    void testAdicionarDisciplina_disciplinaNula() {
        int tamanhoInicial = professor.getDisciplinas().size();
        professor.adicionarDisciplina(null);
        Assertions.assertEquals(tamanhoInicial, professor.getDisciplinas().size(), "A lista não deve ser alterada ao adicionar uma disciplina nula.");
    }

    // adicionar disciplina já existente
    @Test
    void testAdicionarDisciplina_disciplinaExistente() {
        professor.adicionarDisciplina(disciplinaTeste1);
        professor.adicionarDisciplina(disciplinaTeste1);
        Assertions.assertEquals(1, professor.getDisciplinas().size(), "A mesma disciplina não deve ser adicionada mais de uma vez.");
    }

    @Test
    void testSetDisciplinaProfessor() {
        professor.adicionarDisciplina(disciplinaTeste1);
        Assertions.assertEquals(professor, disciplinaTeste1.getProfessor(), "O professor deve ser definido na disciplina quando é adicionado.");
    }
}