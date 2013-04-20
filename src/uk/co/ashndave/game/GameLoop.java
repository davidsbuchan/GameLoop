package uk.co.ashndave.game;

public class GameLoop implements Runnable {

	private Thread animator;
	private volatile boolean running = false;
	
	private Gameable game;
	private Renderable screen;
	
	public GameLoop(Gameable game, Renderable screen) {
		this.game = game;
		this.screen = screen;
	}
	
	public void startGame() {
		if((animator == null) || !running) {
			animator = new Thread(this);
			animator.start();
		}
	}
	
	public void stopGame() {
		running = false;
	}
	
	@Override
	public void run() {
		long beforeTime, timeDiff, sleepTime;
		beforeTime = System.nanoTime();
		long period = 10000000;
		
		running = true;
		while(running) {
			game.gameUpdate();
			screen.gameRender();

			timeDiff = System.nanoTime() - beforeTime;
			sleepTime = period - timeDiff;
			if(sleepTime <= 0) {
				sleepTime = 0;
			}
			
			try {
				Thread.sleep(sleepTime / 1000000);
			}catch(InterruptedException ex){}
			beforeTime = System.nanoTime();			
		}
	}

}
