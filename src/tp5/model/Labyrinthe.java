package tp5.model;

import java.util.ArrayList;

import tp5.animaux.Animal;
import tp5.animaux.Chat;
import tp5.animaux.Souris;

public class Labyrinthe extends AbstractModel {
	protected Case[][] tableau;
	protected Case caseIn;
	protected Case caseOut;
	protected int nbSourisIn;
	protected int nbSourisOut;

	public Labyrinthe() {
		// TODO Auto-generated constructor stub
		super();
		this.nbSourisIn = 1;
		this.tableau = new Case[10][8];
		// Remplissage du tableau (murs et chemins)
		for(int i = 0; i < tableau.length; i++) {
			for(int y = 0; y < tableau[i].length; y++) {
				if(i == 0 || i == 9 || y == 0 || y == 7) {
					tableau[i][y] = new Case(TypeCase.MUR);
				} else {
					tableau[i][y] = new Case(TypeCase.CHEMIN);
				}
			}
		}
		tableau[4][1] = new Case(TypeCase.MUR);
		tableau[2][2] = new Case(TypeCase.MUR);
		tableau[6][2] = new Case(TypeCase.MUR);
		tableau[6][3] = new Case(TypeCase.MUR);
		tableau[7][3] = new Case(TypeCase.MUR);
		tableau[4][3] = new Case(TypeCase.MUR);
		tableau[4][5] = new Case(TypeCase.MUR);
		tableau[5][5] = new Case(TypeCase.MUR);
		tableau[7][5] = new Case(TypeCase.MUR);
		tableau[2][6] = new Case(TypeCase.MUR);
		tableau[3][4] = new Case(TypeCase.MUR);
		
		// Remplissage du tableau (départ de sortie des souris et arrivée)
		tableau[1][1] = new Case(TypeCase.IN);
		tableau[8][6] = new Case(TypeCase.OUT);
		
		// Ajouter des animaux
		tableau[1][1].ajouterAnimal(new Souris());
		tableau[3][5].ajouterAnimal(new Chat());
		tableau[5][2].ajouterAnimal(new Chat());
	}

	@Override
	public void faireSeDeplacerLesAnimaux() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.tableau.length; i++) {
			for(int j = 0; j < this.tableau[i].length; j++) {
				for(int y = 0; y < this.tableau[i][j].getAnimaux().size(); y++) {
					if(this.tableau[i][j].getAnimaux().get(y) instanceof Chat && this.tableau[i+1][j].getTypeCase() == TypeCase.MUR) {
						this.tableau[i][j].supprimerAnimal(this.tableau[i][j].getAnimaux().get(y));
						this.tableau[i-2][j].ajouterAnimal(new Chat());
						System.out.println("mur devant");
					} else if(this.tableau[i][j].getAnimaux().get(y) instanceof Chat && this.tableau[i-1][j].getTypeCase() == TypeCase.MUR) {
						this.tableau[i][j].supprimerAnimal(this.tableau[i][j].getAnimaux().get(y));
						this.tableau[i+2][j].ajouterAnimal(new Chat());
						System.out.println("mur arrière");
					}
				}
			}
		}
	}

	@Override
	public TypeCase getTypeCase(int x, int y) {
		// TODO Auto-generated method stub
		return this.tableau[x][y].getTypeCase();
	}

	@Override
	public void setTypeCase(int x, int y, TypeCase tc) {
		// TODO Auto-generated method stub
		this.tableau[x][y].setTypeCase(tc);
		demandeMiseAjourVue();
	}

	@Override
	public Animal getAnimalPlusFort(int x, int y) {
		// TODO Auto-generated method stub
		ArrayList<Animal> animaux = tableau[x][y].getAnimaux();
		for(Animal a : animaux) {
			if(a instanceof Souris) {
				return a;
			}
			else if(a instanceof Chat) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int getLargeur() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getHauteur() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getNbSourisIn() {
		// TODO Auto-generated method stub
		return this.nbSourisIn;
	}

	@Override
	public int getNbSourisOut() {
		// TODO Auto-generated method stub
		return this.nbSourisOut;
	}

	@Override
	public int getNbFlecheUtilisee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbFlecheMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean partieTerminer() {
		// TODO Auto-generated method stub
		return false;
	}

}
