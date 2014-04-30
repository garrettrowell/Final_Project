package CSET1200;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class conwayGOL {
	
	public static void main(String[] args) {
		 
		BufferedReader br = null;
		String[] in = null;
		Integer rows=0,columns=0;
		int ints=0,lines=0;
		String [][] first = null;
		
 
		try {
			String CurrentLine; 
			br = new BufferedReader(new FileReader("/home/garrett/workspace_CSET1200/Final_Project/src/CSET1200/conway.text"));
			while ((CurrentLine = br.readLine()) != null) {
				in=CurrentLine.split("");

				if (lines==0){
					for (int i=0;i<in.length;i++){
						if(in[i].matches("\\d"))
						{
							if(ints==0){
								rows=Integer.parseInt(in[i]);
								ints++;
							}
							if(ints==1){
								columns=Integer.parseInt(in[i]);
							}
						}
					}
				}
				
				if (lines==1){
					first = new String[rows][columns];
				}
				
				if(lines>=1){
					for (int i=0;i<in.length;i++){
						if (!in[i].equals("")){
							first[i-1][lines-1]=in[i];
						}
					}	
				}
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//outputs first generation
		for(int i=0;i<=rows-1;i++){
			for(int j=0;j<=columns-1;j++){
				System.out.println(i+" "+j+" "+first[i][j]);
			}
		}
	}
}
