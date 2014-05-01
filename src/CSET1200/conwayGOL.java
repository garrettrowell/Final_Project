package CSET1200;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class conwayGOL {

	static conwayGOL cgol = new conwayGOL();
	public Integer rows,cloumns,currentGen,maxGen;
	public String[][] current=null,next=null;
	
	public Integer getCurrentGen() {
		return currentGen;
	}
	public void setCurrentGen(Integer currentGen) {
		this.currentGen = currentGen;
	}
	public Integer getMaxGen() {
		return maxGen;
	}
	public void setMaxGen(Integer maxGen) {
		this.maxGen = maxGen;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getCloumns() {
		return cloumns;
	}
	public void setCloumns(Integer cloumns) {
		this.cloumns = cloumns;
	}
		
	public static void main(String[] args) {
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many generations would you like to run?");
		try {
			cgol.setMaxGen(Integer.parseInt(buffer.readLine()));
		} 
		catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (buffer != null)buffer.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		firstGen();	
		next();
	}
	
	public static void firstGen(){
		
		BufferedReader br = null;
		String[] in = null;
		int ints=0,lines=0;
		cgol.setCurrentGen(0);
		
		try {
			String CurrentLine; 
			br = new BufferedReader(new FileReader("/home/garrett/workspace_CSET1200/Final_Project/src/CSET1200/test2.txt"));
			while ((CurrentLine = br.readLine()) != null) {
				in=CurrentLine.split("");

				if (lines==0){
					for (int i=0;i<in.length;i++){
						if(in[i].matches("\\d"))
						{
							if(ints==0){
								cgol.setCloumns(Integer.parseInt(in[i]));
								ints++;
							}
							if(ints==1){
								cgol.setRows(Integer.parseInt(in[i]));
							}
						}
					}
				}
				
				if (lines==1){
					cgol.current = new String[cgol.getRows()][cgol.getCloumns()];
				}
				if(lines>=1){
					for (int i=0;i<in.length;i++){
						if (!in[i].equals("")){
								cgol.current[lines-1][i-1]=in[i];							
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
		System.out.println("Generation: "+cgol.getCurrentGen());
		for(int i=0;i<=(cgol.getRows()-1);i++){
			for(int j=0;j<=(cgol.getCloumns()-1);j++){
				System.out.print(cgol.current[i][j]);
				if (j==cgol.getCloumns()-1){
					System.out.print("\n");
				}
			}
		}
		cgol.setCurrentGen(cgol.getCurrentGen()+1);
	}

	public static void next (){
		for(cgol.getCurrentGen();cgol.getCurrentGen()<=cgol.getMaxGen();cgol.setCurrentGen(cgol.getCurrentGen()+1)){
			
		
		cgol.next = new String [cgol.getRows()][cgol.getCloumns()]; 
		for( int i=0; i<cgol.getRows(); i++ ) {
			for( int j=0; j<cgol.getCloumns(); j++ ) {
				cgol.next[i][j] = cgol.current[i][j];
				}
			} 
		
		for (int i = 0; i < cgol.getRows() ; i++){
			for (int j = 0 ; j < cgol.getCloumns() ; j++) {
				int n = neighbours(i,j);
				if (n > 3  ||  n < 2)
					cgol.next[i][j]=(" ");
				else if (n == 3)
					cgol.next[i][j]=("*");
				else
					cgol.next[i][j]=(cgol.current[i][j]);
				}
		}
		System.out.println("Generation: "+cgol.getCurrentGen());
		for(int i=0;i<=(cgol.getRows()-1);i++){
			for(int j=0;j<=(cgol.getCloumns()-1);j++){
				System.out.print(cgol.next[i][j]);
				cgol.current[i][j]=cgol.next[i][j];
				if (j==cgol.getCloumns()-1){
					System.out.print("\n");
					}
				}
			}
		}
	}
	public static int neighbours (int row, int col) {
		int acc=0;
		for ( int i = row -1; i <= row + 1 ; i++){
			for (int j = col -1 ; j <= col + 1 ; j++){
				try {
					if (cgol.current[i][j].equals("*") && (i != row || j!=col))
					{
						acc++;
					}          
				} 
				catch ( ArrayIndexOutOfBoundsException f){
					continue;
					}	
			}
		}
		  return acc;
	}
}
