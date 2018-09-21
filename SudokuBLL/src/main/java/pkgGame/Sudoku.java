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
	protected int[] getRegion(int r)
	{
		int[] reg = new int[super.getLatinSquare().length];
		
		int i = (r % iSqrtSize) * iSqrtSize;
		int j = (r / iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;
		int iCnt = 0;
		
		for (; j < jMax; j++) {
			for(i = (r % iSqrtSize) * iSqrtSize; i < iMax; i++) {
				System.out.println("J: " + j + "  " + "I: " + i );
				
				reg[iCnt++] = super.getLatinSquare()[j][i];
			}
		}
		return reg;
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

