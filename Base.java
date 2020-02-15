package com.mycompany.hi;

import com.codename1.charts.util.ColorUtil;

public class Base extends Fixed {
	
	private int sequenceNumber;

	public Base(int size)
	{		
		super.setSize(size);
		super.setColor(ColorUtil.GREEN);
		super.setRandomLocation();
	
	}

	public int getSequenceNumber() {
		return this.sequenceNumber;
	}
	public void collideWithCyborg()
	{
		this.sequenceNumber++;
	}
	public void setSize() {}
	public void setColor() {}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber=sequenceNumber;
		
	}
}
