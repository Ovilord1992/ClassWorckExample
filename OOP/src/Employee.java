public class Employee {
    private String FIO;

    private EmployeeSolary solary;

    public Employee(String FIO, EmployeeSolary solary) {
        this.FIO = FIO;
        this.solary = solary;
    }

    public Employee() {
    }

    public EmployeeSolary getSolary() {
        return solary;
    }

    public void setSolary(EmployeeSolary solary) {
        this.solary = solary;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
}
