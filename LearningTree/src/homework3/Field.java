package homework3;

import java.io.File;

import processing.core.PApplet;
import processing.core.PImage;

public class Field {
	PApplet parent;
	Field(PApplet p){
		parent = p;
	}
	
	void diplayRoom(){
		parent.pushMatrix();
	    parent.beginShape();
	    parent.fill(100,100,100);
	    for(int i=0;i<30;i++)
	    	parent.rect(0+40*i, 0, 40, 40);
	    for(int i=0;i<30;i++)
	    	parent.rect(0+40*i, 760, 40, 40);
	    for(int i=0;i<18;i++)
	    	parent.rect(1160,40+40*i, 40, 40);
	    for(int i=0;i<18;i++)
	    	parent.rect(0, 40+40*i, 40, 40);
	    
	    for(int i=0;i<10;i++)
	    	parent.rect(640, 400+40*i, 40, 40);
	    for(int i=0;i<10;i++)
	    	parent.rect(40*i, 360, 40, 40);
	    for(int i=0;i<10;i++)
	    	parent.rect(520, 0+40*i, 40, 40);
	    for(int i=0;i<10;i++)
	    	parent.rect(1200-40*i, 280, 40, 40);
	    
	    parent.fill(0,255,0);
	    for(int i=0;i<3;i++){
	    	for(int j=0;j<4;j++){
	    		parent.rect(920+40*i, 480+40*j, 40, 40);
	    		parent.rect(240+40*i, 480+40*j, 40, 40);
	    		parent.rect(240+40*i, 120+40*j, 40, 40);
	    	}
	    	parent.rect(920+40*i, 120, 40, 40);
	    	parent.rect(920+40*i, 160, 40, 40);
	    }
	    parent.stroke(0);
	 //   for(int i=0;i<30;i++){
	  //  	parent.rect(i*40, 0, 2, 800);
	  //  }
	   // for(int i=0;i<20;i++){
	   // 	parent.rect(0, i*40, 1200, 2);
	    //}
	    //Character Snitch
	    //Monster Seeker
	    
	  	parent.endShape();
	    parent.popMatrix();
	}

}
