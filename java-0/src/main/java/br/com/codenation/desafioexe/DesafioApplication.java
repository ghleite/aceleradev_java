package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> fibonacciSequence = new ArrayList<>();
		fibonacciSequence.add(0);
		fibonacciSequence.add(1);

		for (int i = 2; i < 15; ++i){
			int nextElement;
			nextElement = fibonacciSequence.get(i-2) + fibonacciSequence.get(i-1);
			fibonacciSequence.add(nextElement);
		}

		return fibonacciSequence;
	}

	public static Boolean isFibonacci(Integer a) {

		int increment = 2;
		int nextElement;
		List<Integer> fibonacciSequence = new ArrayList<>();
		fibonacciSequence.add(0);
		fibonacciSequence.add(1);

		do {
			nextElement = fibonacciSequence.get(increment-2) + fibonacciSequence.get(increment-1);
			fibonacciSequence.add(nextElement);

			if(a == 0 || a == 1 || a == nextElement)
				return true;

			++increment;

		} while (a > nextElement);

		return false;
	}

}