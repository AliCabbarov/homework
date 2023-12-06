package factoryService;

import searchingService.SearchingService;
import searchingService.impl.BinarySearchAlgorithm;
import searchingService.impl.LinearSearchAlgorithm;

public class SearchingFactory {
    public SearchingService createSearchingService(factoryEnum.SearchingFactory enums) {
        switch (enums){
            case LINEAR:
                return new LinearSearchAlgorithm();
            case BINARY:
                return new BinarySearchAlgorithm();
            default:
                throw new RuntimeException();
        }
    }
}
