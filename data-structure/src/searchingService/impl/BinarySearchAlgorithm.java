package searchingService.impl;

import searchingService.SearchingService;

public class BinarySearchAlgorithm implements SearchingService {
    @Override
    public int search(int[] input, int targetElement) {

        return search(input, targetElement, 0, input.length - 1);

    }
    private int search(int[] input, int targetElement, int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) return -1;
        int midIndex = (firstIndex + lastIndex) / 2;
        if (input[midIndex] == targetElement) {
            return midIndex;
        }
        if (input[midIndex] > targetElement) return search(input, targetElement, firstIndex, midIndex - 1);
        if (input[midIndex] < targetElement) return search(input, targetElement, midIndex + 1, lastIndex);
        else return -1;
    }


}
