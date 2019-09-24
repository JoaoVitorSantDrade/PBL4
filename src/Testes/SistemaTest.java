/***************************
Autores: Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
Componente Curricular: MI-Programa��o
Concluido em: 23/09/2019
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
 * @author Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
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
