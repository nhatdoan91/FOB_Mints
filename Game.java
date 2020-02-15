package com.mycompany.hi;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import com.codename1.charts.util.ColorUtil;

public class Game extends Form{
	private GameWorld gw;
	public Game() {
	gw = new GameWorld();
	gw.init();
	play();
	}
	private void play()
	{
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0)
						switch (sCommand.charAt(0)) {
						case 'x':
							gw.exit();
							break;
						case 'a':
							gw.findCyborg().speedUp();
							System.out.println("\n.Your Cyborg's speed is "+ gw.findCyborg().getSpeed() + " units per tick\n");
							break;
						case 'b':
							gw.findCyborg().slowDown();
							System.out.println("\n.Your Cyborg's speed is "+ gw.findCyborg().getSpeed() + " units per tick\n");
							break;
						case 'l':
							gw.findCyborg().changeHeading('l');
							break;
						case 'r':
							gw.findCyborg().changeHeading('r');
							break;
						case 'c':
							if(!gw.findCyborg().isBroken())
							{
								gw.findCyborg().collideWithCyborg();
								System.out.println("\nYou just collided with another cyborg");
								System.out.println("\nCyborg's damage level is "+ gw.findCyborg().getDamageLevel());
								System.out.println("\nCyborg's color is: " + "[" + ColorUtil.red(gw.findCyborg().getColor()) + "," + 
										+ ColorUtil.green(gw.findCyborg().getColor()) + "," + 
										+ ColorUtil.blue(gw.findCyborg().getColor()) + "]");
							}else {
								System.out.println("\nYour Cyborg is destroyed");
							}
							
							break;	
						case '1' :
							gw.findCyborg().baseReach(1);
							break;
						case '2' :
							gw.findCyborg().baseReach(2);
							break;
						case '3' :
							gw.findCyborg().baseReach(3);
							break;
						case '4' :
							gw.findCyborg().baseReach(4);
							break;
						case '5' :
							gw.findCyborg().baseReach(5);
							break;
						case '6' :
							gw.findCyborg().baseReach(6);
							break;
						case '7' :
							gw.findCyborg().baseReach(7);
							break;
						case '8' :
							gw.findCyborg().baseReach(8);
							break;
						case '9' :
							gw.findCyborg().baseReach(9);
							break;
							
						case 'e':
						
							//System.out.println("\nEnergy of this station before collision is"+gw.collideFirstEnergyStation().getenergyCapacity());
							//gw.findCyborg().reachEnergyStation(gw.collideFirstEnergyStation().getenergyCapacity());
							//System.out.println("\nEnergy of Cyborg is recharged to" + gw.findCyborg().getEnergyLevel());
							
							//System.out.println("\nEnergy of this station after collision is"+ gw.collideFirstEnergyStation().collideWithCyborg());
							//System.out.println("\nColor of this station is: " + "[" + ColorUtil.red(gw.collideFirstEnergyStation().getColor()) + "," +
							//												ColorUtil.green(gw.collideFirstEnergyStation().getColor()) + "," + 							
							//												+ ColorUtil.blue(gw.collideFirstEnergyStation().getColor()) + "]");
							break;
						case 'g':
							if(!gw.findCyborg().isBroken())
							{
								gw.findCyborg().collideWithDrone();
								System.out.println("\nYou just collided with a drone");
								System.out.println("\nCyborg's damage level is "+ gw.findCyborg().getDamageLevel());
								System.out.println("\nCyborg's color is: " + "[" + ColorUtil.red(gw.findCyborg().getColor()) + "," + 
										+ ColorUtil.green(gw.findCyborg().getColor()) + "," + 
										+ ColorUtil.blue(gw.findCyborg().getColor()) + "]");
							}else {
								System.out.println("\nYour Cyborg is destroyed");
							}
							break;
						case 't':
							gw.clickTick();
							break;
						case 'd':
							gw.exit();
							break;
						case 'm':
							gw.exit();
							break;
						default:
							System.out.println("\nYour Input is invalid.Please enter valid command!!!\n");
							break;
						
	//add code to handle rest of the commands
						} //switch
				} //actionPerformed
		} //new ActionListener()
		); //addActionListener
	} //play
}
