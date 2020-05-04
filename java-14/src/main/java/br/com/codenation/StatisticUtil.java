package br.com.codenation;

import java.util.*;

public class StatisticUtil {

    public static int average(int[] elements) {

        if (elements == null)
            throw new IllegalArgumentException();

        int total = 0;

        for (int element : elements) {
            total += element;
        }

        return total / elements.length;
    }

    public static int mode(int[] elements) {

        if (elements == null)
            throw new IllegalArgumentException();

        Map<Integer, Integer> count = new TreeMap<>();
        int maior = 0;
        int moda = 0;

        for (int num : elements) {
            if (!count.containsKey(num))
                count.put(num, 0);
            int total = count.get(num) + 1;
            count.put(num, total);
            if (maior < total)
                maior = total;
        }

        for (Map.Entry<Integer, Integer> counts : count.entrySet()) {
			if (counts.getValue() == maior)
				moda = counts.getKey();
		}

         return moda;
    }

    public static int median(int[] elements) {

        if (elements == null)
            throw new IllegalArgumentException();

        Arrays.sort(elements);

        if(elements.length % 2 == 1){
            int medianaImpar = elements[(elements.length - 1)/2];
            return medianaImpar;
        }

        int left = elements.length/2 - 1;
        int right = left + 1;
        int medianaPar = (elements[left] + elements[right]) / 2;

        return medianaPar;
    }
}