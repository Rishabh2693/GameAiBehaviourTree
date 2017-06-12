package homework3;
import java.io.IOException;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;
public class ArriveBehaviour extends PApplet {
	CustomShape cS;
	PVector dest;
	Field r;
	LinkedList<Node> path;
	Potter p;
	DecisionTree dt;
	BehaviourTree bt;
	public static void main(String[] args){
		    PApplet.main("homework3.ArriveBehaviour");
		  }
	  		
		  public void settings(){
		    size(1200,800);
		  }

		  public void setup() {
		       r = new Field(this);
			   dest = new PVector(0,0);
			  cS = new CustomShape(0,0,this);
			  path=new LinkedList<Node>();
			  background(0,0,255);
			  p = new Potter(0,0,this,cS);
			  dt = new DecisionTree(this,cS,p);
			 
				bt = new BehaviourTree(this,cS,p);
			
		  }
		  
		  
		  public void draw() {
			  System.out.println(p.position.x+" "+p.position.y+" "+cS.position.x+" "+cS.position.y);
			  if(bt.reset==true){
				  setup();
				  return;
			  }
			  background(0,0,255);
			  if(cS.position.x<-600)
				  cS.position.x=600;
			  if(cS.position.y<-400)
				  cS.position.y=400;
			  if(cS.position.x>600)
				  cS.position.x=-600;
			  if(cS.position.y>400)
				  cS.position.y=-400;
			  
			  
			  r.diplayRoom();
			 
			 
			 // cS.pathFollow();
			 // cS.gRoom();
			//  cS.wander1();
			 // p.pathFollow();
			  
			  
			
				bt.BehaviouTree();
			
			  
	//		  lt.learnTree();
			  
			  //p.wander();
			  //////////////////////////////////////
			  dt.decisionTree();
			  //cS.dance();
			  //////////////////////////////////
			  p.update();
			  cS.update();
			  cS.drawBreadcrumbs();
			  p.drawBreadcrumbs();
			  p.display();
		      cS.display();
		      
		  }


}
