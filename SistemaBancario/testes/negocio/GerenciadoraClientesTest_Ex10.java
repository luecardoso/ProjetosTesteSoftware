package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operacoes
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Lucas
 * @date 02/02/2025
 */
public class GerenciadoraClientesTest_Ex10 {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {
	
		/* ========== Montagem do cenario ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe", 34, "felipe@gmail.com", 2, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	/**
	 * Teste basico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Lucas
	 * @date 02/02/2025
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Execucao ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verificacoes ========== */
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste basico da pesquisa por um cliente que nao existe.
	 * 
	 * @author Lucas
	 * @date 02/02/2025
	 */
	@Test
	public void testPesquisaClienteInexistente() {

		/* ========== Execucao ========== */
		Cliente cliente = gerClientes.pesquisaCliente(1001);
		
		/* ========== Verificacoes ========== */
		assertNull(cliente);
		
	}
	
	/**
	 * Teste basico da remocao de um cliente a partir do seu ID.
	 * 
	 * @author Lucas
	 * @date 02/02/2025
	 */
	@Test
	public void testRemoveCliente() {
		
		/* ========== Execucao ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verificacoes ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
	/**
	 * Teste da tentativa de remocao de um cliente inexistente.
	 * 
	 * @author Lucas
	 * @date 02/02/2025
	 */
	@Test
	public void testRemoveClienteInexistente() {

	
		/* ========== Execucao ========== */
		boolean clienteRemovido = gerClientes.removeCliente(1001);
		
		/* ========== Verificacoes ========== */
		assertThat(clienteRemovido, is(false));
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		
	}
	
	/**
	 * Validacao da idade de um cliente quando a mesma esta no intervalo permitido.
	 * 
	 * @author Lucas
	 * @throws IdadeNaoPermitidaException 
	 * @date 02/02/2025
	 */
	@Test
	public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cenario ========== */		
		Cliente cliente = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);
		
		/* ========== Execucao ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verificacoes ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validacao da idade de um cliente quando a mesma esta no intervalo permitido.
	 * 
	 * @author Lucas
	 * @throws IdadeNaoPermitidaException 
	 * @date 02/02/2025
	 */
	@Test
	public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cenario ========== */		
		Cliente cliente = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);
		
		/* ========== Execucao ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verificacoes ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validacao da idade de um cliente quando a mesma esta no intervalo permitido.
	 * 
	 * @author Lucas
	 * @throws IdadeNaoPermitidaException 
	 * @date 02/02/2025
	 */
	@Test
	public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cenario ========== */		
		Cliente cliente = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);
		
		/* ========== Execucao ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verificacoes ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validacao da idade de um cliente quando a mesma esta abaixo intervalo permitido.
	 * 
	 * @author Lucas
	 * @throws IdadeNaoPermitidaException 
	 * @date 02/02/2025
	 */
	@Test
	public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cenario ========== */		
		Cliente cliente = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);

		/* ========== Execucao ========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
			//fail();
		} catch (Exception e) {
			/* ========== Verificacoes ========== */
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}
	
	/**
	 * Validacao da idade de um cliente quando a mesma esta acima intervalo permitido.
	 * 
	 * @author Lucas
	 * @throws IdadeNaoPermitidaException 
	 * @date 02/02/2025
	 */
	@Test
	public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {
		
		/* ========== Montagem do Cenario ========== */		
		Cliente cliente = new Cliente(1, "Lucas", 31, "lucas@gmail.com", 1, true);
		/* ========== Execucao ========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
		} catch (Exception e) {
			/* ========== Verificacoes ========== */
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}
	
}
