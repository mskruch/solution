package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.DecimalZip;

public class DecimalZipTest
{

	@Test
	public void test()
	{
		assertEquals(5162, new DecimalZip().solution(56, 12));
		assertEquals(16273845, new DecimalZip().solution(12345, 678));
		assertEquals(16273890, new DecimalZip().solution(123, 67890));
		assertEquals(0, new DecimalZip().solution(0, 0));
		assertEquals(100_000_000, new DecimalZip().solution(10_000_000, 0));
		assertEquals(-1, new DecimalZip().solution(10_000_000, 1));
		assertEquals(-1, new DecimalZip().solution(90_000_000, 0));
		assertEquals(-1, new DecimalZip().solution(100_000_000, 0));
		assertEquals(1100, new DecimalZip().solution(10, 10));
	}

}
