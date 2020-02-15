package com.mycompany.hi;
import java.util.Random;
import java.util.Vector;

public class GameWorld {
	Random random = new Random();
	private int gameTime;
	private int liveOfPlayer;
	private boolean endGame;
	private final int energyLevel=100;
	private final int cyborgSize= 40;
	private final int intialCyborgHeading=0;
	private final int cyborgMaxSpeed=10;
	private final int baseSize=15;
	
	private Vector<GameObject> gameObjects = new Vector<GameObject>();
	
	public void GameWorld()
	{
		init();
	}
	public void setLiveOfPlayer(int numberOfLive)
	{
		liveOfPlayer = numberOfLive;
	}
	public int getLiveOfPlayer(int numberOflive)
	{
		return liveOfPlayer;
	}
	public void init()
	{
		gameTime=0;
		liveOfPlayer=3;
		endGame=false;
		char d='d',b='b',c='c',e='e';
		createGameObject(c);
		int numberOfBase= 4+random.nextInt(6);
		int numberOfDrone=2+random.nextInt(4);
		int numberOfEnergyStation=2+random.nextInt(4);
		for(int i=1; i<= numberOfBase; i++)
		{
			createGameObject(b);
			
		}
		for (int i=0; i<gameObjects.size(); i++) {
			if (gameObjects.elementAt(i) instanceof Base) {
			Base base = (Base)gameObjects.elementAt(i);
			base.setSequenceNumber(i+1);
			if(i==1)
			{
				findCyborg().setLocation(findBase().getLocation());
			}
			}
		}
		for(int i=1; i<= numberOfDrone; i++)
		{
			createGameObject(d);
		}
		for(int i=1; i<= numberOfEnergyStation; i++)
		{
			createGameObject(e);
		}
	}
	public Cyborg findCyborg() {
		for(int i=0; i< gameObjects.size();i++)
		{
			if(gameObjects.get(i) instanceof Cyborg)
			{
				return (Cyborg) gameObjects.get(i);
			}
		}
		return null;
	}
	public Base findBase() {
		for(int i=0; i< gameObjects.size();i++)
		{
			if(gameObjects.get(i) instanceof Base)
			{
				return (Base) gameObjects.get(i);
			}
		}
		return null;
	}

	public EnergyStation findEnergyStation() {
		for(int i=0; i< gameObjects.size();i++)
		{
			if(gameObjects.get(i) instanceof EnergyStation)
			{
				return (EnergyStation) gameObjects.get(i);
			}
		}
		return null;
	}
	public EnergyStation collideFirstEnergyStation() {
		int count =0;
		for(int i=0; i< gameObjects.size();i++)
		{
		while(count!=1)
		{
			if(gameObjects.get(i) instanceof EnergyStation)
			{
				count++;
				return (EnergyStation) gameObjects.get(i);	
			}
		}
		}
		return null;
	}
	public Drone findDrone() {
		for(int i=0; i< gameObjects.size();i++)
		{
			if(gameObjects.get(i) instanceof Drone)
			{
				return (Drone) gameObjects.get(i);
			}
		}
		return null;
	}
	public void createGameObject(char nameObject) {
		switch(nameObject) {
		case 'c':
			Cyborg c = new Cyborg(energyLevel, cyborgSize,  intialCyborgHeading, cyborgMaxSpeed ,cyborgSize*2);
			gameObjects.add(c);
			break;
		case 'd':
			Drone d = new Drone();
			gameObjects.add(d);
			break;
		case 'b':
			Base b = new Base(baseSize);
			gameObjects.add(b);
			break;
		case 'e':
			EnergyStation e = new EnergyStation();
			gameObjects.add(e);
			break;
		}
	}
	public void clickTick()
	{
		gameTime++;
		for(int i=0; i< gameObjects.size();i++)
		{
			if(gameObjects.get(i) instanceof Movable)
			{
				Movable mov = (Movable) gameObjects.get(i);
				mov.move();
				System.out.println("\nA movable object just moved!");
			}
		}
	}
	public void exit() {
	
		System.exit(0);
	}
	
}
