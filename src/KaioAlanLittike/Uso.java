package KaioAlanLittike;

public class Uso {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		try {
			Data w = new Data (1,2,2019);
			System.out.println(w);
			Data x = new Data (1,"fevereiro",19);
			System.out.println(x);
			Data y = new Data (2,2,2019);
			System.out.println(y);
			Data z = new Data ("31/12/2019");
			System.out.println(z);

			if (x.equals(y))
				System.out.println("datas iguais");


			Data a;
			a = new Data(31,1,2019);
			System.out.println(a);
		}
		catch(Exception e) { // cria-se um argumento onde o tipo é o nome da classe que gerou o objeto de erro
			System.out.println("data invalida");

		}
	}
}

