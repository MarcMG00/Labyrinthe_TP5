package tp5.model;

import java.util.ArrayList;

import tp5.animaux.Animal;

public class Case {
	protected TypeCase typeCase;
	protected int x;
	protected int y;
	protected ArrayList<Animal> animaux;

	public Case(TypeCase typeCase) {
		// TODO Auto-generated constructor stub
		this.typeCase = typeCase;
		this.animaux = new ArrayList<Animal>();
	}
	
	public ArrayList<Animal> ajouterAnimal(Animal animal) {
		this.animaux.add(animal);
		return this.animaux;
	}
	
	public ArrayList<Animal> supprimerAnimal(Animal animal) {
		if(this.animaux.contains(animal)) {
			this.animaux.remove(animal);
		};
		return this.animaux;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TypeCase getTypeCase() {
		return typeCase;
	}

	public void setTypeCase(TypeCase typeCase) {
		this.typeCase = typeCase;
	}
	
	public ArrayList<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimal(ArrayList<Animal> animaux) {
		this.animaux = animaux;
	}

}
