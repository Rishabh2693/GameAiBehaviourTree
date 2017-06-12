package homework3;

import processing.core.PApplet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BehaviourTree {
	PApplet parent;
	CustomShape cS;
	Potter potter;
	public boolean reset;
	int s;
	int prev;
	boolean s3;
	boolean s4;
	boolean caught;
	/**
	 * @param args
	 * @throws IOException 
	 */
	BehaviourTree(PApplet p,CustomShape cs,Potter pot){
		parent = p;
		cS = cs;
		potter = pot;
		reset = false;
		s = 0;
		prev = 0;
		s3 = false;
		s4 = false;
		caught = false;
	}
	void BehaviouTree(){
		
		if(s == 0){
			if(prev == 0){
				s++;
				prev = 0;
			}
			else
			{
				s = 9;
				prev = 0;
			}
		}
		else if(s==1){
			//Decorator
			if(!caught){
				if(prev == 0)
				{
					s = 2;
					prev = 1;	
				}
				else if(prev == 2){
					s = 2;
					prev = 1;
				}
			}
			else{
				s = 0;
				prev = 1;
			}
		}
		else if(s==2){
				if(prev == 1){
					s = 3;
					prev = 2;
				}
				else if(prev == 3){
					if(s3==true)
					{
						s=1;
						prev = 2;
						s3 = false;
					}
					else{
						s=7;
						prev = 2;
					}
				}else if(prev == 7){
					s = 1;
					prev = 2;
			}
		}
		else if(s==3){
			if(prev == 2){
				s=4;
				prev = 3;
				s3 = false;
			}
			else if(prev==4){
				if(s4==true){
					s = 5;
					prev = 3;
					s3 = true;
				}
				else{
					s = 2;
					prev =3;
				}
			}
			else if(prev == 5){
				s = 2;
				prev = 3;
			}
		}
		else if(s==4){
			if(Math.abs((potter.position.x+800)-(cS.position.x+600))>300||Math.abs((potter.position.y+600)-(cS.position.y+400))>300){
				s4 = true;
				s = 3;
				prev = 4;
			}
			else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>480&&cS.position.y+400<640){
				s4 = true;
				s = 3;
				prev = 4;
			}
			else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>480&&cS.position.y+400<640){
				s4 = true;
				s = 3;
				prev = 4;
			}
			else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>120&&cS.position.y+400<280){
				s4 = true;
				s = 3;
				prev = 4;
			}
			else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>120&&cS.position.y+400<200){
				s4 = true;
				s = 3;
				prev = 4;
			}
			else
			{
				s4 = false;
				s = 3;
				prev = 4;
			}
		}
		else if(s == 5){
			if(Math.abs((potter.position.x+800)-(cS.position.x+600))>300||Math.abs((potter.position.y+600)-(cS.position.y+400))>300){
				s = 6;
				prev = 5;
			}
			else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>480&&cS.position.y+400<640){
				s = 6;
				prev = 5;
			}
			else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>480&&cS.position.y+400<640){
				s = 6;
				prev = 5;
			}
			else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>120&&cS.position.y+400<280){
				s = 6;
				prev = 5;
			}
			else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>120&&cS.position.y+400<200){
				s = 6;
				prev = 5;
			}
			else{
				s = 3;
				prev = 5;
			}
		}
		else if(s == 6){
			potter.wander();
			s = 5;
			prev = 6;
		}
		else if(s == 7){
			if(Math.abs((potter.position.x+800)-(cS.position.x+600))<25 && Math.abs((potter.position.y+600)-(cS.position.y+400))<25){
				s = 2;
				prev = 7;
				caught = true;
			}
		//	else if(Math.abs((potter.position.x+800)-(cS.position.x+600))<300&&Math.abs((potter.position.y+600)-(cS.position.y+400))<300){
		//		s = 8;
		//		prev = 7;
		//	}
			else if(!(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>480&&cS.position.y+400<640)&&
					!(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>480&&cS.position.y+400<640)&&
					!(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>120&&cS.position.y+400<280)&&
					!(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>120&&cS.position.y+400<200)){
				s = 8;
				prev = 7;
			}
			else{
				s = 2;
				prev = 7;
			}
		}
		if(s==8){
			potter.pathFollow();
			s = 7;
			prev = 8;
		}
		if(s==9){
			s = 0;
			prev = 0;
			caught = false;
			potter.path = null;
			cS.path = null;
			cS.position.x = 0;
			cS.position.y = 0;
			potter.position.x = 0;
			potter.position.y = 0;
			reset = true;
		}
//		//System.out.println("yahoo");
//		if(Math.abs((potter.position.x+800)-(cS.position.x+600))<25&&Math.abs((potter.position.y+600)-(cS.position.y+400))<25)
//		{
//			parent.textSize(60);
//			parent.text("GAME OVER", 500, 300);
//
//			reset = true;
//
//		}
//		else if(Math.abs((potter.position.x+800)-(cS.position.x+600))>300||Math.abs((potter.position.y+600)-(cS.position.y+400))>300){
//			potter.wander();
//		}
//		else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>480&&cS.position.y+400<640)
//			potter.wander();
//		else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>480&&cS.position.y+400<640)
//			potter.wander();
//		else if(cS.position.x+600>240&&cS.position.x+600<360&&cS.position.y+400>120&&cS.position.y+400<280)
//			potter.wander();
//		else if(cS.position.x+600>920&&cS.position.x+600<1040&&cS.position.y+400>120&&cS.position.y+400<200)
//			potter.wander();
//		else
//			potter.pathFollow();
		
	}
	

}
