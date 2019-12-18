package ingsoft.gestioneappelli.entity;
import java.util.ArrayList;


public class Appello {
private ArrayList<Prova> Elenco_prove= new ArrayList<Prova>();
private ArrayList<Studente> Elenco_Studenti= new ArrayList<Studente>();

private int IdAppello;
private Corso corso;

public Appello(Prova[] prove,int idappello,Corso corso)
{
	this.corso=corso;
	this.IdAppello=idappello;
	for(int i =0; i<prove.length; i++) {
	this.Elenco_prove.add( prove[i]);
	}
}

public Appello(int idappello,Corso corso)
{
	this.IdAppello=idappello;
	this.corso=corso;
}

public void SetProva(Prova p)
	{
	this.Elenco_prove.add(p);
	};
	

	public void Aggiungi_Studente(Studente stud) {
		Elenco_Studenti.add(stud);
	}
	
	
	public ArrayList<Studente>  Get_Studenti() {
		return Elenco_Studenti;
}
	
	public Corso GetCorso() {
		return corso;
	}
	
public String toString() {
		
		StringBuffer buf = new StringBuffer();
		buf.append("Id Appello = " + this.IdAppello);
		buf.append("\nDocente:"+corso.GetDocente());
		buf.append("\nInsegnamento:"+corso.Get_insegnamento());
		buf.append("\n Elenco Prove: \n");
		
		for ( Prova c : this.Elenco_prove ) {
			buf.append(c);
		}
		for( Studente s : this.Elenco_Studenti) {
		buf.append(s);
		}
		return buf.toString();
	}
 	
	
}
