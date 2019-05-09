
public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
	private boolean statusEmprestimo;
	private String localizacao;
	private String descricao;

	//==================================CONSTRUTORES===========================================
	public LivroDeBiblioteca (String t, String a, int p, int e, boolean s, String l, String d)throws Exception{//construtor completo
		super (t,a,p,e);
		this.setLivroDeBiblioteca(s, l, d);
	}

	//===============================MÉTODOS=================================================
	public void setLivroDeBiblioteca (boolean s, String l, String d) { //
		this.statusEmprestimo=s;
		this.localizacao=l;
		this.descricao=d;
	}

	public boolean getStatusEmprestimo() {
		return this.statusEmprestimo;
	}

	public String getLocalizacao() {//definir os get... para printar
		return this.localizacao;
	}
	public String getDescricao() {
		return this.descricao;
	}
	//====================================PRINTAR================================================
	public String toString() {
		StringBuilder livroDeBiblioteca = new StringBuilder();

		livroDeBiblioteca.append(this.getStatusEmprestimo());
		livroDeBiblioteca.append("\n   ");
		livroDeBiblioteca.append(this.getLocalizacao());
		livroDeBiblioteca.append("\n " );
		livroDeBiblioteca.append(this.getDescricao());
		livroDeBiblioteca.append("\n ");
		livroDeBiblioteca.append(super.toString());

		return livroDeBiblioteca.toString();
	}

	//====================================================================================
	public boolean isEmprestado() {
		return statusEmprestimo;
	}
	public void empresta() {
		statusEmprestimo=true;
	}
	public void devolve() {
		statusEmprestimo=false;
	}
	public String localiza() {
		return localizacao;
	}
	public String apresentaDescricao() {
		return descricao;
	}
}
