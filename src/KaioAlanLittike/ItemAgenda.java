package KaioAlanLittike;

public abstract class ItemAgenda {
	private Periodo periodo;
	private String titulo, descricao;

	//==================================CONSTRUTOR===========================================
	public ItemAgenda (Periodo p, String t, String d)throws Exception{//construtor completo
		this.setItemAgenda(p, t, d);
	}

	//===============================MÉTODOS=================================================
	public void setItemAgenda (Periodo p, String t, String d) throws Exception { //
		if((ItemAgenda.isItemAgendaValido (p, t, d))==true) {
			this.periodo = p;
			this.titulo = t;
			this.descricao = d;
		}
		else
			throw new Exception ("item de agenda invalido");
	}

	public Periodo getPeriodo() {//definir os get... para printar
		return this.periodo; 	
	}
	public String getTitulo() {
		return this.titulo; 	
	}
	public String getDescricao() {
		return this.descricao;
	}

	//================================VERIFICAÇÃO DE VALIDADE=====================================
	public static boolean isItemAgendaValido (Periodo p, String t, String d) {//verifica a validade do item agenda
		return true;//no momento não vejo opções em que o titulo ou a descrição estejam errados, mas essa função já fica aqui a espera, para caso o cliente solicite casos em que esses paramentros não podem ser aceitos
	}

	//====================================PRINTAR================================================
	public String toString(){//para printar system.out.println
		StringBuilder itemAgenda = new StringBuilder();

		itemAgenda.append("\n Titulo \n ");
		itemAgenda.append(this.getTitulo().toString());
		itemAgenda.append("\n Descricao \n ");
		itemAgenda.append(this.getDescricao().toString());
		itemAgenda.append("\n periodo \n ");
		itemAgenda.append(this.getPeriodo().toString());

		return itemAgenda.toString();
	}  
	//=========================================comparação=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Object itemAgenda) {
		ItemAgenda aux = (ItemAgenda)itemAgenda;
		if ((periodo.compareTo(aux.periodo)==1) && (this.getTitulo() == aux.getTitulo().intern()) && (this.getDescricao()==aux.getDescricao().intern()))
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 * @param i item passaod passado
	 * @return retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (ItemAgenda i) { //reaproveita o compareTo do periodo, pois não faz sentido compareTo em string
		return periodo.compareTo(i.periodo);
	}
}
