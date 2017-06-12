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
//	BehaviourTree bt;
	LearnTree lt;
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
	//		  try {
	//			bt = new BehaviourTree(this,cS,p);
	//		} catch (IOException e) {
				// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
			  lt = new LearnTree(this,cS,p);
		  }
		  
		  public void draw() {
			//  if(bt.reset==true){
			//	  setup();
			//	  return;
			 // }
			  if(lt.reset==true){
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
			  
	//		  try {
	//			bt.BehaviouTree();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
			  lt.learnTree();
			  dt.decisionTree();
			  cS.drawBreadcrumbs();
			  p.drawBreadcrumbs();
			  p.update();
			  cS.update();
			  p.display();
		      cS.display();
		      
		  }


}
