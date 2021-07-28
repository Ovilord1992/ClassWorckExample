package service.impl;

import exceptions.NoCoffee;
import exceptions.NoWater;
import exceptions.TankIsFull;
import service.MachineV1;

public class MachineFirst extends AbstractCoffeeMachine implements MachineV1 {


    public MachineFirst(int coffeeCount, int waterCount, int maxTankCount) {
        super(coffeeCount, waterCount, maxTankCount);
    }

    @Override
    public boolean getEspresso() throws NoCoffee, NoWater, TankIsFull {
        if (check(AbstractCoffeeMachine.espressoCoffeeNeeded, AbstractCoffeeMachine.espressoWaterNeeded)) {
            this.coffeeCount -= AbstractCoffeeMachine.espressoCoffeeNeeded;
            this.waterCount -= AbstractCoffeeMachine.espressoWaterNeeded;
            currentTankCountInc(AbstractCoffeeMachine.espressoCoffeeNeeded);
            return true;
        }
        return false;
    }

    @Override
    public boolean getAmericano() throws NoCoffee, NoWater, TankIsFull {
        if (check(AbstractCoffeeMachine.americanoCoffeeNeeded, AbstractCoffeeMachine.americanoWaterNeeded)) {
            this.coffeeCount -= AbstractCoffeeMachine.americanoCoffeeNeeded;
            this.waterCount -= AbstractCoffeeMachine.americanoWaterNeeded;
            currentTankCountInc(AbstractCoffeeMachine.americanoCoffeeNeeded);
            return true;
        }
        return false;
    }

}
