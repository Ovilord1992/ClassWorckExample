package service;

import exceptions.NoCoffee;
import exceptions.NoMilk;
import exceptions.NoWater;
import exceptions.TankIsFull;

public interface MachineV2 extends MachineV1 {

    boolean getCappuccino(int milk) throws NoWater, TankIsFull, NoCoffee, NoMilk;

    boolean getLatte(int milk) throws NoWater, TankIsFull, NoCoffee, NoMilk;

}
