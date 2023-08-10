package service.impl;

import enums.Supply;
import model.Character;
import service.CharacterService;

import java.text.DecimalFormat;

public class CharacterServiceImpl implements CharacterService {
    private final Character character;

    public CharacterServiceImpl(final Character character) {
        this.character = character;
    }

    @Override
    public void eat() {
        character.setHealthStatus(increase(character.getHealthStatus(),Supply.FOOD));
        character.setWeight(increase(character.getWeight(),Supply.FOOD));
    }

    @Override
    public void drink() {
        character.setHealthStatus(increase(character.getHealthStatus(),Supply.DRINK));
        character.setWeight(increase(character.getWeight(),Supply.DRINK));
    }

    @Override
    public void show() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("------------- |" + character.getUsername() + "| ---------------\n" +
                "Your Health: " + decimalFormat.format(character.getHealthStatus())+
                "\nYour Weight: " + decimalFormat.format(character.getWeight()));
    }

    public double increase(double increaseValue, Supply supply) {
        return increaseValue + increaseValue * supply.getIncreaseValue();
    }

    public double decrease(double decreaseValue, Supply supply) {
        return decreaseValue - decreaseValue * supply.getDecreaseValue();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3500);
                character.setHealthStatus(decrease(character.getHealthStatus(), Supply.FOOD));
                character.setWeight(decrease(character.getWeight(),Supply.FOOD));
                Thread.sleep(1500);
                character.setHealthStatus(decrease(character.getHealthStatus(), Supply.DRINK));
                character.setWeight(decrease(character.getWeight(),Supply.DRINK));
                if(character.getHealthStatus() < 1 || character.getWeight() < 1){
                    System.out.println("You are dead!");
                    System.exit(-1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
