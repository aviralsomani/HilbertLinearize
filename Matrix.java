import java.util.*;

public class Matrix 
{
	private int numRows;
	private int numCols;
	private int[][] m;
	
	public Matrix(int nR, int nC)
	{
		numRows = nR;
		numCols = nC;
		m = new int[nR][nC];
	}
	
	public int numRows()
	{
		return numRows;
	}
	
	public int numCols()
	{
		return numCols;
	}
	
	public int get(int x, int y)
	{
		return m[x][y];
	}
	
	public String toString()
	{
		String out = "";
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				out = out + m[i][j] + "\t";
			}
			out = out + "\n";
		}
		return out;
	}
	
	public void set(int x, int y, int a)
	{
		m[x][y] = a;
	}
	
	public Matrix[] getQuadrants()
	{
		Matrix ret1 = new Matrix (numRows/2, numCols/2);
		Matrix ret2 = new Matrix (numRows/2, numCols/2);
		Matrix ret3 = new Matrix (numRows/2, numCols/2);
		Matrix ret4 = new Matrix (numRows/2, numCols/2);
		for (int i = 0; i < ret1.numRows(); i++)
		{
			for (int j = 0; j < ret1.numCols(); j++)
			{
				ret1.set(i, j, get(i, j));
			}
		}
		for (int i = 0; i < ret2.numRows(); i++)
		{
			for (int j = 0; j < ret1.numCols(); j++)
			{
				ret2.set(i, j, get(i + numRows/2, j));
			}
		}
		for (int i = 0; i < ret3.numRows(); i++)
		{
			for (int j = 0; j < ret1.numCols(); j++)
			{
				ret3.set(i, j, get(i, j + numCols/2));
			}
		}
		for (int i = 0; i < ret4.numRows(); i++)
		{
			for (int j = 0; j < ret1.numCols(); j++)
			{
				ret4.set(i, j, get(i + numRows/2, j + numCols/2));
			}
		}
		Matrix[] ret = {ret2, ret1, ret3, ret4};
		return ret;
	}
	public List<Integer> linearize()
	{
		List<Integer> ret = new ArrayList<Integer>();
		lHelper(this, ret);
		return ret;
	}
	public void lHelper(Matrix a, List<Integer> c)
	{
		if (a.numRows() == 4 && a.numCols() == 4)
		{
			Matrix[] quads = a.getQuadrants();
			c.add(quads[0].get(1, 0));
			c.add(quads[0].get(1, 1));
			c.add(quads[0].get(0, 1));
			c.add(quads[0].get(0, 0));
			
			c.add(quads[1].get(1, 0));
			c.add(quads[1].get(0, 0));
			c.add(quads[1].get(0, 1));
			c.add(quads[1].get(1, 1));
			
			c.add(quads[2].get(1, 0));
			c.add(quads[2].get(0, 0));
			c.add(quads[2].get(0, 1));
			c.add(quads[2].get(1, 1));
			
			c.add(quads[3].get(0, 1));
			c.add(quads[3].get(0, 0));
			c.add(quads[3].get(1, 0));
			c.add(quads[3].get(1, 1));
		}
		else
		{
			Matrix[] mat = a.getQuadrants();
			lHelper(mat[0].flipRight(),c);
			lHelper(mat[1],c);
			lHelper(mat[2],c);
			lHelper(mat[3].flipLeft(),c);
		}
	}
	public Matrix flipLeft()
	{
		Matrix ret = new Matrix(numRows, numCols);
		int cols = numCols;
		int rows = numRows;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				ret.set(j, i, get(i, j));
			}
		}
		return ret;
	}
	public Matrix flipRight()
	{
		Matrix ret = new Matrix(numRows, numCols);
		for (int i = numRows - 1; i >= 0; i--)
		{
			for (int j = numCols - 1; j >= 0; j--)
			{
				ret.set(j, i, get(numRows - i - 1, numCols - j - 1));
			}
		}
		return ret;
	}
}
