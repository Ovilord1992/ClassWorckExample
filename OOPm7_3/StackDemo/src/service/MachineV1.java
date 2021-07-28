package service;

import exceptions.NoCoffee;
import exceptions.NoWater;
import exceptions.TankIsFull;

public interface MachineV1 extends AbstractCoffeeMachine {

    boolean getEspresso() throws NoCoffee, NoWater, TankIsFull;

    boolean getAmericano() throws NoCoffee, NoWater, TankIsFull;

}
