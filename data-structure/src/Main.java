import sortingService.SortingAlgorithm;
import factoryService.SearchingFactory;
import factoryService.SortingFactory;
import searchingService.SearchingService;
import util.Random;

public class Main {
    public static void main(String[] args) {
        int[] input = Random.inputArr(7, 10);
        SortingFactory sortingFactory = new SortingFactory();
        SortingAlgorithm sortingAlgorithm = sortingFactory.creatSortingAlgorithm(factoryEnum.SortingFactory.QUICK);
        sortingAlgorithm.show(input);
        sortingAlgorithm.sort(input);
        sortingAlgorithm.show(input);

        SearchingFactory searchingFactory = new SearchingFactory();
        SearchingService searchingService = searchingFactory.createSearchingService(factoryEnum.SearchingFactory.BINARY);
        System.out.println(searchingService.search(input, 5));


    }
}