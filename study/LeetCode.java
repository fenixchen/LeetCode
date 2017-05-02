package study;


public class LeetCode
{
	private static String solutionArray[] = {
			//"RemoveNthFromLast",
			//"ContainsDup",
			"KthSmallestInBst",
	};
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{		
		for (String s : solutionArray)
		{
			Class<?> solutionClass = Class.forName("study." + s);
			ISolution solution = (ISolution)solutionClass.newInstance();
			System.out.println(String.format("Running %s - %s", s, solution.getClass().getName()));
			solution.setup();
			solution.go();
		}
		System.out.println("Done");
	}
}