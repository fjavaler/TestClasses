package midterm2;

import java.util.StringTokenizer;

public class TestClass
{

	public static void main(String[] args)
	{
		String line1 = new String("c = 1 + 2 + 3") ;
	    StringTokenizer tok = new StringTokenizer(line1, "+=");
	    String foo = tok.nextToken();
	    String bar = tok.nextToken();
	    System.out.println("foo = " + foo + "\nbar = " + bar);
	}

}
