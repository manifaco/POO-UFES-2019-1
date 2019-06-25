package KaioAlanLittike;

public class Periodo {
	private Data dataIni, dataFim;
	private Horario horarioIni, horarioFim;
	private Data hoje = new Data (25, 6, 2019);//usado para caso não seja adicionado data de inicio
	private Horario agora = new Horario (8, 30);//usado para caso não seja adicionado horario de inicio

	//==================================CONSTRUTORES===========================================
	/**
	 * construtor principal
	 * @param dIni data de inicio
	 * @param dFim data de fim
	 * @param hIni hora de inicio
	 * @param hFim hora de fim
	 * @throws Exception retorna Periodo invalido , caso erro
	 */
	public Periodo (Data dIni, Data dFim, Horario hIni, Horario hFim )throws Exception{//construtor completo
		this.setPeriodo(dIni, dFim, hIni, hFim);
	}
	/**
	 * construtor sem data de inicio
	 * @param dFim
	 * @param hIni
	 * @param hFim
	 * @throws Exception
	 */
	public Periodo (Data dFim, Horario hIni, Horario hFim)throws Exception{//construtor caso não receba data de inicio  
		this.setPeriodo(hoje, dFim, hIni, hFim);
	}
	/**
	 * construtor caso não receba Horario de inicio
	 * @param dIni
	 * @param dFim
	 * @param hFim
	 * @throws Exception
	 */
	public Periodo (Data dIni, Data dFim, Horario hFim)throws Exception{//construtor caso não receba Horario de inicio  
		this.setPeriodo(dIni, dFim, agora, hFim);
	}
	/**
	 * construtor caso não receba data nem horario de inicio
	 * @param dFim
	 * @param hFim
	 * @throws Exception
	 */
	public Periodo (Data dFim, Horario hFim)throws Exception{//construtor caso não receba data nem horario de inicio  
		this.setPeriodo(hoje, dFim, agora, hFim);
	}

	//===============================MÉTODOS=================================================
	/**
	 * set principal
	 * @param dIni
	 * @param dFim
	 * @param hIni
	 * @param hFim
	 * @throws Exception
	 */
	public void setPeriodo (Data dIni, Data dFim, Horario hIni, Horario hFim) throws Exception { // set principal
		if((Periodo.isPeriodoValido (dIni, dFim, hIni, hFim))==true) {
			this.dataIni=dIni;
			this.dataFim=dFim;
			this.horarioIni=hIni;
			this.horarioFim=hFim;
		}
		else
			throw new Exception ("periodo invalido");
	}
/**
 * get para printar
 * @return
 */
	public Data getDataIni() {//definir os get... para printar
		return this.dataIni; 	
	}
	/**
	 * get para printar
	 * @return
	 */
	public Data getDataFim() {
		return this.dataFim; 	
	}
	/**
	 * get para printar
	 * @return
	 */
	public Horario getHorarioIni() {
		return this.horarioIni;
	}
	/**
	 * get para printar
	 * @return
	 */
	public Horario getHorarioFim() {
		return this.horarioFim;
	}

	//================================VERIFICAÇÃO DE VALIDADE=====================================
	/**
	 * verifica a validade
	 * @param dIni
	 * @param dFim
	 * @param hIni
	 * @param hFim
	 * @return
	 */
	public static boolean isPeriodoValido (Data dIni, Data dFim, Horario hIni, Horario hFim) {//verifica a validade do periodo
		if(dIni.compareTo(dFim)==1) {//data inicial após a data final
			return false;
		}
		else if (dIni.compareTo(dFim)==0) {//datas inicial e final iguais
			if(hIni.compareTo(hFim)==1)//data igual - hora inicial após a hora final
				return false;
			else // data igual - hora inicial igual ou inferior a hora final 
				return true;
		}
		else
			return true;
	}

	//====================================PRINTAR================================================
	/**
	 * printa os dados
	 */
	public String toString(){//para printar system.out.println
		StringBuilder periodo = new StringBuilder();

		periodo.append("inicio \n");
		periodo.append(this.getDataIni().toString());
		periodo.append(" - ");
		periodo.append(this.getHorarioIni().toString());
		periodo.append("\n final");
		periodo.append(this.getDataFim().toString());
		periodo.append(" - ");
		periodo.append(this.getHorarioFim().toString());

		return periodo.toString();
	}  
	//=========================================comparação=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Periodo p) {
		double tam1, tam2;
		//calcular quantos segundos de duração tem cada periodo
		tam1=(dataFim.getAno() - dataIni.getAno())*525600 + ((dataFim.getMes() - dataIni.getMes()) * 43800) + ((dataFim.getDia() - dataIni.getDia()) * 1440) + ((horarioFim.getHora() - horarioIni.getHora()) * 60) + (horarioFim.getMinuto() - horarioIni.getMinuto()) ;
		tam2=(p.dataFim.getAno() - p.dataIni.getAno())*525600 + ((p.dataFim.getMes() - p.dataIni.getMes()) * 43800) + ((p.dataFim.getDia() - p.dataIni.getDia()) * 1440) + ((p.horarioFim.getHora() - p.horarioIni.getHora()) * 60) + (p.horarioFim.getMinuto() - p.horarioIni.getMinuto()) ;
		
		if (tam1 == tam2)
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 * @param p periodo passado
	 * @return retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (Periodo p) { //retorna se são iguais, maior ou menor
		double tam1, tam2;
		//calcular quantos segundos de duração tem cada periodo
		tam1=(dataFim.getAno() - dataIni.getAno())*525600 + ((dataFim.getMes() - dataIni.getMes()) * 43800) + ((dataFim.getDia() - dataIni.getDia()) * 1440) + ((horarioFim.getHora() - horarioIni.getHora()) * 60) + (horarioFim.getMinuto() - horarioIni.getMinuto()) ;
		tam2=(p.dataFim.getAno() - p.dataIni.getAno())*525600 + ((p.dataFim.getMes() - p.dataIni.getMes()) * 43800) + ((p.dataFim.getDia() - p.dataIni.getDia()) * 1440) + ((p.horarioFim.getHora() - p.horarioIni.getHora()) * 60) + (p.horarioFim.getMinuto() - p.horarioIni.getMinuto()) ;
		if (tam1>tam2)
			return 1;
		else if (tam1<tam2)
			return -1;
		else
			return 0;
	}
}
