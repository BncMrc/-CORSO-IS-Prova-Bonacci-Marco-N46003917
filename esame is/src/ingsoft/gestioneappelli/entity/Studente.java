package ingsoft.gestioneappelli.entity;

public class Studente {

	private String Nome;
	private String Cognome;
	private String Matricola;
	
	
	public Studente(String nome, String cognome,String matricola) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.Matricola=matricola;
	}

	
	public String GetNome()
	{
		return this.Nome;
	}
	
	public String GetCognome()
	{
		return this.Cognome;
	}
	
	public String GetMatricola()
	{
		return this.Matricola;
	}
	
	
public String toString() {
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("Nome=" + this.Nome + "\n");
		buf.append("Cognome " + this.Cognome + "\n");
		buf.append("Matricola " + this.Matricola + "\n");

		return buf.toString();
	}
	
	
}
	
	
	

