//postar os exercicios ate o 17 no github até dia 17 de maio para valer pontos.
public class Livro {
	private String titulo, autor;
	private int numeroPaginas, anoEdicao;

	//==================================CONSTRUTORES===========================================
	public Livro (String t, String a, int p, int e)throws Exception{//construtor completo
		this.setLivro(t, a, p, e);
	}

	//===============================MÉTODOS=================================================
	public void setLivro (String t, String a, int p, int e) { //
		this.titulo=t;
		this.autor=a;
		this.numeroPaginas=p;
		this.anoEdicao=e;
	}

	public String getTitulo() {//definir os get... para printar
		return this.titulo;
	}
	public String getAutor() {
		return this.autor;
	}
	public int getNumeroPaginas() {
		return this.numeroPaginas;
	}
	public int getAnoEdicao() {
		return this.anoEdicao;
	}
	//====================================PRINTAR================================================
	public String toString() {
		StringBuilder Livro = new StringBuilder();
		
		Livro.append(this.getTitulo());
		Livro.append("\n   ");
		Livro.append(this.getAutor());
		Livro.append("\n p -" );
		Livro.append(this.getNumeroPaginas());
		Livro.append("\n D - ");
		Livro.append(this.getAnoEdicao());
		
		return Livro.toString();
	}
	
}
