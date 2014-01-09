package fr.istic.m1.aco.miniediteur.v3.receiver;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class PressePapier
 */
public class PressePapier {
	
	private String contenu;
	
	/**
	 * Constructeur du PressePapier
	 */
	public PressePapier() {
		this.contenu = "";
	}

	/**
	 * @return : une chaine correspondant a l'attribut contenu du PressePapier
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Modifier l'attribut contenu du PressePapier
	 * @param contenu : une chaine s correspondant au nouveau contenu du PressePapier
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
		
}
