package com.mycompany.hi;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed {
	private int energyCapacity;
	Random random = new Random();
	
	public EnergyStation()
	{		
		super.setSize(10+random.nextInt(30));
		super.setColor(ColorUtil.GREEN);
		super.setRandomLocation();
		this.energyCapacity=(super.getSize()/10)*5;// energyCapacity is proportional with size (ratio 1:2)
	}
	
	public int collideWithCyborg() {
		super.setColor(ColorUtil.rgb(0,50,0));
		return 0;
	}
	
	public int getenergyCapacity() {
		return this.energyCapacity;
	}
	public void setSize() {}
	public void setColor() {}
}
