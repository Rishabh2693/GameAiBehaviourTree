package homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

class CustomShape extends SteeringParams{
	  PApplet parent;
	  float MaxAcc;
	  float maxSpeed;
	  ArrayList<PVector> breadcrumb = new ArrayList<PVector>();
	  PVector dest;	 
	  LinkedList<Node> path;
	  PVector d;
	  boolean reached;
	  CustomShape(float x, float y,PApplet p) {
	    acceleration = new PVector(0,0);
	    velocity = new PVector(0,0);
	    position = new PVector(x,y);
	    maxSpeed = 8;
	    MaxAcc = (float) 0.2;
	    parent = p;
	    dest = new PVector(0,0);
	    path=new LinkedList<Node>();
	    d = new PVector(0,0);
	    reached = false;
	  }
	 
	  void update() {
		position.add(velocity);  
	    velocity.add(acceleration);
	    velocity.limit(maxSpeed);
	    acceleration.mult(0);
	  }
	 void dance(){
		 	if(parent.frameCount%5!=0)
		 		return;
		 	float rand1;
		    float rand2;
		  //  rand1 = parent.random((float)-1,(float)1);
		  //  rand2 = parent.random((float)-1,(float)1);
			PVector velocity2 = velocity.copy();
			velocity2.rotate((float) .1);
		    velocity2.normalize();
		    velocity2.mult(maxSpeed);	 
		    PVector acc = PVector.sub(velocity2,velocity);
		    acc.limit((float) -0.8);
		    acceleration.add(acc);
		    setOrientation((float) (velocity2.heading() + PApplet.PI/2));
	 }
	 void gRoom(){
		  Graph g = new SmallGraph();
			Astar a = new Astar(g);
		    float sourcex = position.x+600;
		  	float sourcey = position.y+400;
		    Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	
		    List<Node> temp = new ArrayList<Node>();
		    for(int i=0;i<3;i++){
	        	for(int j=0;j<4;j++)
	        		temp.add(g.getNodes().get(96+i+(30*j)));
	        }
	        for(int i=0;i<3;i++){
	        	for(int j=0;j<4;j++)
	        		temp.add(g.getNodes().get(366+i+(30*j)));
	        }
	        for(int i=0;i<3;i++){
	        	for(int j=0;j<4;j++)
	        		temp.add(g.getNodes().get(383+i+(30*j)));
	        }
	        for(int i=0;i<3;i++){
	        	for(int j=0;j<2;j++)
	        		temp.add(g.getNodes().get(113+i+(30*j)));
	        }
		   
		    int rand1;
		    rand1 = (int)Math.floor(Math.random() * (temp.size()-0.01)); 
		    if(path == null)
		    	return;
		    if(path.size()==0&&reached==false){
		    	path = a.execute(source, temp.get(rand1));
		    	reached = true;
		    }
		    if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+400)/40)*30+parent.floor((position.x+600)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-600,path.getFirst().getY()+20-400);
				  }
				  else{
					  path.removeFirst();
				  }
		    }
		    if(path!=null&&path.size()>0)
				  System.out.println(d);
			  System.out.println(d+"fds");
			  arrive(d,5,100);
	 }
	 void pathFollow(){
		 float desty,destx;
		 Graph g = new SmallGraph();
		 Astar a = new Astar(g);
		  float sourcex = position.x+600;
		  float sourcey = position.y+400;
		 if(parent.mousePressed==true)
		  {
		  	dest = new PVector(parent.mouseX-600,parent.mouseY-400);
		  	sourcex = position.x+600;
		  	sourcey = position.y+400;
		  	desty = dest.y+400;
		  	destx = dest.x+600;
		  	Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	Node desti = g.getNodes().get( (parent.floor(desty/40)*30+parent.floor(destx/40)));
		  	path = a.execute(source, desti);
		  }
	   sourcex = position.x+600;
	   sourcey = position.y+400;	
		  if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+400)/40)*30+parent.floor((position.x+600)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-600,path.getFirst().getY()+20-400);
				  }
				  else{
					  path.removeFirst();
				  }
		  }
		  if(path!=null&&path.size()>0)
			  System.out.println(d);
	  arrive(d,5,100);
	 }
	 
	 void pathFollow1(float destx,float desty){
		 Graph g = new SmallGraph();
		 Astar a = new Astar(g);
		  float sourcex = position.x+600;
		  float sourcey = position.y+400;
		
	//	  	dest = new PVector(parent.mouseX-600,parent.mouseY-400);
		  	sourcex = position.x+600;
		  	sourcey = position.y+400;
	//	  	desty = dest.y+400;
	//	  	destx = dest.x+600;
		  	Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	Node desti = g.getNodes().get( (parent.floor(desty/40)*30+parent.floor(destx/40)));
		  	path = a.execute(source, desti);
		  	//System.out.println(source+" "+desti);
		  	
	   sourcex = position.x+600;
	   sourcey = position.y+400;	
		  if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+400)/40)*30+parent.floor((position.x+600)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-600,path.getFirst().getY()+20-400);
				  }
				  else{
					  path.removeFirst();
				  }
		  }
		  if(path!=null&&path.size()>0)
			  System.out.println(d);
	  arrive(d,5,100);
	 }
	 
	  void evade(Potter P){
		  PVector distance = PVector.sub(position,P.position);
		  float T = distance.mag() / maxSpeed;
		  PVector futurePosition  = PVector.add(P.position,P.velocity.mult(T));
		  seek(futurePosition);
		}
	  void seek(PVector target) {
		    PVector desired = PVector.sub(target,position);
		    desired.normalize();
		    desired.mult(maxSpeed);
		    PVector steer = PVector.sub(desired,velocity);
		    PVector acc = PVector.sub(steer,velocity);
		    acc.limit(MaxAcc);
		    acceleration.add(acc);
		    allign(target);
		  }
	  void wander() {
		    float rand1;
		    float rand2;
		    rand1 = parent.random((float)-1,(float)1);
		    rand2 = parent.random((float)-1,(float)1);
			PVector velocity2 = velocity.copy();
			velocity2.rotate(rand1-rand2);
		    velocity2.normalize();
		    velocity2.mult(maxSpeed);	 
		    PVector acc = PVector.sub(velocity2,velocity);
		    acc.limit(MaxAcc);
		    acceleration.add(acc);
		    allign();
		  }
	  void wander1() {
		    reached = false;
		    Graph g = new SmallGraph();
			Astar a = new Astar(g);
		    float sourcex = position.x+600;
		  	float sourcey = position.y+400;
		    Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	
		    List<Node> temp = new ArrayList<Node>();
		    for(int i = 0;i<g.getNodes().size();i++){
		    	if(!SmallGraph.obs.contains(i)&&source.getId()!=i)
		    		temp.add(g.getNodes().get(i));
		    	
		    }
		    
		    int rand1;
		    rand1 = (int)Math.floor(Math.random() * (temp.size()-0.01)); 
		    if(path==null)
		    	return;
		    if(path.size()==0)
		    	path = a.execute(source, temp.get(rand1));
		    if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+400)/40)*30+parent.floor((position.x+600)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-600,path.getFirst().getY()+20-400);
				  }
				  else{
					  path.removeFirst();
				  }
		  }
		    if(path!=null&&path.size()>0)
				  System.out.println(d);
			  System.out.println(d+"fds");
			  arrive(d,5,100);
	  }
	  
	  void wander2() {
		    reached = false;
		    Graph g = new SmallGraph();
			Astar a = new Astar(g);
		    float sourcex = position.x+600;
		  	float sourcey = position.y+400;
		    Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	
		    List<Node> temp = new ArrayList<Node>();
	//	    for(int i = 0;i<g.getNodes().size();i++){
	//	    	temp.add(96);
		    	
	//	    }
		    
		    int rand1;
		    rand1 = (int)Math.floor(Math.random() * (temp.size()-0.01)); 
		    System.out.println(temp.size());
		    System.out.println(rand1);
		    if(path.size()==0)
		    	path = a.execute(source, temp.get(rand1));
		    if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+400)/40)*30+parent.floor((position.x+600)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-600,path.getFirst().getY()+20-400);
				  }
				  else{
					  path.removeFirst();
				  }
		  }
		    if(path!=null&&path.size()>0)
				  System.out.println(d);
			  System.out.println(d+"fds");
			  arrive(d,5,100);
	  }
	  
	  
	  
	  void drawBreadcrumbs(){
		  if(parent.frameCount%20==0){
			  breadcrumb.add(new PVector(position.x+600,position.y+400));
		  }
		  for(PVector a:breadcrumb){
			  parent.beginShape();
			  parent.ellipse(a.x, a.y, 10, 10);
			  parent.endShape();
		  }
	  }
	  
	 
	  
	  void arrive(PVector target,float ros,float rod) {
		    PVector dir = PVector.sub(target,position);
		 
		    float dist = dir.mag();
		    dir.normalize();
		    if (dist < ros){
		    	velocity.mult(0.000001f);
		    	dist = 0;
		    }
		    else if (dist < rod) {
		      float m = PApplet.map(dist,0,rod,0,maxSpeed);
		      dir.mult(m);
		    } else {
		      dir.mult(maxSpeed);
		    }
		 
		    PVector acc = PVector.sub(dir,velocity);
		    acc.limit(MaxAcc);
		    acceleration.add(acc);
		    allign(target);
		  }
	  void allign(PVector target){
		  if(velocity.mag()>0){
			  float rot  = velocity.heading();
			  setOrientation(rot+PApplet.PI/2);
		  }
	  }
	  void allign(){
			setOrientation(velocity.heading() + PApplet.PI/2);
		}
	  void display() {
	    parent.pushMatrix();
	    parent.translate(position.x+600,position.y+400);
	    parent.rotate(getOrientation());
	    parent.beginShape();
	    parent.stroke(255,153,0);
	    parent.fill(255,153,0);
	  	parent.triangle(-8,-4,8,-4,0,-16);
	  	parent.ellipse(0, 0, 16, 16);
	  	parent.triangle(+8,+5,-8,+5,0,+18);
	  	parent.stroke(255,50,0);
	  	parent.fill(255,50,0);
	  	parent.triangle(+2,+10,-2,+10,0,-10);
	    parent.endShape();
	    parent.popMatrix();
	  }
}