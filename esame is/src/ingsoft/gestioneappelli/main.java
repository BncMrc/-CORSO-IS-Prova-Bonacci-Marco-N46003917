package ingsoft.gestioneappelli;
import java.time.LocalDate;
import java.time.Month;
import ingsoft.gestioneappelli.control.*;
import ingsoft.gestioneappelli.entity.Insegnamenti;
import ingsoft.gestioneappelli.entity.Appello;
import ingsoft.gestioneappelli.entity.Corso;
import ingsoft.gestioneappelli.entity.Docenti;
import ingsoft.gestioneappelli.entity.Prova;
import ingsoft.gestioneappelli.entity.Studente;
import ingsoft.gestioneappelli.entity.Tipo_Prova;
public class main {
	

	public static void main( String[] args) {
	
		GestioneAppelli g =new GestioneAppelli();

		g.CreaCorso(Docenti.Roberto_Natella,Insegnamenti.Ingegneria_del_Software,9);
		g.CreaCorso(Docenti.Roberto_Pietrantuono,Insegnamenti.Sistemi_Operativi, 9);
		g.CreaCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale, 9);

		
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c1=g.GetCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale);
		Appello a1=g.Crea_Appello(prove_appello1, c1);

		
		Prova[] prove_appello2=new Prova[3];
		prove_appello2[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello2[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T4", Tipo_Prova.CALCOLATORE);
		prove_appello2[2]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c2=g.GetCorso(Docenti.Roberto_Natella,Insegnamenti.Ingegneria_del_Software);
		Appello a2=g.Crea_Appello(prove_appello1, c2);

		
		Studente stud=new Studente("Marco", "Bonacci", "N46003917");
		g.Prenota_Appello(stud,a2);		
		
		
		Studente stude=new Studente("Francesca", "Marrandino", "M13003329");
		g.Prenota_Appello(stude,a2 );
		
		Studente stud2=new Studente("Michele", "Rossi", "N45003456");
		g.Prenota_Appello(stud2, a1);
		
		g.Visualizza_Prenotati(null);
	
		
	   

}
	
}