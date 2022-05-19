/*
 * Author : gabrielleexshaw
 * Date : May 16, 2022
 * Description : 
 */
package application;

public class Regles
{
	private String prenom;
	private String pms;
	private String cycle;
	private Double age;


	//constructeur vide
	public Regles()
	{
		this(null,null,null);
	}

	// Constructeur avec 2 paramètres
	public Regles(String prenom, String pms, String cycle)
	{
		this.prenom=prenom;
		this.pms=pms;
		this.cycle=cycle;
		this.age=0.0;
	}

	//Getters et Setters 

	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public String getPMS()
	{
		return pms;
	}
	public void setPMS(String pms)
	{
		this.pms = pms;
	}
	public String getCycle()
	{
		return cycle;
	}
	public void setCycle(String cycle)
	{
		this.cycle = cycle;
	}
	public Double getAge()
	{
		return age;
	}
	public void setAge(Double age)
	{
		this.age = age;
	}

}
