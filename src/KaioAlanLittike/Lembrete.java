package KaioAlanLittike;

public class Lembrete extends ItemAgenda {
	private int lembrete; // qtde de minutos para dar um alerta de anteced�ncia do in�cio do per�odo dessa atividade

	//==================================CONSTRUTOR===========================================
	/**
	 * construtor principal completo
	 * @param periodo tempo de dura��o do evento
	 * @param titulo titulo do evento
	 * @param descricao descric�o do evento
	 * @param l local do evento
	 * @throws Exception tratamento de erro na classe uso. retorno "Lembrete invalido" caso erro
	 */
	public Lembrete ( Periodo periodo, String titulo, String descricao, int l )throws Exception{//construtor completo
		super (periodo, titulo, descricao);
		this.setLembrete (l);
	}

	//===============================M�TODOS=================================================
	/**
	 * set principal
	 * @param l local do evento
	 * @throws Exception tratamento de erro na classe uso. retorno "Lembrete invalido" caso erro
	 */
	public void setLembrete (int l) throws Exception { //
		if(Lembrete.isLembreteValido (l)) {
			this.lembrete = l;
		}
		else
			throw new Exception ("lembrete invalido");
	}
	/**
	 * get para println
	 * @return lembrete
	 */
	public int getLembrete() {//definir os get... para printar
		return this.lembrete; 	
	}

	//================================VERIFICA��O DE VALIDADE=====================================
	/**
	 * verifica a validade do lembrete
	 * @param l tempo para lembrete 
	 * @return true se positivo ou 0, false se negativo
	 */
	public static boolean isLembreteValido ( int l) {//verifica a validade do lembrete
		if(l>-1) //n�o aceita lembretes negativos
			return true;
		else
			return false;
	}

	//====================================PRINTAR================================================
	/**
	 * printa o tempo do lembrete
	 */
	@Override
	public String toString(){//para printar system.out.println
		StringBuilder lembrete = new StringBuilder();

		lembrete.append("\n Lembrete \n ");
		lembrete.append(this.getLembrete());
		lembrete.append(" min. antes ");

		return lembrete.toString();
	}  

	//=========================================compara��o=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Lembrete l) {
		if (lembrete == l.lembrete)
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro � maior, -1 se o primeiro menor, 0 se iguais
	 * @param l lembrete passado
	 * @return retorna 1 se o primeiro � maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (Lembrete l) { //retorna se s�o iguais, maior ou menor
		if (lembrete > l.lembrete)
			return 1;
		else if (lembrete < l.lembrete)
			return -1;
		else
			return 0;
	}
}
