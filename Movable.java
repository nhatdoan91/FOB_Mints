package com.mycompany.hi;

abstract public class Movable extends GameObject{
	private int heading;
	private int speed;

	
	
	public void move() {
		double moveX;
		double moveY;
		Point point= super.getLocation();
		moveX=  (Math.cos(-(heading-90))*speed);
		moveY=  (Math.sin(-(heading-90))*speed);
		point.setX(point.getX()+moveX);
		point.setY(point.getY()+moveY);
		super.setLocation((Math.cos(-(heading-90))*speed), (Math.sin(-(heading-90))*speed));
	}
	public void setHeading(int heading) {
		this.heading=heading;
	}
	public int getHeading(){
		return this.heading;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public int getSpeed() {
		return this.speed;
	}
	public boolean isOutOfBoudaries() {
		if(super.getLocation().getX()>1000||super.getLocation().getX()<0||super.getLocation().getY()>1000||super.getLocation().getY()<0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public void bound() {
		this.heading=this.heading+180;
		this.checkHeadingBoudaries();
	}
	
	public void checkHeadingBoudaries()
	{
		if(this.heading>360)
		{
			this.heading=this.heading-360;
		}else if(this.heading<0)
		{
			this.heading=this.heading+360;
		}
	}
}
