package codility;

import java.util.Stack;

public class DecimalZip
{
	public int solution(int a, int b)
	{
		int result = 0;
		Stack<Integer> digitsA = new Stack<Integer>();
		Stack<Integer> digitsB = new Stack<Integer>();

		if (a == 0) {
			digitsA.push(0);
		} else
			while (a > 0) {
				digitsA.push(a % 10);
				a = a / 10;
			}

		if (b == 0) {
			digitsB.push(0);
		} else
			while (b > 0) {
				digitsB.push(b % 10);
				b = b / 10;
			}

		while (!digitsA.isEmpty() || !digitsB.isEmpty()) {
			if (result >= 100_000_000) {
				return -1;
			}
			if (!digitsA.isEmpty()) {
				result = result * 10 + digitsA.pop();
				if (result > 100_000_000) {
					return -1;
				}
			}
			if (!digitsB.isEmpty()) {
				result = result * 10 + digitsB.pop();
				if (result > 100_000_000) {
					return -1;
				}
			}
		}
		return result;
	}
}
