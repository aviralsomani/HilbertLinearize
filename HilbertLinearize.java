import java.util.*;

public class HilbertLinearize 
{
	public static void main(String[] args)
	{
		Matrix a = new Matrix(8, 8);
		int c = 1;
		for (int i = 0; i < a.numRows(); i++)
		{
			for (int j = 0; j < a.numCols(); j++)
			{	
				a.set(i, j, c);
				c++;
			}
		}
		System.out.println(a);
		long startTime;
		System.out.println(a.linearize());
		long endTime;
		/*String out = "";
		for (int x = 2; x < 13; x++)
		{
			int f = (int)(Math.pow(2, x));
			a = new Matrix(f, f);
			c = 1;
			for (int num = 0; num < 10; num++)
				{
				for (int i = 0; i < a.numRows(); i++)
				{
					for (int j = 0; j < a.numCols(); j++)
					{	
						a.set(i, j, c);
						c++;
					}
				}
			startTime = System.currentTimeMillis();
			a.linearize();
			endTime = System.currentTimeMillis();
			out = out + "Dimension: " + f + ": \t\tRuntime: " + (endTime - startTime) + "\n";
			}
		}
		System.out.println(out);*/
	}
}
