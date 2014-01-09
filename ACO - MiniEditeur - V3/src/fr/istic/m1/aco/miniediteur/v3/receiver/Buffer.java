package fr.istic.m1.aco.miniediteur.v3.receiver;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class Buffer
 */
public class Buffer {
	
	private StringBuffer contenu;

	/**
	 * Constructeur du buffer
	 */
	public Buffer() {
		this.contenu = new StringBuffer();
	}

	/**
	 * Methode du buffer qui efface une partie de son contenu
	 * @param debut : correspond a l'index de debut de la partie du contenu a effacer
	 * @param fin : correspond a l'index de fin de la partie du contenu a effacer
	 */
	public void effacer(int debut, int fin) {
		this.contenu.delete(debut, fin);
	}

	/**
	 * Methode qui efface tout le buffer
	 */
	public void effacer() {
		if(this.contenu.length() > 0) {
			this.contenu.delete(0, this.contenu.length());
		}
	}

	/**
	 * Methode qui insere une chaine s a l'index position de contenu 
	 * @param s : une chaine a inserer
	 * @param position : un entier correspondant a l'index ou doit etre inserer la chaine s
	 */
	public void inserer(String s, int position) {
		this.contenu.insert(position, s);
	}


	/**
	 * @param debut : un entier correspondant au debut de la partie du contenu demandee du Buffer
	 * @param fin : un entier correspondant a la fin de la partie du contenu demandee du Buffer
	 * @return : Une chaine contenant une partie de l'attribut contenu du Buffer delimite par debut et fin
	 */
	public String getContenu(Integer debut, Integer fin) {
		return this.contenu.substring(debut, fin);
	}

	/**
	 * @return : une chaine correspondant a l'attribut contenu du Buffer
	 */
	public String getContenu() {
		return this.contenu.toString();
	}

	/**
	 * Modifier l'attribut contenu du Buffer
	 * @param s : une chaine s correspondant au nouveau contenu du Buffer
	 */
	public void setContenu(String s) {
		this.contenu.append(s);
	}

	/**
	 * @return : un entier correspondant a la taille du contenu du Buffer
	 */
	public int size() {
		return this.contenu.length();
	}
}
