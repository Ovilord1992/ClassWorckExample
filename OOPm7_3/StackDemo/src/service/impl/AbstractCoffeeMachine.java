package service.impl;

import exceptions.NoCoffee;
import exceptions.NoWater;
import exceptions.TankIsFull;

public class AbstractCoffeeMachine implements service.AbstractCoffeeMachine {

    public static final int espressoCoffeeNeeded = 22;
    public static final int espressoWaterNeeded = 30;
    public static final int americanoCoffeeNeeded = 22;
    public static final int americanoWaterNeeded = 100;

    protected int coffeeCount;
    protected int waterCount;
    protected int currentTankCount = 0;
    protected int maxTankCount;
    private boolean state = false;

    public AbstractCoffeeMachine(int coffeeCount, int waterCount, int maxTankCount) {
        this.coffeeCount = coffeeCount;
        this.waterCount = waterCount;
        this.maxTankCount = maxTankCount;
    }

    protected boolean checkCoffee(int coffee) {
        return this.coffeeCount >= coffee;
    }

    protected boolean checkWater(int water) {
        return this.waterCount >= water;
    }

    protected boolean checkTank(int capacity) {
        return this.maxTankCount - this.currentTankCount >= capacity;
    }

    protected boolean check(int CoffeeNeeded, int waterNeeded) throws NoCoffee, TankIsFull, NoWater {
        if (checkCoffee(AbstractCoffeeMachine.espressoCoffeeNeeded)) {
            throw new NoCoffee();
        }
        if (checkTank(AbstractCoffeeMachine.espressoCoffeeNeeded)) {
            throw new TankIsFull();
        }
        if (checkWater(AbstractCoffeeMachine.espressoWaterNeeded)) {
            throw new NoWater();
        }
        return true;
    }

    public void currentTankCountInc(int value) {
        this.currentTankCount += value;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    @Override
    public boolean powerOn() {
        this.state = true;
        return this.state;
    }

    @Override
    public boolean powerOff() {
        this.state = false;
        return this.state;
    }

    @Override
    public void cleanTank() {
        this.currentTankCount = 0;
    }
}
