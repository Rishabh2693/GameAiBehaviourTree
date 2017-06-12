package homework3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

class Potter extends SteeringParams{
	  PApplet parent;
	  float MaxAcc;
	  float maxSpeed;
	  boolean caught;
	  ArrayList<PVector> breadcrumb = new ArrayList<PVector>();
	  PVector dest;	 
	  LinkedList<Node> path;
	  PVector d;	 
	  CustomShape c;
	  Potter(float x, float y,PApplet p,CustomShape c) {
	    acceleration = new PVector(0,0);
	    velocity = new PVector(0,0);
	    position = new PVector(x,y);
	    maxSpeed = 7;
	    MaxAcc = (float) .2;
	    parent = p;
	    dest = new PVector(0,0);
	    path=new LinkedList<Node>();
	    d = new PVector(0,0);
	    this.c = c;
	    caught = false;
	  }
	 
	  void update() {
		position.add(velocity);  
	    velocity.add(acceleration);
	    velocity.limit(maxSpeed);
	    acceleration.mult(0);
	  }
	  
	  void wander1() {
		    
            caught = true;
		    Graph g = new MonsterGraph();
			Astar a = new Astar(g);
		    float sourcex = position.x+800;
		  	float sourcey = position.y+600;
		    Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	
		    List<Node> temp = new ArrayList<Node>();
		    for(int i = 0;i<g.getEdges().size();i++){
		    	if(g.getEdges().get(i).getSource()==source)
		    		temp.add(g.getEdges().get(i).getGoal());
		    }
		    
		    int rand1;
		    rand1 = (int)Math.floor(Math.random() * (temp.size()-0.01)); 
		//    System.out.println(temp.size());
		 //   System.out.println(rand1);
		    path = a.execute(source, temp.get(rand1));
		    if(path == null)
		    	caught = true;
		    path.removeFirst();
		    if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+600)/40)*30+parent.floor((position.x+800)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-800,path.getFirst().getY()+20-600);
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
		    
	  void wander() {
		    
		    Graph g = new MonsterGraph();
			Astar a = new Astar(g);
		    float sourcex = position.x+800;
		  	float sourcey = position.y+600;
		  	if((sourcex>1200||sourcex<0)||(sourcey>800||sourcey<0))
		  		return;
		    Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
		  	
		    List<Node> temp = new ArrayList<Node>();
		    for(int i = 0;i<g.getNodes().size();i++){
		    	if(!MonsterGraph.obs.contains(i)&&source.getId()!=i)
		    		temp.add(g.getNodes().get(i));
		    	
		    }
		    
		    int rand1;
		    rand1 = (int)Math.floor(Math.random() * (temp.size()-0.01)); 
	//	    System.out.println(temp.size());
	//	    System.out.println(rand1);
		   
		    if(path == null)
		    	caught = true;
		    if(path.size()==0)
		    	path = a.execute(source, temp.get(rand1));
		  
		    if(path!=null&&path.size()>0){
				  if((parent.floor((position.y+600)/40)*30+parent.floor((position.x+800)/40))!=path.getFirst().getId()){
					  d = new PVector(path.getFirst().getX()+20-800,path.getFirst().getY()+20-600);
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
	  
		    
	  void allign(){
			setOrientation(velocity.heading() + PApplet.PI/2);
		}
	  void pathFollow(){
		  float desty, destx;
			 Graph g = new MonsterGraph();
			 Astar a = new Astar(g);
			  float sourcex = position.x+800;
			  float sourcey = position.y+600;
			// if(parent.mousePressed==true)
			// {
			  //	dest = new PVector(parent.mouseX-800,parent.mouseY-600);
			  	sourcex = position.x+800;
			  	sourcey = position.y+600;
			  	desty = c.position.y+400;
			  	destx = c.position.x+600;
			  	if(sourcex<0||sourcex>1200||sourcey<0||sourcey>800)
			  		return;
			  	if(destx<0||destx>1200||desty<0||desty>800)
			  		return;
			  	Node source = g.getNodes().get( (parent.floor(sourcey/40)*30+parent.floor(sourcex/40)));
			  	Node desti = g.getNodes().get( (parent.floor(desty/40)*30+parent.floor(destx/40)));
			  	path = a.execute(source, desti);
			  //	System.out.println(source+" "+path);
			 // }
		   sourcex = position.x+800;
		   sourcey = position.y+600;
		   if(path == null){
		   		caught = true;
		   		return;
		   }
		   path.removeFirst();
		   	
			  if(path!=null&&path.size()>0){
					  if((parent.floor((position.y+600)/40)*30+parent.floor((position.x+800)/40))!=path.getFirst().getId()){
						  d = new PVector(path.getFirst().getX()+20-800,path.getFirst().getY()+20-600);
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
			  breadcrumb.add(new PVector(position.x+800,position.y+600));
		  }
		  for(PVector a:breadcrumb){
			  parent.beginShape();
			  parent.fill(255,0,0);
			  parent.ellipse(a.x, a.y, 10, 10);
			  parent.endShape();
		  }
	  }
	  
	  void pursue(CustomShape P){
		  PVector distance = PVector.sub(P.position, position);
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
	  
	  void display() {
	    parent.pushMatrix();
	    parent.translate(position.x+800,position.y+600);
	    parent.rotate(getOrientation());
	    parent.beginShape();
	    parent.stroke(200,200,255);
	    parent.fill(200,200,255);
	  	parent.triangle(-12,-5,12,-5,0,-25);
	  	parent.ellipse(0, 0, 25, 25);
	  	parent.triangle(+11,+6,-11,+6,0,+30);
	  	parent.stroke(50);
	  	parent.fill(50);
	  	parent.triangle(+2,+10,-2,+10,0,-10);
	    parent.endShape();
	    parent.popMatrix();
	  }
}