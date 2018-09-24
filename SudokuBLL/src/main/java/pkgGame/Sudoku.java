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
		int r = (Col / iSqrtSize) + ((Row / iSqrtSize) * iSqrtSize);
		return getRegion(r);
	}
	protected boolean isPartialSudoku()
	{
		for(int i = 0; i < 9; i++) {
			if(hasDuplicates(getRegion(i)) == false) {
				for(int j = 0; j < 9; j++) {
					if(hasAllValues(getRow(0), getRegion(j))) {
						return true;
					}
				}
			}
		}
		return false;
	}
		protected boolean isSudoku()
	{
		if(ContainsZero() == false) {
			if(isPartialSudoku() == true) {
				for(int i=0; i<9; i++) {
					hasAllValues(getRow(i),getColumn(i));
				
				}
			}
		}
		return false;
	}
		protected boolean isValueValid(int iValue, int Col, int Row)
	{
		int[] thisRow = getRow(Row);
		int[] thisCol = getColumn(Col);
		if(doesElementExist(thisCol, iValue) && doesElementExist(thisRow, iValue)) {
			return false;
		}
		else {
			return true;
		}
	}
}

