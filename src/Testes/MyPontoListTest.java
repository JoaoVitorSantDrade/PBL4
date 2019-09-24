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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import Classes.Ponto;
import Estruturas.MyPontoList;
/**
 * @author Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
 */
public class MyPontoListTest {

	Ponto A = new Ponto("A");
	Ponto B = new Ponto("B");
	Ponto C = new Ponto("C");
	MyPontoList lista = new MyPontoList();
	
	@Before
	public void setUp() throws Exception {
		lista.add(A);
		lista.add(B);
		lista.add(C);
	}

	@Test
	public void testHavePonto() {
		Ponto D = new Ponto("D");
		assertTrue(lista.HavePonto(B));
		assertFalse(lista.HavePonto(D));
	}

	@Test
	public void testBuscaPontoPonto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testBuscaPosPonto() {
		Ponto D = new Ponto("D");
		assertEquals(0,lista.BuscaPosPonto(A));
		assertEquals(2,lista.BuscaPosPonto(C));
		assertEquals(1,lista.BuscaPosPonto(B));
		assertEquals(9999,lista.BuscaPosPonto(D)); // enquanto nao tem exception
	}

	@Test
	public void testBuscaPontoString() {
		assertNotEquals(A,lista.BuscaPonto("B"));
		assertEquals(A,lista.BuscaPonto("A"));
	}

	@Test
	public void testBuscaTipoPonto() {
		A.setTipo(2);
		B.setTipo(2);
		C.setTipo(1);
		
		try {
			assertEquals(C,lista.BuscaTipoPonto(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(A,lista.BuscaTipoPonto(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemovePonto() {
		assertEquals(A,lista.get(0));
		lista.remove(A);
		assertNotEquals(A,lista.get(0));
		assertEquals(B,lista.get(0));
	}

}
