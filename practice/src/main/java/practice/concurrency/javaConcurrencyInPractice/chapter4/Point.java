package practice.concurrency.javaConcurrencyInPractice.chapter4;

import practice.concurrency.javaConcurrencyInPractice.common.Immutable;

@Immutable
public class Point {
	public final int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
