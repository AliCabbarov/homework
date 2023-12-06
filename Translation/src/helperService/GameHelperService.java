package helperService;

import util.RandomUtil;

import java.text.DecimalFormat;
import java.util.List;

public class GameHelperService {
    public static GameHelperService instance;

    private GameHelperService() {
    }

    public static GameHelperService getInstance() {
        return instance == null ? instance = new GameHelperService() : instance;
    }

    public String[] randomKeyAndValue(List<String> keys, List<String> values, int length) {
        int randomIndex = RandomUtil.getInstance().getRandomIndex(length);
        String[] returnKeyAndValue = new String[3];
        returnKeyAndValue[1] = values.get(randomIndex);
        returnKeyAndValue[0] = keys.get(randomIndex);
        returnKeyAndValue[2] = String.valueOf(randomIndex);
        return returnKeyAndValue;
    }

    public void result(double wrongAnswer, double trueAnswer) {
        double percentOfSuccess;
        if (wrongAnswer == 0) {
            percentOfSuccess = 100;
        } else {
            percentOfSuccess = trueAnswer / (trueAnswer + wrongAnswer) * 100;
        }
        int trueAnswerInt = (int) trueAnswer;
        int wrongAnswerInt = (int) wrongAnswer;
        DecimalFormat decimalFormat = new DecimalFormat("##");
        String percentFormat = decimalFormat.format(percentOfSuccess);
        System.out.println("True Answer: " + trueAnswerInt + "\n" +
                "Wrong Answer: " + wrongAnswerInt + "\n" +
                "Percent of Success: " + percentFormat + "%");
    }
}
