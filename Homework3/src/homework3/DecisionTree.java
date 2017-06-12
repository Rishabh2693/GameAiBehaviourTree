package homework3;

import processing.core.PApplet;

public class DecisionTree {
	PApplet parent;
	CustomShape cS;
	Potter potter;
	DecisionTree(PApplet p,CustomShape cs,Potter pot){
		parent = p;
		cS = cs;
		potter = pot;
	}
	void decisionTree(){
		if(Math.abs((potter.position.x+800)-(cS.position.x+600))>350||Math.abs((potter.position.y+600)-(cS.position.y+400))>350){
			cS.wander1();
		}
		else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>480&&cS.position.y+400<640)
			cS.dance();
		else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>480&&cS.position.y+400<640)
			cS.dance();
		else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>120&&cS.position.y+400<280)
			cS.dance();
		else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>120&&cS.position.y+400<200)
			cS.dance();
		else
			cS.gRoom();
	}
	

}
