package tp5.controler;

import tp5.model.AbstractModel;

public class Controller extends AbstractControler {

	public Controller(AbstractModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cliqueSur(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculerStepSuivant() {
		// TODO Auto-generated method stub
		model.demandeMiseAjourVue();
		model.faireSeDeplacerLesAnimaux();
	}
	
	public void gameLoop() {

		  final long ticksPerSecond = 25;
		  final long skipTicks = 1000 / ticksPerSecond;
		  final int maxFrameSkip = 5;

		  long nextUpdateTick = System.currentTimeMillis();
		  int loops;

		  while (true) {
		    loops = 0;
		    while (System.currentTimeMillis() > nextUpdateTick && loops < maxFrameSkip) {
		      model.demandeMiseAjourVue();
		      nextUpdateTick += skipTicks;
		      loops++;
		    }
//		    dessinerJeu();
//		    model.faireSeDeplacerLesAnimaux();
		    model.demandeMiseAjourVue();
		  }
		}

}
