/***************************
Autores: João Pedro Rios Carvalho e João Vítor Santos de Andrade
Componente Curricular: MI-Programação
Concluido em: 18/08/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************/

package Estruturas;


import java.util.Iterator;


public interface IList extends Iterable{

    /**
     * Retorna o tamanho da lista.
     * @return tamanho da lista.
     */
    public int size();

    /**
     * Insere objeto ao final da lista.
     * @param obj a ser inserido ao final da lista.
     */
    public void add(Object obj);
        
    /**
     * Insere um objeto em uma determinada posicao da lista, empurrando demais elementos para direita.
     * Posicao 0 refere-se a primeira posicao da lista e a Ultima posicao depende do tamanho da lista.
     * @param pos a posicao do objeto na lista, apos a insercao. Deve ser um 
     * valor entre 0 e o tamanho da lista.
     * @param obj a ser inserido na lista
     * @return true, caso o objeto tenha sido inserido e false caso contrario.
     */
    public boolean add(int pos, Object obj);


    /**
     * Remove um objeto de uma determinada posicao, deslocando demais elementos seguintes para esquerda.
     * @param pos a posicao do objeto a ser removido.
     * @return o objeto removido ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) e maior que o tamanho da lista.
     */
    public Object remove(int pos);

    /**
     * Retorna o objeto em uma determinada posicao da lista, sem remove-lo.
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     * @throws EstruturaVaziaException 
     */
    public Object get(int index); // throws EstruturaVaziaException;   
    
    /**
     * Indica se a lista esta vazia.
     * @return true caso a lista esteja vazia, false caso contrario
     */
    public boolean isEmpty();

    /**
     * Retorna um iterador para a lista.
     * @return objeto do tipo Iterator
     */
    public Iterator iterator();



}
