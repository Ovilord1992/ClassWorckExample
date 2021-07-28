package service.impl;

import exceptions.NoCoffee;
import exceptions.NoMilk;
import exceptions.NoWater;
import exceptions.TankIsFull;
import service.AbstractCoffeeMachine;

public interface MachineV3 extends AbstractCoffeeMachine {

    boolean getAmericano() throws NoCoffee, NoWater, TankIsFull;

    boolean getLatte(int milk) throws NoWater, TankIsFull, NoCoffee, NoMilk;

}
