public class Runner {

    private static final int PERCENT_FOR_HOURLY_AND_RATE = 20;
    private static final int PERCENT_FOR_PIECEWORK = 15;


    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Иванов", new EmployeeSolary(Months.January, SolaryType.rate, 3000));
        employees[1] = new Employee("Сидоров", new EmployeeSolary(Months.January, SolaryType.hourly, 800));
        employees[2] = new Employee("Петров", new EmployeeSolary(Months.January, SolaryType.piecework, 5500));
        printEmployees(employees);
        printEmployeesWithPercent(employees);
    }

    private static void printEmployees(Employee[] employees) {
        int result = 0;
        System.out.println("ФИО\t\t\tВид оплаты\t\tСумма");
        for (Employee emp : employees) {
            System.out.printf("%s\t\t%s\t\t%d руб\n", emp.getFIO(), emp.getSolary().getSolaryType().toString(), emp.getSolary().getSumm());
            result += emp.getSolary().getSumm();
        }
        System.out.printf("Итого: \t\t\t\t\t\t%s руб\n", result);
        System.out.println("________________________________________________");
    }

    private static void printEmployeesWithPercent(Employee[] employees) {
        System.out.println("ФИО\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {
            int sum = emp.getSolary().getSolaryType() == SolaryType.piecework ?
                    emp.getSolary().getSumm() * PERCENT_FOR_PIECEWORK / 100 :
                    emp.getSolary().getSumm() * PERCENT_FOR_HOURLY_AND_RATE / 100;
            System.out.printf("%s\t\t%s \t\t\t\t%s\t\t%d руб\t\t%d\n",
                    emp.getFIO(),
                    emp.getSolary().getSolaryType() == SolaryType.piecework ? PERCENT_FOR_PIECEWORK : PERCENT_FOR_HOURLY_AND_RATE,
                    emp.getSolary().getSolaryType().toString(),
                    sum,
                    emp.getSolary().getSumm() - sum);
        }
        System.out.println("________________________________________________");
    }


}
