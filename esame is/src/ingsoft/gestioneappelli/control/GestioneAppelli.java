package ingsoft.gestioneappelli.control;
import java.util.ArrayList;
import ingsoft.gestioneappelli.entity.Appello;
import ingsoft.gestioneappelli.entity.Docenti;
import ingsoft.gestioneappelli.entity.Insegnamenti;
import ingsoft.gestioneappelli.entity.Corso;
import ingsoft.gestioneappelli.entity.Prova;
import ingsoft.gestioneappelli.entity.Studente;
public class GestioneAppelli {
	
	public ArrayList<Appello> Elenco_Appelli= new ArrayList<Appello>();
	public ArrayList<Corso> Elenco_Corsi= new ArrayList<Corso>();
	int contIdAppello=0;
	int contIdCorso=0;

	public Corso CreaCorso(Docenti nomedocente,Insegnamenti  Nomecorso,int cfu) {
		Corso c= new Corso(contIdCorso,nomedocente,Nomecorso,cfu);
		Elenco_Corsi.add(c);
		contIdCorso++;
		return c;
		
	}
	
public Appello GetAppello(Corso corso)
{
	for (Appello a:Elenco_Appelli)
	{
		{
			if(  a.GetCorso()==corso)  
			{
				return a;
			}
		}
	}
	return null;
	}

	
public Corso GetCorso(Docenti docente,Insegnamenti  corso)
{
	for (Corso a:Elenco_Corsi)
	{
		{
			if(  a.Get_insegnamento() == corso && a.GetDocente()== docente )  
			{
				return a;
			}
		}
	}
	return null;
	}



private int Controlla_Se_Appello_Presente(Docenti docente,Insegnamenti  insegnamento)
{
	
	for (Appello a:Elenco_Appelli)
	{
		{
			if(  a.GetCorso().Get_insegnamento() == insegnamento && a.GetCorso().GetDocente()== docente )  
			{
				return  a.GetCorso().GetIdCorso();
			}
		}
	}
	
	return -1;

}

public Appello Crea_Appello(Prova[] prove,Corso corso ) {
	
	if (Controlla_Se_Appello_Presente(corso.GetDocente(),corso.Get_insegnamento())==-1)

		{
			for (Corso c :Elenco_Corsi)
			{
				if (c==corso)
				{
				Appello a=new Appello(prove,contIdAppello,c);
				Elenco_Appelli.add(a);
				contIdAppello++;
				return a;
				}
			}
		}
	return null;
}


	
	public void Prenota_Appello(Studente stud, Appello appello)
	{
		for(Appello a : Elenco_Appelli)
		{
			if(a==appello)
			{
				a.Aggiungi_Studente(stud);
			}
		}
	}
	
	
	public int Visualizza_Prenotati(Appello appello)
	{
		//System.out.println(a);
		for(Appello a : Elenco_Appelli)
		{
		
			if(a==appello)
			{
				System.out.println(a.Get_Studenti());
				return a.Get_Studenti().size();
			}
		}
			return 0;
	}
	
	public int Visualizza_PrenotatiT(Appello appello)
	{
		//System.out.println(a);
		for(Appello a : Elenco_Appelli)
		{
		
			if(a==appello)
			{
				return a.Get_Studenti().size();
			}
		}
			return 0;
	}
}

