package KaioAlanLittike;

public class Meta extends ItemAgenda {
	private int prioridade;
	
	//==================================CONSTRUTOR===========================================
	/**
	 * contrutor completo
	 * @param periodo tempo de dura��o do evento
	 * @param titulo titulo do evento
	 * @param descricao descri��o do evento
	 * @param m prioridade
	 * @throws Exception tratamento de erro na classe uso. retorno "Meta invalida" caso erro
	 */
	public Meta ( Periodo periodo, String titulo, String descricao, int m )throws Exception{//construtor completo
		super (periodo, titulo, descricao);
		this.setMeta (m);
	}

	//===============================M�TODOS=================================================
	/**
	 * set principal
	 * @param m meta, prioridade
	 * @throws Exception tratamento de erro na classe uso. retorno "Meta invalida" caso erro
	 */
	public void setMeta (int m) throws Exception { //
		if(Meta.isMetaValida (m)) {
			this.prioridade = m;
		}
		else
			throw new Exception ("Meta invalida");
	}
	/**
	 * get para printar
	 * @return prioridade
	 */
	public int getPrioridade() {//definir os get... para printar
		return this.prioridade; 	
	}

	//================================VERIFICA��O DE VALIDADE=====================================
	/**
	 * verifica se a meta � valida
	 * @param m meta
	 * @return true se valida, false se invalida
	 */
	public static boolean isMetaValida (int m) {//verifica a validade da meta
		if(m>-1) //n�o aceita metas negativas
			return true;
		else
			return false;
	}

	//====================================PRINTAR================================================
	/**
	 * printa a meta
	 */
	@Override
	public String toString(){//para printar system.out.println
		StringBuilder meta = new StringBuilder();

		meta.append("\n Meta \n ");
		meta.append(this.getPrioridade());

		return meta.toString();
	}  

	//=========================================compara��o=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Meta m) {
		if (prioridade == m.prioridade)
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro � maior, -1 se o primeiro menor, 0 se iguais
	 * @param m meta passada
	 * @return retorna 1 se o primeiro � maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (Meta m) { //retorna se s�o iguais, maior ou menor
		if (prioridade > m.prioridade)
			return 1;
		else if (prioridade < m.prioridade)
			return -1;
		else
			return 0;
	}
}
