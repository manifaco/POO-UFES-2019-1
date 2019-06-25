package KaioAlanLittike;

//===============================INICIO DA CLASSE=============================================
public class Data {
	private int dia, mes, ano;

	//==================================CONSTRUTORES===========================================
	/**
	 * costrutor completo
	 * @param d 
	 * dia em inteiro
	 * @param m
	 * mes em inteiro
	 * @param a
	 * ano em inteiro
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public Data (int d, int m, int a)throws Exception{//construtor mes em numeros
		this.setData(d, m, a);
	}
	/**
	 * construtor caso o mes esteja em string
	 * @param d 
	 * dia em inteiro
	 * @param mStr
	 * mes em formato string
	 * @param a
	 * ano em inteiro
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public Data (int d, String mStr, int a)throws Exception{//construtor mes em string
		this.setData(d, mStr, a);
	}
	/**
	 * contrutor caso não reeba o dia. completa com o dia 1
	 * @param m 
	 * mes em inteiro
	 * @param a 
	 * ano em inteiro
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public Data (int m, int a)throws Exception{//construtor caso não receba dia 
		this.setData(1, m, a);
	}
	/**
	 * contrutor, caso a data seja passada em formato String
	 * @param dStr 
	 * data em formato String
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public Data (String dStr)throws Exception{//construtor caso receba uma data em string
		this.setData(dStr);
	}


	//===============================MÉTODOS=================================================
	/**
	 * set princiapal e que faz o tratamento caso o ano esteja em formano aa, transformando para aaaa
	 * @param d 
	 * dia em int
	 * @param m
	 * mes em int
	 * @param a
	 * ano em int
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public void setData (int d, int m, int a) throws Exception { //
		if((a>=0)&&(a<=99))//caso em que 01/01/19
			a=2000+a;
		if((Data.isDataValida (d, m, a))==true) {
			this.dia=d;
			this.mes=m;
			this.ano=a;
		}
		else
			throw new Exception ("data invalida");
	}
/**
 * set para tratar o mes escrito por esenso, formato String
 * @param d 
 * dia em int
 * @param mStr
 * mes em string
 * @param a
 * ano em int
 * @throws Exception
 * tratamento de erro na classe uso. retorno "data invalida" caso erro
 */
	public void setData (int d, String mStr, int a)throws Exception{ //set para substiuir o mes escrito por número
		if (mStr.equals ("janeiro"))
			this.setData(d, 1, a);
		if (mStr.equals ("fevereiro"))
			this.setData(d, 2, a);
		if (mStr.equals ("marco"))
			this.setData(d, 3, a);
		if (mStr.equals ("abril"))
			this.setData(d, 4, a);
		if (mStr.equals ("maio"))
			this.setData(d, 5, a);
		if (mStr.equals ("junho"))
			this.setData(d, 6, a);
		if (mStr.equals ("julho"))
			this.setData(d, 7, a);
		if (mStr.equals ("agosto"))
			this.setData(d, 8, a);
		if (mStr.equals ("setembro"))
			this.setData(d, 9, a);
		if (mStr.equals ("outubro"))
			this.setData(d, 10, a);
		if (mStr.equals ("novembro"))
			this.setData(d, 11, a);
		if (mStr.equals ("dezembro"))
			this.setData(d, 12, a);
	}
	/**
	 * set para transformar a string passada no costrutor, em numeros inteiros
	 * @param dStr 
	 * data em String
	 * @throws Exception
	 * tratamento de erro na classe uso. retorno "data invalida" caso erro
	 */
	public void setData (String dStr)throws Exception{//quando recebe uma string 
		int p = dStr.indexOf ("/");//encontra a / que separa as informações da data
		int q = dStr.indexOf ("/",p+1);

		String subD=dStr.substring(0, p);//cria mini strings no intervalo determinado
		String subM=dStr.substring(p+1, q);
		String subA=dStr.substring(q+1);

		int d=Integer.parseInt(subD);//converte as mini strings que foram criadas, em inteiros
		int m=Integer.parseInt(subM);
		int a=Integer.parseInt(subA);

		this.setData(d, m, a);
	}
	/**
	 * get para usar nos println e em alguns metodos
	 * @return
	 *  dia
	 */
	public int getDia() {//definir os get... para printar
		return this.dia; 	
	}
	/**
	 * get para usar nos println e em alguns metodos
	 * @return
	 * mes
	 */
	public int getMes() {
		return this.mes; 	
	}
	/**
	 * get para usar nos println e em alguns metodos
	 * @return 
	 * ano
	 */
	public int getAno() {
		return this.ano; 	
	}

	//================================VERIFICAÇÃO DE VALIDADE=====================================
	/**
	 * verifica a validade da dat
	 * @param d dia em string
	 * @param m mes em string
	 * @param a ano em string
	 * @return true se valida, false se invalida
	 */
	public static boolean isDataValida (int d, int m, int a) {//verifica a validade da data

		if((d>31)||(d<1)||(m>12)||(m<1)||(a>3000)||(a<1900)) {//data inexcrupulosa
			return false;
		}
		if(((a%4==0)&&(a%100!=0))||(a%400==0)) { //entra caso seja ano bissesto
			if((m==2)&&(d>29)) {
				return false;
			}
		}

		else if ((m==2)&&(d>28)) { //entra caso não seja ano bissesto
			return false;
		}
		if((m!=1)&&(m!=3)&&(m!=5)&&(m!=7)&&(m!=8)&&(m!=10)&&(m!=12)) {//entra se o mes não tiver 31 dias
			if(d>30) {
				return false;
			}
		}
		return true;
	}

	//====================================PRINTAR================================================
	/**
	 * metodo necessario para printar as informações da classe
	 */
	public String toString(){//para printar system.out.println
		StringBuilder data = new StringBuilder();

		data.append(this.getDia());
		data.append("/");
		data.append(this.getMes());
		data.append("/");
		data.append(this.getAno());

		return data.toString();
	}  
	//=========================================comparação=========================================
	/**
	 * compara dois valores e retorna tru se igual, false se diferente
	 */
	public boolean equals(Object data) {
		Data aux = (Data)data;
		if (this.getDia() == aux.getDia() && this.getMes() == aux.getMes() && this.getAno() == aux.getAno())
			return true;
		return false;
	} 
	/**
	 * compara 2 valores, retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 * @param d data passada
	 * @return retorna 1 se o primeiro é maior, -1 se o primeiro menor, 0 se iguais
	 */
	public int compareTo (Data d) { //retorna se são iguais, maior ou menor
		if(ano == d.ano) {
			if (mes == d.mes) {
				if (dia == d.dia) {
					return 0; //são iguais
				}
				else if (dia> d.dia)
					return 1; //ano e mes iguais - integer maior que o argumento
				else
					return -1; //ano e mes iguais - integer menor que o argumento

			}
			else if (mes > d.mes)
				return 1; //ano igual - integer maior que o argumento
			else
				return -1; //ano igual - integer menor que o argumento

		}
		else if (ano > d.ano)
			return 1; //ano diferente - integer maior que o argumento
		else
			return -1; //ano diferente - integer menor que o argumento		
	}

}


