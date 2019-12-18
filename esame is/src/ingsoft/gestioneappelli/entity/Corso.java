package ingsoft.gestioneappelli.entity;
import ingsoft.gestioneappelli.entity.Docenti;
import ingsoft.gestioneappelli.entity.Insegnamenti;

public class Corso {
private int Id;
private Docenti Docente;
private Insegnamenti insegnamento;
private int CFU;


public Corso(int id,Docenti docente ,Insegnamenti insegnamento,int cfu)
{this.Id=id;
this.Docente=docente;
this.insegnamento=insegnamento;
this.CFU=cfu;
}

public void SetDocente(Docenti docente)
{
	this.Docente=docente;
}

public Docenti GetDocente()
{
	return Docente;
}

public void Set_insegnamento(Insegnamenti insegnamento)
{
	this.insegnamento=insegnamento;
}

public Insegnamenti Get_insegnamento()
{
	return insegnamento;
}


public void SetCFU(int cfu)
{
	this.CFU=cfu;
}

public int GetCFU()
{
	return CFU;
}

public int GetIdCorso()

{
	return this.Id;
}
}
