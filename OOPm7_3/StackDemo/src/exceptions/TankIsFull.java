package exceptions;

public class TankIsFull extends Exception {
    public TankIsFull() {
        super("Отсутсвует вода");
    }
}
