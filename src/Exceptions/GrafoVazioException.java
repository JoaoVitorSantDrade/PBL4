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

package Exceptions;
/**
 * Excecao para caso o Grafo esteja vazio
 * @author Felipe Silva Queiroz e João Vítor Santos de Andrade
 */
public class GrafoVazioException extends Exception {

	
	public GrafoVazioException() {
		
	}
	@Override
	public String getMessage()
	{
		return "Nao existe pontos no Grafo!";
	}
}
