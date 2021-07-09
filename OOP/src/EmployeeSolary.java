public class EmployeeSolary {

    private Months month;

    private SolaryType solaryType;

    private int summ;

    public EmployeeSolary() {
    }

    public EmployeeSolary(Months month, SolaryType solaryType, int summ) {
        this.month = month;
        this.solaryType = solaryType;
        this.summ = summ;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public SolaryType getSolaryType() {
        return solaryType;
    }

    public void setSolaryType(SolaryType solaryType) {
        this.solaryType = solaryType;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }
}
