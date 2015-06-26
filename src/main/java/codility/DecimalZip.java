package codility;

import java.util.Stack;

public class DecimalZip
{
	public int solution(int a, int b)
	{
		long result = 0;
		Stack<Integer> digitsA = digits(a);
		Stack<Integer> digitsB = digits(b);

		while (!digitsA.isEmpty() || !digitsB.isEmpty()) {
			if (!digitsA.isEmpty()) {
				result = result * 10 + digitsA.pop();
			}
			if (!digitsB.isEmpty()) {
				result = result * 10 + digitsB.pop();
			}
			if (result > 100_000_000) {
				return -1;
			}
		}
		return (int) result;
	}

	private Stack<Integer> digits(int a)
	{
		Stack<Integer> digits = new Stack<Integer>();
		if (a == 0) {
			digits.push(0);
		} else
			while (a > 0) {
				digits.push(a % 10);
				a = a / 10;
			}
		return digits;
	}
}
