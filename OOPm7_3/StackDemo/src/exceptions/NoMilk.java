package exceptions;

public class NoMilk extends Exception {
    public NoMilk() {
        super("В баке отсутсвует молоко");
    }
}
