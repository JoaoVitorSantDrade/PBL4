/***************************
Autores: João Vítor Santos de Andrade e Felipe Silva Queiroz
Componente Curricular: MI-Programação
Concluido em: 23/09/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************/
package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Controlador.Sistema;

/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class SistemaTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testAddPontoStringInt() {
		Sistema.AddPonto("Cachorro Alpha", 1);
		assertEquals("Cachorro Alpha",Sistema.getGrafo().getListaDePontos().BuscaPonto("Cachorro Alpha").getNome());
		Sistema.AddPonto("Cachorro Beta", 0);
		assertEquals("Cachorro Beta",Sistema.getEstacionamento().getNome());
		Sistema.AddPonto("Cachorro Teta", 2);
		assertEquals("Cachorro Teta",Sistema.getColeta().getNome());
		Sistema.AddPonto("Cachorro Omega", 3);
		assertEquals("Cachorro Omega",Sistema.getBanco().getNome());
	}

	@Test
	public void testDelPontoString() {
		Sistema.AddPonto("Cachorro Alpha", 1);
		assertEquals("Cachorro Alpha",Sistema.getGrafo().getListaDePontos().BuscaPonto("Cachorro Alpha").getNome());
		Sistema.AddPonto("Cachorro Beta", 0);
		assertEquals("Cachorro Beta",Sistema.getEstacionamento().getNome());
		Sistema.AddPonto("Cachorro Teta", 2);
		assertEquals("Cachorro Teta",Sistema.getColeta().getNome());
		Sistema.AddPonto("Cachorro Omega", 3);
		assertEquals("Cachorro Omega",Sistema.getBanco().getNome());
		
		
		Sistema.DelPonto("Cachorro Omega");
		assertNull(Sistema.getBanco());
		
		Sistema.AddPonto("Cachorro Omega", 3);
		assertEquals("Cachorro Omega",Sistema.getBanco().getNome());
	}
	
	@Test
	public void testSalvarTxt() {
		
		try {
			Sistema.SalvarTxt(); // olhar o TxT
		} catch (IOException e) {
			fail("Nao deve vir parar aqui");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLerTxT() {
		
			Sistema.DelPonto(Sistema.getColeta());
			Sistema.DelPonto(Sistema.getEstacionamento());
		try {
			Sistema.LerTxT();
		} catch (Exception e) {
			fail("Nao deve vir parar aqui");
			e.printStackTrace();
		}
		assertEquals("Cachorro Beta",Sistema.getEstacionamento().getNome());
		assertEquals("Cachorro Teta",Sistema.getColeta().getNome());
		assertEquals("Cachorro Omega",Sistema.getBanco().getNome());
	}

	

}
