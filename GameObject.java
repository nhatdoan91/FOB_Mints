package com.mycompany.hi;
import java.util.Random;


abstract public class GameObject extends GameWorld{

	Random random = new Random();
	private int size;
	private int color;
	private Point location;
	
	public GameObject()
	{}
	
	public void setSize(int size)
	{
		this.size=size;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public Point getLocation()
	{	
		return location;
	}
	
	public void setLocation(double x,double y) 
	{
		this.location.setX(x);
		this.location.setY(y);
	}
	public void setLocation(Point point) 
	{
		this.location=point;
	}
	public void setRandomLocation() {
		//int x=random.nextInt(1000);
		//int y=random.nextInt(1000);
		//this.location.setX(x);
		//this.location.setY(y);
	}
	
	public void setColor(int newColor)
	{
		color = newColor;
	}
	public int getColor()
	{
		return this.color; 
	}
}
