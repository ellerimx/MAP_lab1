package controleacademico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AlunoTest {

    private Aluno aluno;
    private Disciplina disciplinaTeste;
    private static final int ID_PADRAO = 1;
    private static final String NOME_PADRAO = "João da Silva";

    @BeforeEach //garante que nenhum valor seja armazenado
    void setUp() {
        Horario horario = new Horario("Segunda-feira", "08:00", "09:40");
        
        aluno = new Aluno(ID_PADRAO, NOME_PADRAO);
        disciplinaTeste = new Disciplina("Lógica de Programação", horario);
    }

    // Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        Assertions.assertEquals(ID_PADRAO, aluno.getId(), "O ID deve ser o igual ao do construtor.");
        Assertions.assertEquals(NOME_PADRAO, aluno.getNome(), "O nome inicial deve ser o mesmo do construtor.");
        Assertions.assertNotNull(aluno.getDisciplinas(), "A lista de disciplinas não deve ser nula.");
        Assertions.assertTrue(aluno.getDisciplinas().isEmpty(), "A lista de disciplinas deve estar vazia inicialmente.");
    }

    // Teste 2: setDisciplina()
    @Test
    void testSetDisciplina() {
        String disciplinaEsperada = "História";
        aluno.setDisciplina(disciplinaEsperada);

        // ASSERT
        Assertions.assertEquals(disciplinaEsperada, aluno.getDisciplina(), "O campo disciplina deve ser atualizado.");
    }

    // teste de disciplina válida
    @Test
    void testMatricular_disciplinaValida() {
        aluno.matricular(disciplinaTeste);

        List<Disciplina> disciplinasDoAluno = aluno.getDisciplinas();
        Assertions.assertEquals(1, disciplinasDoAluno.size(), "O número de disciplinas deve ser 1.");
        Assertions.assertTrue(disciplinasDoAluno.contains(disciplinaTeste), "A lista deve conter a disciplina adicionada.");
    }

    // tentativa de matricular disciplina nula
    @Test
    void testMatricular_disciplinaNula() {
        int tamanhoInicial = aluno.getDisciplinas().size();
        
        aluno.matricular(null);

        Assertions.assertEquals(tamanhoInicial, aluno.getDisciplinas().size(), "A lista não deve ser alterada.");
    }

    @Test //ao tentar matricular uma disciplina que ja está
    void testMatricular_disciplinaJaExistente() {
        aluno.matricular(disciplinaTeste); 

        aluno.matricular(disciplinaTeste); 

        Assertions.assertEquals(1, aluno.getDisciplinas().size(), "A mesma disciplina não deve ser adicionada mais de uma vez.");
    }
}