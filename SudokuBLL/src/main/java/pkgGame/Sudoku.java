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
		int[] region = {0};
		if((Col==0 || Col==1 || Col==2) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(0);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(1);
		}
		if((Col==6 || Col==7 || Col==8) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(2);
		}
		if((Col==0 || Col==1 || Col==2) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(3);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(4);
		}
		if((Col==6 || Col==7 || Col==8) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(5);
		}
		if((Col==0 || Col==1 || Col==2) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(6);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(7);
		}
		if((Col==7 || Col==8 || Col==9) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(8);
		}
		return region;
	}
	protected boolean isPartialSudoku()
	{
		region0 = getRegion(0);
		region1 = getRegion(1);
		region2 = getRegion(2);
		region3 = getRegion(3);
		region4 = getRegion(4);
		region5 = getRegion(5);
		region6 = getRegion(6);
		region7 = getRegion(7);
		region8 = getRegion(8);
		if(region0 
		return true;
	}
	protected boolean isSudoku()
	{
		return true;
	}
	protected boolean isValueValid(int iValue, int Col, int Row)
	{
		return false;
	}
}

