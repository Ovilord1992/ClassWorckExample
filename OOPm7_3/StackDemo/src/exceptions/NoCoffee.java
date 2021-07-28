package exceptions;

public class NoCoffee extends Exception {
    public NoCoffee() {
        super("Отсутсвует кофе");
    }
}
