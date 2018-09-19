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
		int[] a = super.getRow(0);
		int[] b = super.getRow(1);
		int[] c = super.getRow(2);
		int[] region = {0};
		
		if(iRegionNbr == 0) {
		for(int i = 0; i < 3; i++) {
			region[i] = a[i]; 
		}
		for(int i = 3; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				region[i] = b[j];
			}
		}
		for(int i = 6; i < 9; i++) {
			for(int j = 0; j < 3; j++) {
				region[i] = c[j];
				}
		}
		}
		if(iRegionNbr == 1) {
			for(int i = 0; i < 3; i++) {
				for(int j = 3; j < 6; j++) {
				region[i] = a[j]; 
				}
			}
			for(int i = 3; i < 6; i++) {
				for(int j = 3; j < 6; j++) {
					region[i] = b[j];
				}
			}
			for(int i = 6; i < 9; i++) {
				for(int j = 3; j < 6; j++) {
					region[i] = c[j];
				}
			}
			}
		return region;
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

