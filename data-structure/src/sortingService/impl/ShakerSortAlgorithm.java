package sortingService.impl;

import sortingService.SortingAlgorithm;

public class ShakerSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            boolean isChanged = false;
            for (int j = 1; j < input.length - i; j++) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                    isChanged = true;
                }
            }
            for (int j = input.length - 2 - i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j-1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
            System.out.print("Test: ");
            show(input);
        }
    }
}
