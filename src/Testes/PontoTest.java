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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Classes.Ponto;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class PontoTest {

	Ponto aux;
	
	@Before
	public void setUp() throws Exception {
		aux = new Ponto("A");
	}


	@Test
	public void testNome() {
		
		assertEquals("A",aux.getNome());
		aux.setNome("Ponto B");
		assertEquals("Ponto B",aux.getNome());
	}
	
	@Test
	public void testTipo() {
		assertEquals(1,aux.getTipo());
		aux.setTipo(2);
		assertEquals(2,aux.getTipo());
	}


	@Test
	public void testPos() {
		assertEquals(0,aux.getPosX(),.0001);
		assertEquals(0,aux.getPosY(),.0001);
		aux.setPosX(10);
		aux.setPosY(15);
		assertEquals(10,aux.getPosX(),.0001);
		assertEquals(15,aux.getPosY(),.0001);
	}


	@Test
	public void testGetAdjacente() {
		assertEquals(0,aux.getAdjacente().size());
		
		Ponto a = new Ponto("teste A");
		Ponto b = new Ponto("teste B");
		
		aux.getAdjacente().add(a);
		aux.getAdjacente().add(b);
		
		assertEquals(2,aux.getAdjacente().size());
		assertEquals(a,aux.getAdjacente().get(0));
		assertEquals(b,aux.getAdjacente().get(1));
	}

	@Test
	public void testDistanciaAdjacente() {
		assertEquals(0,aux.getDistanciaAdjacente().size());
		
		aux.getDistanciaAdjacente().add(15);
		aux.getDistanciaAdjacente().add(35);
		
		assertEquals(2,aux.getDistanciaAdjacente().size());
		assertEquals(15,aux.getDistanciaAdjacente().get(0),0.001);
		assertEquals(35,aux.getDistanciaAdjacente().get(1),0.001);
	}

	@Test
	public void testAnterior() {
		assertEquals(null,aux.getAnterior());
		
		Ponto a = new Ponto("teste A");
		Ponto b = new Ponto("teste B");
		
		aux.setAnterior(b);
		
		assertNotEquals(a,aux.getAnterior());
		assertEquals(b,aux.getAnterior());
	}

	@Test
	public void testMinDistance() {
		assertEquals(Double.POSITIVE_INFINITY,aux.getMinDistance(),0.0001);
		aux.setMinDistance(5);
		assertEquals(5,aux.getMinDistance(),0.0001);
	}

	
	@Test
	public void testIsVisited() {
		assertFalse(aux.isVisited());
		aux.setVisited(true);
		assertTrue(aux.isVisited());
	}

	@Test
	public void testCompareNome() {
		
		Ponto a = new Ponto("teste A");
		Ponto b = new Ponto("A");
		
		assertFalse(aux.compareNome(a.getNome()));
		assertTrue(aux.compareNome(b.getNome()));
	}

}
