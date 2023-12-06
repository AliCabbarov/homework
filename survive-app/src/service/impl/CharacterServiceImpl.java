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
        character.setHealthStatus(incrementHealth(character.getHealthStatus(), Supply.FOOD));
    }

    @Override
    public void drink() {
        character.setHealthStatus(incrementHealth(character.getHealthStatus(), Supply.WATER));
    }

    @Override
    public void showHealthy() {
        System.out.println("----------- |" + character.getName() + "| -----------");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("Your health: " + decimalFormat.format(character.getHealthStatus()));
    }

    private double incrementHealth(double healthStatus, Supply supply) {
        return healthStatus + (healthStatus * supply.getIncrementValue());
    }

    private double decreaseHealth(double healthStatus, Supply supply) {
        return healthStatus - (healthStatus * supply.getDecreaseValue());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2500);
                character.setHealthStatus(decreaseHealth(character.getHealthStatus(), Supply.FOOD));
                character.setHealthStatus(decreaseHealth(character.getHealthStatus(), Supply.WATER));

                if (character.getHealthStatus() < 1) {
                    System.out.println("You dead!");
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
