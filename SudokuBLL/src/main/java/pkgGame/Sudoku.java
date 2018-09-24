package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;
	
	
	public Sudoku(int iSize) {
		double SqrtSize = Math.sqrt(iSize);
		double sqrtSize = Math.round(SqrtSize);
		this.iSize = iSize;
		try {
			if(SqrtSize == sqrtSize) {
			this.iSqrtSize = (int)SqrtSize;
			}
			/*if(iSize % SqrtSize == 0) {
				this.iSize = iSize;
				this.iSqrtSize = (int)SqrtSize;
			}*/
		}
		catch(Exception e) {
			throw e;
		}
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	public int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	public int[] getRegion(int r)
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
	public int[] getRegion(int Col, int Row)
	{
		int r = (Col / iSqrtSize) + ((Row / iSqrtSize) * iSqrtSize);
		return getRegion(r);
	}
	public boolean isPartialSudoku()
	{
		for(int i = 0; i < iSize; i++) {
			if(hasDuplicates(getRegion(i)) == false) {
				for(int j = 0; j < iSize; j++) {
					if(hasAllValues(getRow(0), getRegion(j))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean isSudoku()
	{
		if(ContainsZero() == false) {
			if(isPartialSudoku() == true) {
				for(int i=0; i<iSize; i++) {
					hasAllValues(getRow(i),getColumn(i));
				
				}
			}
		}
		return false;
	}
	public boolean isValueValid(int iValue, int Col, int Row)
	{
		int[] thisRow = getRow(Row);
		int[] thisCol = getColumn(Col);
		if(hasDuplicates(thisCol) || hasDuplicates(thisRow)){
			return false;
		}
		if(doesElementExist(thisCol, iValue) && doesElementExist(thisRow, iValue)) {
			return false;
		}
		else {
			return true;
		}
	}
}

