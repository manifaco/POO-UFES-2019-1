package KaioAlanLittike;

public class Evento extends ItemAgenda {
	private String local;

	//==================================CONSTRUTOR===========================================
	/**
	 * contrutor completo
	 * @param periodo tempo em que o item de agenda vai ocorrer
	 * @param titulo titulo do item
	 * @param descricao descri��o do item
	 * @param l local do item
	 * @throws Exception tratamento de erro na classe uso. retorno "Evento invalido" caso erro
	 */
	public Evento ( Periodo periodo, String titulo, String descricao, String l )throws Exception{//construtor completo
		super (periodo, titulo, descricao);
		this.setEvento (l);
	}

	//===============================M�TODOS=================================================
	/**
	 * set principal
	 * @param l local
	 * @throws Exception tratamento de erro na classe uso. retorno "Evento invalido" caso erro
	 */
	public void setEvento (String l) throws Exception { //
		if(Evento.isEventoValido (l)) {
			this.local = l;
		}
		else
			throw new Exception ("evento invalido");
	}
	/**
	 * get para println
	 * @return local
	 */
	public String getLocal() {//definir os get... para printar
		return this.local; 	
	}

	//================================VERIFICA��O DE VALIDADE=====================================
	/**
	 * verifica se o evento � valido
	 * @param l local
	 * @return true , pois por hora, o evento sempre ser� valido
	 */
	public static boolean isEventoValido ( String l) {//verifica a validade do evento
		return true;//no momento n�o vejo op��es em que o local esta errado, mas essa fun��o j� fica aqui a espera, para caso o cliente solicite casos em que esses paramentros n�o podem ser aceitos
	}

	//====================================PRINTAR================================================
	/**
	 * printar o local
	 */
	@Override
	public String toString(){//para printar system.out.println
		StringBuilder evento = new StringBuilder();

		evento.append("\n Local \n ");
		evento.append(this.getLocal());

		return evento.toString();
	}  

	//=========================================compara��o=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Object evento) {
		Evento aux = (Evento)evento;
		if (this.getLocal() == aux.getLocal().intern())
			return true;
		return false;
	} 
	//n�o faz sentido implementar o compareTo, pois o unico atributo que foi acescentado, foi o local, e n�o tem como definir se um local � maior ou menor que o outro. o compareTo da classe ItemAgenda ja faz a compara��o ideal
}
