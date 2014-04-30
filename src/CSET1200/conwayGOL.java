package CSET1200;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class conwayGOL {

	public Integer rows,cloumns;
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
		Integer gen=null;
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many generations would you like to run?");
		try {
			gen=Integer.parseInt(buffer.readLine());
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
		System.out.println(gen);
		firstGen();		
	}
	
	public static void firstGen(){
		conwayGOL cgol = new conwayGOL();
		BufferedReader br = null;
		String[] in = null;
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
								cgol.setRows(Integer.parseInt(in[i]));
								ints++;
							}
							if(ints==1){
								cgol.setCloumns(Integer.parseInt(in[i]));
							}
						}
					}
				}
				
				if (lines==1){
					first = new String[cgol.getRows()][cgol.getCloumns()];
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
		for(int i=0;i<=cgol.getRows()-1;i++){
			for(int j=0;j<=cgol.getCloumns()-1;j++){
				System.out.println(i+" "+j+" "+first[i][j]);
			}
		}
	}
}
