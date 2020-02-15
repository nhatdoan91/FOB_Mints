package com.mycompany.hi;

import com.codename1.charts.util.ColorUtil;

public class Cyborg extends Movable implements ISteerable {
	
	private int steeringDirection;
	private int maximumSpeed;
	private int energyLevel;
	private int energyComsumptionRate;
	private int damageLevel=0;
	private int lastBaseReached;
	
	public Cyborg(int energyLevel, int size, int heading, int maximumSpeed, int energyConsumptionRate)
	{
		this.steeringDirection=0;
		super.setHeading(heading);
		super.setSpeed(0);
		this.maximumSpeed=maximumSpeed;
		this.energyComsumptionRate=energyConsumptionRate;
		this.damageLevel=0;
		this.energyLevel=energyLevel;
		this.lastBaseReached=1;
		super.setColor(ColorUtil.BLUE);
		super.setSize(size);
	}
	
	public void energyLostAfterTick()
	{
		this.energyLevel=this.energyLevel-this.energyComsumptionRate;
	}
	public void changeHeading(char input) {
		switch(input) {
		case 'l':
			//super.setHeading(super.getHeading()-5);
			if(this.steeringDirection>super.getHeading()-40)
			{
				this.steeringDirection=this.steeringDirection-5;
				System.out.println("\nYou steering direction is "+ this.getSteeringDirection()+" \n");
			}
			else
			{
				System.out.println("\nYou cant steer left anymore!!!!");
			}
			break;
		case 'r':
			if(this.steeringDirection<super.getHeading()+40)
			{
				this.steeringDirection=this.steeringDirection+5;
				System.out.println("\nYou steering direction is "+ this.getSteeringDirection()+" \n");
			}
			else
			{
				System.out.println("\nYou cant steer right anymore!!!!");
			}
			break;
		default:
			System.out.println("invalid input!!!!!!");
			break;
		}
		
	}
	
	public int getSteeringDirection()
	{
		return this.steeringDirection;
	}
	public void setSteeringDirection(int newSteeringDirection)
	{
		this.steeringDirection=newSteeringDirection;
	}
	
	public int getMaximumSpeed() {
		return this.maximumSpeed;
	}
	
	public int getEnergyLevel()
	{
		return this.energyLevel;
	}
	
	public int getEnergyConsumptionRate() {
		return this.energyComsumptionRate;
	}

	private void setDamageLevel(int damage)
	{
		this.damageLevel=damage;
	}
	
	public int getDamageLevel() {
		return this.damageLevel;
	}
	public boolean isMaxSpeed() {
		return super.getSpeed()>this.getMaximumSpeed();
	}
	public void speedUp()
	{
		super.setSpeed(super.getSpeed()+1);
		if(this.isMaxSpeed())
		{
			super.setSpeed(maximumSpeed);
			System.out.println("\nYou reached to the max speed!!!\n");
		}
	}
	public void slowDown()
	{
		super.setSpeed(super.getSpeed()-1);
		if(super.getSpeed()<=0)
		{
			super.setSpeed(0);
			System.out.println("\nYou stopped!!!\n");
		}
	}
	public boolean isBroken() {
		return this.damageLevel+3>=10;
	}
	public boolean isOutOfBattery() {
		return (this.getEnergyLevel()==0);
	}
	 public void reduceSpeedWithDamage() {
		 super.setSpeed((super.getSpeed()*this.damageLevel)/10);
	 }
	 public void collideWithCyborg()
	 {
		 if((this.damageLevel +5)<=10)
		 {
			 this.damageLevel=this.damageLevel+5;
			 super.setColor(ColorUtil.rgb(0, 0, (this.damageLevel*250)/10));
		 }else
		 {
			 System.out.println("\nCyborg is too damaged!!!");
		 }
	
	 }
	 public void collideWithDrone()
	 {
		 if((this.damageLevel+3)<=10)
		 {
			 this.damageLevel=this.damageLevel+3;
			 super.setColor(ColorUtil.rgb(0, 0, (this.damageLevel*250)/10));
		 }else
		 {
			 System.out.println("\nCyborg is too damaged!!!");
		 }
		 
	 }
	 public void baseReach(int baseNumber) {
		 if(baseNumber==(this.lastBaseReached+1))
		 {
			 this.lastBaseReached=baseNumber;
			 System.out.println("Congrats!! You reach base "+this.getLastBaseReached());
		 }else if(baseNumber <= this.lastBaseReached)
		 {
			 System.out.println("\nYou have reached this base!!!\n");
			 System.out.println("\nYou need to reach base "+ (this.lastBaseReached+1));
		 }else
		 {
			 System.out.println("\nYou passed base "+ (this.lastBaseReached+1));
			 System.out.println("\nYou need to reach base "+ (this.lastBaseReached+1) + " first");
		 }
	 }
	 public void setSize() 
	 {}
	 public int getLastBaseReached() {
		 return this.lastBaseReached;
	 }
	 public void reachEnergyStation(int energy) {
		 this.energyLevel=this.energyLevel+energy;
		 if(this.getEnergyLevel()>100) {
			 this.energyLevel=100; //MAX
		 }
	 }

}
