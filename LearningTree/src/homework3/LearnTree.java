package homework3;

import processing.core.PApplet;

public class LearnTree {

	PApplet parent;
	CustomShape cS;
	Potter potter;
	boolean caught;
	boolean reset;
	LearnTree(PApplet p,CustomShape cs,Potter pot){
		parent = p;
		cS = cs;
		potter = pot;
		reset =false;
	}
	void learnTree(){
		if(Math.abs((potter.position.x+800)-(cS.position.x+600))<25 && Math.abs((potter.position.y+600)-(cS.position.y+400))<25)
		{
			caught = false;
			reset = true;
			potter.path = null;
			cS.path = null;
			cS.position.x = 0;
			cS.position.y = 0;
			potter.position.x = 0;
			potter.position.y = 0;
		}
		else 
		{
			if(!(cS.position.x+600>920&&cS.position.x+600<1040)&&
			!(cS.position.x+600>240&&cS.position.x+600<360)&&
			!(cS.position.x+600>240&&cS.position.x+600<360)&&
			!(cS.position.x+600>920&&cS.position.x+600<1040))
			{
					
				if(Math.abs((potter.position.y+200)-cS.position.y)>300){
						potter.wander();
					
				}
				else{
						potter.pathFollow();
				}
				
			}
			else{
				if(!(cS.position.y+400>480&&cS.position.y+400<640)&&
						!(cS.position.y+400>480&&cS.position.y+400<640)&&
						!(cS.position.y+400>120&&cS.position.y+400<280)&&
						!(cS.position.y+400>120&&cS.position.y+400<200)){
					if(Math.abs((potter.position.y+200)-cS.position.y)>300){
						potter.wander();
					
					}
					else{
						potter.pathFollow();
					}
				}
				else{
					potter.wander();
				}
			}
		}
		
	}
	

}
