package searchingService.impl;

import searchingService.SearchingService;

public class LinearSearchAlgorithm implements SearchingService {
    @Override
    public int search(int[] input, int targetElement) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == targetElement) {
                return i;
            }
        }
        return -1;
    }
}
