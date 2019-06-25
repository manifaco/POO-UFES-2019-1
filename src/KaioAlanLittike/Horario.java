package KaioAlanLittike;

public class Horario {
	private int hora, minuto;

	//==================================CONSTRUTORES===========================================
	/**
	 * construtor compleot
	 * @param h hora
	 * @param m minuto
	 * @throws Exception tratamento de erro na classe uso. retorno "Horario invalido" caso erro
	 */
	public Horario (int h, int m)throws Exception{//construtor em numeros
		this.setHorario(h, m);
	}
	/**
	 * construtor caso não receba minuto
	 * @param h hora
	 * @throws Exception tratamento de erro na classe uso. retorno "Horario invalido" caso erro
	 */
	public Horario (int h)throws Exception{//construtor caso não receba minuto 
		this.setHorario(h, 0);
	}
	/**
	 * construtor caso receba horario em string separando hora e minuto por :
	 * @param dStr data em string
	 * @throws Exception tratamento de erro na classe uso. retorno "Horario invalido" caso erro
	 */
	public Horario (String dStr)throws Exception{//construtor caso receba horario em string separando hora e minuto por :
		this.setHorario(dStr);
	}


	//===============================MÉTODOS=================================================
	/** 
	 * set principal
	 * @param h hora
	 * @param m minuto
	 * @throws Exception tratamento de erro na classe uso. retorno "Horario invalido" caso erro
	 */
	public void setHorario (int h, int m) throws Exception { //
		if((Horario.isHorarioValido (h, m))==true) {
			if(h==24)
				h=0;
			if(m==60)
				m=0;
			this.hora=h;
			this.minuto=m;
		}
		else
			throw new Exception ("horario invalido");
	}
	/**
	 * quando recebe string
	 * @param dStr data em string
	 * @throws Exception tratamento de erro na classe uso. retorno "Horario invalido" caso erro
	 */
	public void setHorario (String dStr)throws Exception{//quando recebe uma string 
		int p = dStr.indexOf (":");//encontra a / que separa as informações da data

		String subH=dStr.substring(0, p);//cria mini strings no intervalo determinado
		String subM=dStr.substring(p+1);

		int h=Integer.parseInt(subH);//converte as mini strings que foram criadas, em inteiros
		int m=Integer.parseInt(subM);

		this.setHorario (h, m);
	}
/**
 * get para printar
 * @return hora
 */
	public int getHora() {//definir os get... para printar
		return this.hora; 	
	}
	/**
	 * get para printar
	 * @return minuto
	 */
	public int getMinuto() {
		return this.minuto; 	
	}

	//================================VERIFICAÇÃO DE VALIDADE=====================================
	/**
	 * verifica se a hora é valida
	 * @param h hora
	 * @param m minuto
	 * @return true se valida, false se invalida
	 */
	public static boolean isHorarioValido (int h, int m) {//verifica a validade do horario
		if((h>24)||(h<0)||(m>60)||(m<0)) {//horario inexcrupuloso
			return false;
		}
		return true;
	}

	//====================================PRINTAR================================================
	/**
	 * 
	 * printa o horario
	 */
	public String toString(){//para printar system.out.println
		StringBuilder horario = new StringBuilder();

		horario.append(this.getHora());
		horario.append(":");
		horario.append(this.getMinuto());
		horario.append(" hs");

		return horario.toString();
	}  
	//=========================================comparação=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Object horario) {
		Horario aux = (Horario)horario;
		if (this.getHora() == aux.getHora() && this.getMinuto() == aux.getMinuto())
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 * @param h horario passado
	 * @return retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (Horario h) { //retorna se são iguais, maior ou menor
		if(hora == h.hora) {
			if (minuto == h.minuto) {
				return 0; //são iguais
			}
			else if (minuto > h.minuto)
				return 1; //hora igual - integer maior que o argumento
			else
				return -1; //hora igual - integer menor que o argumento

		}
		else if (hora > h.hora)
			return 1; //hora diferente - integer maior que o argumento
		else
			return -1; //hora diferente - integer menor que o argumento		
	}


}
