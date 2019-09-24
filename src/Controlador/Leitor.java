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
package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Classes.Ponto;
import Estruturas.MyPontoList;


/**Clase para leitura de arquivos de Pontos e Arestas.
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class Leitor {

    private static BufferedReader br;
    private static MyPontoList ListaPonto = new MyPontoList();
	

    private static void LerTXTPontos() throws Exception {
        //abre o arquivo para leitura com um buffer auxiliar
        br = new BufferedReader(new FileReader("Pontos.txt"));
        while(br.ready()) {//loop ate o fim do arquivo
            String LinhaLida = br.readLine();//le a linha do arquivo
            String LinhaSeparada[] = LinhaLida.split(",");//divide as informacoes lidas
            if(LinhaSeparada.length < 4)
            {
               // throw new EstruturaVaziaException();
            }
            int TipoAux = Integer.parseInt(LinhaSeparada[1]);
            double PosXAux = Double.parseDouble(LinhaSeparada[2]);
            double PosYAux = Double.parseDouble(LinhaSeparada[3]);
            Ponto pontoAux = new Ponto(LinhaSeparada[0],TipoAux,PosXAux,PosYAux);
            ListaPonto.add(pontoAux);//adiciona na lista
        }
        br.close();//fecha o arquivo
    }
	
    private static void LerTXTAresta() throws IOException, Exception {
        //abre o arquivo para leitura com um buffer auxiliar
        br = new BufferedReader(new FileReader("Arestas.txt"));
        while(br.ready()) {//loop ate fim do arquivo
            String LinhaLida = br.readLine();//le a linha do arquivo
            String LinhaSeparada[] = LinhaLida.split(",");//divide as informacoes lidas
            if(LinhaSeparada.length < 3)
            {
               break;//  throw new EstruturaVaziaException();
            }
            
            int Peso = Integer.parseInt(LinhaSeparada[2]);
            AddLigacao(LinhaSeparada[0],LinhaSeparada[1],Peso); 
            
            }
        br.close();//fecha o arquivo
    }
	
    /**Metodo para fazer as leituras dos arquivos de Pontos,
     * adicionando em suas respectivas estruturas.
     * @throws Exception
     */
    public static void LerTXT() throws Exception  {
			LerTXTPontos();
			LerTXTAresta();
    }
	
    /**
     * Retorna uma lista de Pontos
     * @return A lista de Pontos que o Leitor Possui
     */
    public static MyPontoList getListPonto()
    {
    	return Leitor.ListaPonto;
    }
	
    private static void AddLigacao(String Nome1,String Nome2,int Peso) { // o mesmo do Grafo
		Ponto Aux1 = ListaPonto.BuscaPonto(Nome1);
		Ponto Aux2 = ListaPonto.BuscaPonto(Nome2);
		
		if(!Aux1.getAdjacente().contains(Aux2)) {
			
			Aux1.getAdjacente().add(Aux2);
			Aux1.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux1.getAdjacente().indexOf(Aux2);
			Aux1.getDistanciaAdjacente().set(pos, Peso);
		}
		
		if(!Aux2.getAdjacente().contains(Aux1)) {
			
			Aux2.getAdjacente().add(Aux1);
			Aux2.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux2.getAdjacente().indexOf(Aux1);
			Aux2.getDistanciaAdjacente().set(pos, Peso);
		}
		
	}
}