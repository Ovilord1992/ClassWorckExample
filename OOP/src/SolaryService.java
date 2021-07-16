public class SolaryService {

    private static final int PERCENT_FOR_HOURLY_AND_RATE = 20;
    private static final int PERCENT_FOR_PIECEWORK = 15;
    private static final int TUGRIC_CONVERT = 8;
    private static final int PRIZE_HOURS = 200;
    private static final int PRIZE = 500;

    public static void printEmployees(Employee[] employees) {
        int result = 0;
        System.out.println("ФИО\t\t\tВид оплаты\t\tСумма");
        for (Employee emp : employees) {

            System.out.printf("%s\t\t%s\t\t%d руб\n", emp.getFIO(), emp.getSolary().getSolaryType().toString(), emp.getSolary().getSumm());
            result += emp.getSolary().getSumm();
        }
        System.out.printf("Итого: \t\t\t\t\t\t%s руб\n", result);
        System.out.println("________________________________________________");
    }

    public static void printEmployeesWithPercent(Employee[] employees) {
        System.out.println("ФИО\t\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {
            int sum = getEmpSum(emp);
            System.out.printf("%s\t\t%s%% \t\t\t\t%s\t\t%d руб\t\t%d\n",
                    emp.getFIO(),
                    getTaxPercentForEmp(emp),
                    emp.getSolary().getSolaryType().toString(),
                    emp.getSolary().getSumm(),
                    emp.getSolary().getSumm() - sum);
        }
        System.out.println("________________________________________________");
    }

    public static void printEmployeesWithPercentAndChildrens(Employee[] employees) {
        System.out.println("ФИО\t\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {
            int sum = getEmpSum(emp);
            System.out.printf("%s\t\t%s%% \t\t\t\t%s\t\t%d руб\t\t%d\n",
                    emp.getFIO(),
                    getTaxPercentForEmp(emp),
                    emp.getSolary().getSolaryType().toString(),
                    emp.getSolary().getSumm(),
                    emp.getSolary().getSumm() - sum);
        }
        System.out.println("________________________________________________");
    }

    public static void printEmployeesSolaryWithTugrics(Employee[] employees) {
        System.out.println("ФИО\t\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {

            int sum = getEmpSum(emp);
            int sumToSolary = emp.getSolary().getSumm() - sum;

            System.out.printf("%s\t\t%s%% \t\t\t\t%s\t\t%d руб\t\t%s\n",
                    emp.getFIO(),
                    getTaxPercentForEmp(emp),
                    emp.getSolary().getSolaryType().toString(),
                    emp.getSolary().getSumm(),
                    SolaryType.hourly == emp.getSolary().getSolaryType()
                            ?
                            String.format("%d/%d", sumToSolary / 2, sumToSolary / 2 / TUGRIC_CONVERT)
                            :
                            sumToSolary

            );
        }
        System.out.println("________________________________________________");
    }

    public static void printEmployeesSolaryWithOffshore(Employee[] employees) {
        System.out.println("ФИО\t\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {

            int sum = getEmpSum(emp);
            int sumToSolary = emp.getSolary().getSumm() - sum;

            System.out.printf("%s\t\t%s%% \t\t\t\t%s\t\t%d руб\t\t%s руб\n",
                    emp.getFIO(),
                    emp.isOffshore() ? 0 : getTaxPercentForEmp(emp),
                    emp.getSolary().getSolaryType().toString(),
                    emp.getSolary().getSumm(),
                    emp.isOffshore() ? emp.getSolary().getSumm() : sumToSolary

            );
        }
        System.out.println("________________________________________________");
    }


    public static void printEmployeesSolaryWithPrize(Employee[] employees) {
        System.out.println("ФИО\t\t\tНалог, %\t\t\tВид оплаты\t\tСумма\t\tК оплате (руб)");
        for (Employee emp : employees) {

            int sum = getEmpSum(emp);
            int sumToSolary = emp.getSolary().getSumm() - sum;

            System.out.printf("%s\t\t%s%% \t\t\t\t%s\t\t%d руб\t\t%s руб\n",
                    emp.getFIO(),
                    getTaxPercentForEmp(emp),
                    emp.getSolary().getSolaryType().toString(),
                    emp.getSolary().getSumm(),
                    (emp.getWorkHours() >= PRIZE_HOURS && !emp.isOffshore()) ? emp.getSolary().getSumm() + PRIZE : sumToSolary

            );
        }
        System.out.println("________________________________________________");
    }

    public static int getEmpSum(Employee emp) {
        return emp.getSolary().getSumm() * getTaxPercentForEmp(emp) / 100;
    }

    public static int getTaxPercentForEmp(Employee emp) {
        int taxWithChildrenPiecework = emp.isHasChildren() ? PERCENT_FOR_PIECEWORK : PERCENT_FOR_PIECEWORK + 5;
        int taxWithChildrenHourly = emp.isHasChildren() ? PERCENT_FOR_HOURLY_AND_RATE : PERCENT_FOR_HOURLY_AND_RATE + 5;
        return emp.getSolary().getSolaryType() == SolaryType.piecework ? taxWithChildrenPiecework : taxWithChildrenHourly;
    }
}
