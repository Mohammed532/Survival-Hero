package survival_hero.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import survival_hero.generic.Display;
import survival_hero.generic.Handler;
import survival_hero.input.KeyManager;
import survival_hero.input.MouseManager;
import survival_hero.res.gfx.Assets;
import survival_hero.res.gfx.GameCam;
import survival_hero.res.gfx.ImageLoader;
import survival_hero.res.gfx.Spritesheet;
import survival_hero.states.GameState;
import survival_hero.states.MainMenu;
import survival_hero.states.SettingsMenu;
import survival_hero.states.State;

public class Game implements Runnable{
	
	private BufferStrategy bs;
	private Graphics g;
	private Display display;
	public String title;
	private Thread thread;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private GameCam gameCam;
	private Handler handler;
	
	
	public static int width;
	public static int height;
	private boolean running = false;
	private boolean loop;
	public static int playerAmt;
	private int fpsCounter;
	
	///////////States/////////////
	public State gameState;
	public State mainMenu;
	public State setting;
	
	/////////////////////////////
	
	public Game(String title, int width, int height) {
		this.height = height;
		this.width = width;
		this.title = title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
			
	}
	
	private void Init() {
		Assets.init();
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		handler = new Handler(this);
		gameCam = new GameCam(handler, 0, 0);
		
		gameState = new GameState(handler);
		mainMenu = new MainMenu(handler);
		setting = new SettingsMenu(handler);
		State.setState(mainMenu);
		
	}
	
	private void update() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
//		if (handler.getMouseManager().isLeftPressed()) {
//			System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
//		}
		
		if(MainMenu.play) { 
			State.setState(gameState);
			MainMenu.play = false;
		}
		
		if(keyManager.enter) {
			State.setState(gameState);
		}else if(keyManager.space) {
			State.setState(setting);
			if(keyManager.numb1) {
				playerAmt = 1;
				System.out.println(playerAmt);
				State.setState(gameState);
			}
			if(keyManager.numb2) {
				playerAmt = 2;
				System.out.println(playerAmt);
				State.setState(gameState);
			}
		}else if(keyManager.esc) {
			State.setState(mainMenu);
		}
	}
	
	public void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		////////////////////////Canvas//////////////////////////
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		////////////////////////////////////////////////////////
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		Init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks ++;
				delta--;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS: " + ticks);
				fpsCounter = ticks;
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCam getGameCam() {
		return gameCam;
	}
	
	public int getFps() {
		return fpsCounter;
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}

	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
	}

}
