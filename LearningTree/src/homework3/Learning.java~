package homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Learning {

	public List<Data> data;
	public List<Integer> attr; 
	Learning(){
		data = new ArrayList<Data>();
		attr = new ArrayList<Integer>();
		attr.add(1);
		attr.add(2);
		attr.add(3);
		attr.add(4);
	}
	
	public double gain(double ep,double ec){
		return ep-ec;
	}
	
	public double currNodeEntophy(int c[], int a[])
	  {
			int i =0;
			int count0=0, count1=0;
			int[] prob_elem_0 = new int[3];int[] prob_elem_1 = new int[3];
			prob_elem_0[0]=0;
			prob_elem_0[1]=0;
			prob_elem_0[2]=0;
			
			prob_elem_1[0]=0;
			prob_elem_1[1]=0;
			prob_elem_1[2]=0;
			while(i<c.length)
			{
				//System.out.println(c[i]);
				if(a[i]==0)
				{
					prob_elem_0[c[i]-1]++;
					count0++;
				}
				else
				{
					count1++;
					prob_elem_1[c[i]-1]++;
				}
				i++;
			}
			double entropy0=entropy(prob_elem_0);
			double entropy1=entropy(prob_elem_1);
			
			double entropy = (count0*entropy0+count1*entropy1)/(count0+count1);
			return entropy;
	  }
	
		public double entropy(int c[])
		  {
			  double entropy=0;
			
			  int i=0;
			  int sum=0;
			  double frac;
			  while(i<c.length)
			  {
				 sum=sum+c[i];
				 i++;
			  }
			  i=0;
			  while(i<c.length)
			  {
				  if(c[i]==0){
					  i++;
					  continue;
				  }
				  frac=(double)c[i]/sum;
			  
				  entropy=entropy-frac*(Math.log(frac)/Math.log(2));
				  i++;
			  }
			 // System.out.println(entropy);
			  return entropy;
		  }
		
	public void dTree(){
		try {
    		String path = new File("").getAbsolutePath();                        
			File file = new File(path + "/src/nodes.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			Data temp;
			while ((line = bufferedReader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
			   // int j=0; 
			   // System.out.println(line);
			    String []t = new String[6];
				for(int j=0;j<6;j++) {
			        t[j]=st.nextToken();
			     //   System.out.println(t[j]);
			     }
				temp = new Data(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),Integer.parseInt(t[3]),Integer.parseInt(t[4]),Integer.parseInt(t[5]));
	            data.add(temp);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int GiniIndex = 0;
		float MaxGiniGain = 0;
		
		for(int i=0;i<data.size();i++){
		//	if (giniGain(data))
		}
		
	}
	public static void main(String[] args) {
		Learning l = new Learning();
		l.dTree();
		int [] c = new int[3];
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<l.data.size();i++){
			if(l.data.get(i).s==1)
				c[0]++;
			if(l.data.get(i).s==2)
				c[1]++;
			if(l.data.get(i).s==3)
				c[2]++;
		}
		
		double Enttree = l.entropy(c);
		int [] c1 = new int [l.data.size()];
		int [] c2 = new int [l.data.size()];
		int [] c3 = new int [l.data.size()];
		int [] c4 = new int [l.data.size()];
		int [] c5 = new int [l.data.size()];
		int [] c6 = new int [l.data.size()];
		for(int i=0;i<l.data.size();i++){
			c1[i] = l.data.get(i).diffx;
			c2[i] = l.data.get(i).diffy;
			c3[i] = l.data.get(i).csx;
			c4[i] = l.data.get(i).csy;
			c5[i] = l.data.get(i).caught;
			c6[i] = l.data.get(i).s;
		}
		double entdiffx = l.gain(Enttree, l.currNodeEntophy(c6, c1));
		double entdiffy = l.gain(Enttree, l.currNodeEntophy(c6, c2));
		double entcsx = l.gain(Enttree, l.currNodeEntophy(c6, c3));
		double entcsy = l.gain(Enttree, l.currNodeEntophy(c6, c4));
		////////////////////////////
		double entcaught = l.gain(Enttree, l.currNodeEntophy(c6, c5));
		System.out.println(entdiffx);
		System.out.println(entdiffy);
		System.out.println(entcsx);
		System.out.println(entcsy);
		System.out.println(entcaught);
		// Root is Caught
		System.out.println("Root is caught && caught == 1 is pure, that is action reset");
		
		int caught0=0;
		List<Data> caughtt = new ArrayList<Data>();
		for(int i=0;i<l.data.size();i++)
			if(l.data.get(i).caught == 0)
				{caught0++;
				 caughtt.add(l.data.get(i));
				}
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<caughtt.size();i++){
			if(caughtt.get(i).s==1)
				c[0]++;
			if(caughtt.get(i).s==2)
				c[1]++;
			if(caughtt.get(i).s==3)
				c[2]++;
		}
		double ncaught = l.entropy(c);
		int [] cc1 = new int [caughtt.size()];
		int [] cc2 = new int [caughtt.size()];
		int [] cc3 = new int [caughtt.size()];
		int [] cc4 = new int [caughtt.size()];
		int [] cc6 = new int [caughtt.size()];
		for(int i=0;i<caughtt.size();i++){
			cc1[i] = caughtt.get(i).diffx;
			cc2[i] = caughtt.get(i).diffy;
			cc3[i] = caughtt.get(i).csx;
			cc4[i] = caughtt.get(i).csy;
			cc6[i] = caughtt.get(i).s;
		}
		double cdiffx = l.gain(Enttree, l.currNodeEntophy(cc6, cc1));
		double cdiffy = l.gain(Enttree, l.currNodeEntophy(cc6, cc2));
		double ccsx = l.gain(Enttree, l.currNodeEntophy(cc6, cc3));
		double ccsy = l.gain(Enttree, l.currNodeEntophy(cc6, cc4));
		
		System.out.println(cdiffx);
		System.out.println(cdiffy);
		System.out.println(ccsx);
		System.out.println(ccsy);
		System.out.println("When caught = 0, next node is cSx");
		
		
		int cSx0=0;
		int cSx1=1;
		List<Data> csX0 = new ArrayList<Data>();
		List<Data> csX1 = new ArrayList<Data>();
		for(int i=0;i<l.data.size();i++)
			if(l.data.get(i).caught == 0&&l.data.get(i).csx == 0)
				{cSx0++;
				 csX0.add(l.data.get(i));
				}else if(l.data.get(i).caught == 0&&l.data.get(i).csx == 1){
					cSx1++;
					 csX1.add(l.data.get(i));
				}
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csX0.size();i++){
			if(csX0.get(i).s==1)
				c[0]++;
			if(csX0.get(i).s==2)
				c[1]++;
			if(csX0.get(i).s==3)
				c[2]++;
		}
		int [] ccx01 = new int [csX0.size()];
		int [] ccx02 = new int [csX0.size()];
		int [] ccx04 = new int [csX0.size()];
		int [] ccx06 = new int [csX0.size()];
		for(int i=0;i<csX0.size();i++){
			ccx01[i] = csX0.get(i).diffx;
			ccx02[i] = csX0.get(i).diffy;
			ccx04[i] = csX0.get(i).csy;
			ccx06[i] = csX0.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxx0 = l.gain(Enttree, l.currNodeEntophy(ccx06, ccx01));
		double cdiffyx0 = l.gain(Enttree, l.currNodeEntophy(ccx06, ccx02));
		double ccsyx0 = l.gain(Enttree, l.currNodeEntophy(ccx06, ccx04));
		
		System.out.println(cdiffxx0);
		System.out.println(cdiffyx0);
		System.out.println(ccsyx0);
		System.out.println("When caught = 0, and  cSx=0 max gain is disty");
		
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csX1.size();i++){
			if(csX1.get(i).s==1)
				c[0]++;
			if(csX1.get(i).s==2)
				c[1]++;
			if(csX1.get(i).s==3)
				c[2]++;
		}
		int [] ccx11 = new int [csX1.size()];
		int [] ccx12 = new int [csX1.size()];
		int [] ccx14 = new int [csX1.size()];
		int [] ccx16 = new int [csX1.size()];
		for(int i=0;i<csX1.size();i++){
			ccx11[i] = csX1.get(i).diffx;
			ccx12[i] = csX1.get(i).diffy;
			ccx14[i] = csX1.get(i).csy;
			ccx16[i] = csX1.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxx1 = l.gain(Enttree, l.currNodeEntophy(ccx16, ccx11));
		double cdiffyx1 = l.gain(Enttree, l.currNodeEntophy(ccx16, ccx12));
		double ccsyx1 = l.gain(Enttree, l.currNodeEntophy(ccx16, ccx14));
		
		System.out.println(cdiffxx1);
		System.out.println(cdiffyx1);
		System.out.println(ccsyx1);
		System.out.println("When caught = 0, and  cSx=1 max gain is csy");
		////////////////////////////////////////////////////////////////////////////
		
	
		/////////////////////////////////////////////////////////////////////////////
		
		int cSxy0=0;
		int cSxy1=1;
		List<Data> csXY0 = new ArrayList<Data>();
		List<Data> csXY1 = new ArrayList<Data>();
		for(int i=0;i<l.data.size();i++)
			if(l.data.get(i).caught == 0&&l.data.get(i).csx == 1&&l.data.get(i).csy == 0)
				{cSxy0++;
				 csXY0.add(l.data.get(i));
				}else if(l.data.get(i).caught == 0&&l.data.get(i).csx == 1&&l.data.get(i).csy == 1){
					cSxy1++;
					 csXY1.add(l.data.get(i));
				}
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXY0.size();i++){
			if(csXY0.get(i).s==1)
				c[0]++;
			if(csXY0.get(i).s==2)
				c[1]++;
			if(csXY0.get(i).s==3)
				c[2]++;
		}
		int [] ccxy01 = new int [csXY0.size()];
		int [] ccxy02 = new int [csXY0.size()];
		int [] ccxy06 = new int [csXY0.size()];
		for(int i=0;i<csXY0.size();i++){
			ccxy01[i] = csXY0.get(i).diffx;
			ccxy02[i] = csXY0.get(i).diffy;
			ccxy06[i] = csXY0.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxy0 = l.gain(Enttree, l.currNodeEntophy(ccxy06, ccxy01));
		double cdiffyxy0 = l.gain(Enttree, l.currNodeEntophy(ccxy06, ccxy02));
		
		System.out.println(cdiffxxy0);
		System.out.println(cdiffyxy0);
		System.out.println("When caught = 0, and  cSx=1 max gain is csy=0 then disty");
		
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXY1.size();i++){
			if(csXY1.get(i).s==1)
				c[0]++;
			if(csXY1.get(i).s==2)
				c[1]++;
			if(csXY1.get(i).s==3)
				c[2]++;
		}
		int [] ccxy11 = new int [csXY1.size()];
		int [] ccxy12 = new int [csXY1.size()];
		int [] ccxy16 = new int [csXY1.size()];
		for(int i=0;i<csXY1.size();i++){
			ccxy11[i] = csXY1.get(i).diffx;
			ccxy12[i] = csXY1.get(i).diffy;
			ccxy16[i] = csXY1.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxy1 = l.gain(Enttree, l.currNodeEntophy(ccxy16, ccxy11));
		double cdiffyxy1 = l.gain(Enttree, l.currNodeEntophy(ccxy16, ccxy12));
		
		System.out.println(cdiffxxy1);
		System.out.println(cdiffyxy1);
		System.out.println("When caught = 0, and  cSx=1 max gain is csy=1 then wander");
		
		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		
		
		int cSxdy0=0;
		int cSxdy1=1;
		List<Data> csXdY0 = new ArrayList<Data>();
		List<Data> csXdY1 = new ArrayList<Data>();
		for(int i=0;i<l.data.size();i++)
			if(l.data.get(i).caught == 0&&l.data.get(i).csx == 0&&l.data.get(i).diffy == 0)
				{cSxdy0++;
				 csXdY0.add(l.data.get(i));
				}else if(l.data.get(i).caught == 0&&l.data.get(i).csx == 0&&l.data.get(i).diffy == 1){
					cSxdy1++;
					 csXdY1.add(l.data.get(i));
				}
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXdY0.size();i++){
			if(csXdY0.get(i).s==1)
				c[0]++;
			if(csXdY0.get(i).s==2)
				c[1]++;
			if(csXdY0.get(i).s==3)
				c[2]++;
		}
		int [] ccxdy01 = new int [csXdY0.size()];
		int [] ccxdy04 = new int [csXdY0.size()];
		int [] ccxdy06 = new int [csXdY0.size()];
		for(int i=0;i<csXdY0.size();i++){
			ccxdy01[i] = csXdY0.get(i).diffx;
			ccxdy04[i] = csXdY0.get(i).csy;
			ccxdy06[i] = csXdY0.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxdy0 = l.gain(Enttree, l.currNodeEntophy(ccxy06, ccxdy01));
		double cdiffyxdy0 = l.gain(Enttree, l.currNodeEntophy(ccxy06, ccxdy04));
		
		System.out.println(cdiffxxdy0);
		System.out.println(cdiffyxdy0);
		System.out.println("When caught = 0, and  cSx=0 max gain is disty=0 then PF");
		
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXdY1.size();i++){
			if(csXdY1.get(i).s==1)
				c[0]++;
			if(csXdY1.get(i).s==2)
				c[1]++;
			if(csXdY1.get(i).s==3)
				c[2]++;
		}
		int [] ccxdy11 = new int [csXdY1.size()];
		int [] ccxdy14 = new int [csXdY1.size()];
		int [] ccxdy16 = new int [csXdY1.size()];
		for(int i=0;i<csXdY1.size();i++){
			ccxdy11[i] = csXdY1.get(i).diffx;
			ccxdy14[i] = csXdY1.get(i).csy;
			ccxdy16[i] = csXdY1.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxdy1 = l.gain(Enttree, l.currNodeEntophy(ccxdy16, ccxdy11));
		double cdiffyxdy1 = l.gain(Enttree, l.currNodeEntophy(ccxdy16, ccxdy14));
		
		System.out.println(cdiffxxdy1);
		System.out.println(cdiffyxdy1);
		System.out.println("When caught = 0, and  cSx=0 max gain is disty=1 then Wander");
		////////////////
		///////////////////////////
		//////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		
		int cSxyy0=0;
		int cSxyy1=1;
		List<Data> csXYy0 = new ArrayList<Data>();
		List<Data> csXYy1 = new ArrayList<Data>();
		for(int i=0;i<l.data.size();i++)
			if(l.data.get(i).caught == 0&&l.data.get(i).csx == 1&&l.data.get(i).csy == 0&&l.data.get(i).diffy == 0)
				{cSxyy0++;
				 csXYy0.add(l.data.get(i));
				}else if(l.data.get(i).caught == 0&&l.data.get(i).csx == 1&&l.data.get(i).csy == 0&&l.data.get(i).diffy == 1){
					cSxyy1++;
					 csXYy1.add(l.data.get(i));
				}
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXYy0.size();i++){
			if(csXYy0.get(i).s==1)
				c[0]++;
			if(csXYy0.get(i).s==2)
				c[1]++;
			if(csXYy0.get(i).s==3)
				c[2]++;
		}
		int [] ccxyy01 = new int [csXYy0.size()];
		int [] ccxyy02 = new int [csXYy0.size()];
		int [] ccxyy06 = new int [csXYy0.size()];
		for(int i=0;i<csXYy0.size();i++){
			ccxyy01[i] = csXYy0.get(i).diffx;
			ccxyy02[i] = csXYy0.get(i).diffy;
			ccxyy06[i] = csXYy0.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxyy0 = l.gain(Enttree, l.currNodeEntophy(ccxyy06, ccxyy01));
		double cdiffyxyy0 = l.gain(Enttree, l.currNodeEntophy(ccxyy06, ccxyy02));
		
		System.out.println(cdiffxxyy0);
		System.out.println(cdiffyxyy0);
		System.out.println("When caught = 0, and  cSx=1 max gain is csy=0 then disty = 0 then PF");
		
		c = new int[3];
		
		c[0]=0;
		c[1]=0;
		c[2]=0;
		for(int i=0;i<csXYy1.size();i++){
			if(csXYy1.get(i).s==1)
				c[0]++;
			if(csXYy1.get(i).s==2)
				c[1]++;
			if(csXYy1.get(i).s==3)
				c[2]++;
		}
		int [] ccxyy11 = new int [csXYy1.size()];
		int [] ccxyy12 = new int [csXYy1.size()];
		int [] ccxyy16 = new int [csXYy1.size()];
		for(int i=0;i<csXYy1.size();i++){
			ccxyy11[i] = csXYy1.get(i).diffx;
			ccxyy12[i] = csXYy1.get(i).diffy;
			ccxyy16[i] = csXYy1.get(i).s;
		}
		//System.out.println(csX0.size());
		double cdiffxxyy1 = l.gain(Enttree, l.currNodeEntophy(ccxyy16, ccxyy11));
		double cdiffyxyy1 = l.gain(Enttree, l.currNodeEntophy(ccxyy16, ccxyy12));
		
		System.out.println(cdiffxxyy1);
		System.out.println(cdiffyxyy1);
		System.out.println("When caught = 0, and  cSx=1 max gain is csy=0 && dist y = 1 then Wander ");
		
		
		
		
		
		
	}

}
