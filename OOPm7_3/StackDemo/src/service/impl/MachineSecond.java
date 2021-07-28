package service.impl;

import exceptions.NoCoffee;
import exceptions.NoMilk;
import exceptions.NoWater;
import exceptions.TankIsFull;
import service.MachineV2;

public class MachineSecond extends MachineFirst implements MachineV2 {

    private int milkTank;

    public MachineSecond(int coffeeCount, int waterCount, int maxTankCount, int milkTank) {
        super(coffeeCount, waterCount, maxTankCount);
        this.milkTank = milkTank;
    }

    @Override
    public boolean getCappuccino(int milk) throws NoWater, TankIsFull, NoCoffee, NoMilk {
        if (check(AbstractCoffeeMachine.espressoCoffeeNeeded, AbstractCoffeeMachine.espressoWaterNeeded)) {
            this.coffeeCount -= AbstractCoffeeMachine.espressoCoffeeNeeded;
            this.waterCount -= AbstractCoffeeMachine.espressoWaterNeeded;
            if (checkMilk(milk)) {
                this.milkTank -=milk;
            } else {
                throw new NoMilk();
            }
            currentTankCountInc(AbstractCoffeeMachine.espressoCoffeeNeeded);
            return true;
        }
        return false;
    }

    @Override
    public boolean getLatte(int milk) throws NoWater, TankIsFull, NoCoffee, NoMilk {
        if (check(AbstractCoffeeMachine.espressoCoffeeNeeded, AbstractCoffeeMachine.espressoWaterNeeded)) {
            this.coffeeCount -= AbstractCoffeeMachine.espressoCoffeeNeeded;
            this.waterCount -= AbstractCoffeeMachine.espressoWaterNeeded;
            if (checkMilk(milk)) {
                this.milkTank -= milk;
            } else {
                throw new NoMilk();
            }
            currentTankCountInc(AbstractCoffeeMachine.espressoCoffeeNeeded);
            return true;
        }
        return false;
    }

    private boolean checkMilk(int milk) throws NoMilk {
        return this.milkTank - milk >= 0;
    }

}
