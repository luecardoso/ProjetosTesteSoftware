package ProjetoBTK.TestesDeSoftware;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
	public void testGetNome() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João");

		assertTrue(pessoa.getNome().equals("João"));
		System.out.println("Teste executado com sucesso!");
	}
}
