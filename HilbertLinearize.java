import java.util.*;

public class HilbertLinearize 
{
	public static void main(String[] args)
	{
		Matrix a = new Matrix(8, 8); 			//This implementation can handle from 2^2 x 2^2 matrix to a 2^13 x 2^13 matrix
		int c = 1;
		for (int i = 0; i < a.numRows(); i++)		//Creating a matrix to test the linearize method with
		{
			for (int j = 0; j < a.numCols(); j++)
			{	
				a.set(i, j, c);
				c++;
			}
		}
		System.out.println(a);
		System.out.println(a.linearize());
	}
}
