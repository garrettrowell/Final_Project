package CSET1200;

public class Matrix {

	private Integer rows;
	private Integer columns;
	private String data[][];
	
	public Matrix(Integer rows, Integer columns){
		this.rows = rows;
		this.columns = columns;
		data = new String[rows][columns];
		}

}
