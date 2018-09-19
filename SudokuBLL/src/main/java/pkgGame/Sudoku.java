package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;
	
	
	public Sudoku() {
		super();
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	protected int[] getRegion(int iRegionNbr)
	{
		/*int[] a = super.getRow(0);
		int[] b = super.getRow(1);
		int[] c = super.getRow(2);*/
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		int[] c = {7,8,9};
		int[] region0 = {0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < 3; i++) {
			region0[i] = a[i]; 
		}
		for(int i = 3; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				region0[i] = b[j];
			}
		}
		for(int i = 6; i < 9; i++) {
			for(int j = 0; j < 3; j++) {
				region0[i] = c[j];
			}
		}
		return region0;
	}
	protected int[] getRegion(int Col, int Row)
	{
		
		return null;
	}
	protected boolean isSudoku()
	{
		return false;
	}
	protected boolean isPartialSudoku()
	{
		return false;
	}
	protected boolean isValueValid(int iValue, int Col, int Row)
	{
		return false;
	}
}

