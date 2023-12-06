package factoryService;

import sortingService.SortingAlgorithm;
import sortingService.impl.BubbleSortAlgorithm;
import sortingService.impl.MergeSortAlgorithm;
import sortingService.impl.QuickSortAlgorithm;
import sortingService.impl.ShakerSortAlgorithm;

public class SortingFactory {
     public SortingAlgorithm creatSortingAlgorithm (factoryEnum.SortingFactory enums) {
        switch (enums){
            case BUBBLE:
                return new BubbleSortAlgorithm();
            case SHAKER:
                return new ShakerSortAlgorithm();
            case MERGE:
                return new MergeSortAlgorithm();
            case QUICK:
                return new QuickSortAlgorithm();
            default:
                throw new RuntimeException();
        }
    }
}
