public class Employee {
    private String FIO;

    private EmployeeSolary solary;

    private boolean hasChildren = false;

    private boolean offshore = false;

    private int workHours;

    public Employee(String FIO, EmployeeSolary solary, int workHours, boolean hasChildren, boolean offshore) {
        this.FIO = FIO;
        this.solary = solary;
        this.hasChildren = hasChildren;
        this.offshore = offshore;
        this.workHours = workHours;
    }

    public Employee(String FIO, EmployeeSolary solary) {
        this.FIO = FIO;
        this.solary = solary;
    }

    public Employee() {
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public boolean isOffshore() {
        return offshore;
    }

    public void setOffshore(boolean offshore) {
        this.offshore = offshore;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
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
