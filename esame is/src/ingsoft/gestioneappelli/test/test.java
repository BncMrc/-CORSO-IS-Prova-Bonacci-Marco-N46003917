package ingsoft.gestioneappelli.test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ingsoft.gestioneappelli.entity.Appello;
import ingsoft.gestioneappelli.entity.Corso;
import ingsoft.gestioneappelli.entity.Docenti;
import ingsoft.gestioneappelli.entity.Insegnamenti;
import ingsoft.gestioneappelli.entity.Prova;
import ingsoft.gestioneappelli.entity.Studente;
import ingsoft.gestioneappelli.entity.Tipo_Prova;
import ingsoft.gestioneappelli.control.*;


public class test {

	GestioneAppelli g;
	
	
@Before
	public void PreparaOggetti()
	{
	 g =new GestioneAppelli();
	 g.CreaCorso(Docenti.Roberto_Natella,Insegnamenti.Ingegneria_del_Software,9);
	 g.CreaCorso(Docenti.Roberto_Pietrantuono,Insegnamenti.Sistemi_Operativi, 9);
	 g.CreaCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale, 9);
	}
	
	
	
	
	
	
	
	@Test
	public void test1() {
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c1=g.GetCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale);
		Appello a=g.Crea_Appello(prove_appello1, c1);
		int t=g.Visualizza_PrenotatiT(a);
		assertEquals(0,t);
	}
	
	@Test
	public void test2() {
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c1=g.GetCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale);
		Appello a=g.Crea_Appello(prove_appello1, c1);
		Studente stude=new Studente("Francesca", "Marrandino", "M13003329");
		g.Prenota_Appello(stude,a );
		int t=g.Visualizza_PrenotatiT(a);
		assertEquals(1,t);
	}
	
	@Test
	public void test3() {
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c1=g.GetCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale);
		Appello a=g.Crea_Appello(prove_appello1, c1);
		
		Studente stud=new Studente("Marco", "Bonacci", "N46003917");
		g.Prenota_Appello(stud,a);		
		
		Studente stude=new Studente("Francesca", "Marrandino", "M13003329");
		g.Prenota_Appello(stude,a );
		
		int t=g.Visualizza_PrenotatiT(a);
		assertEquals(2,t);
	}
		
	
	@Test
	public void test4() {
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Appello a=null;
		
		Studente stud=new Studente("Marco", "Bonacci", "N46003917");
		g.Prenota_Appello(stud,a);		
		
		Studente stude=new Studente("Francesca", "Marrandino", "M13003329");
		g.Prenota_Appello(stude,a );
		
		int t=g.Visualizza_PrenotatiT(g.GetAppello(g.GetCorso(Docenti.Roberto_Natella, Insegnamenti.Ingegneria_del_Software)));
		assertEquals(0,t);
	}
		
	
	
	@Test
	public void test5() {
		Prova[] prove_appello1=new Prova[3];
		prove_appello1[0]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG I2", Tipo_Prova.SCRITTO);
		prove_appello1[1]=new Prova(LocalDate.of(2019, Month.AUGUST, 24), "SG T2", Tipo_Prova.ORALE);
		Corso c1=g.GetCorso(Docenti.Luca_Maresca,Insegnamenti.Elettronica_Generale);
		Appello a=g.Crea_Appello(prove_appello1, c1);
		
		Studente stud=new Studente("Marco", "Bonacci", "N46003917");
		g.Prenota_Appello(stud,a);		
		
		Studente stude=new Studente("Francesca", "Marrandino", "M13003329");
		g.Prenota_Appello(stude,a );
		
		int t=g.Visualizza_PrenotatiT(null);
		assertEquals(0,t);
	}
	
	@After
	public void tearDown() throws Exception {
		
		g=null;
	}	
	
	}


