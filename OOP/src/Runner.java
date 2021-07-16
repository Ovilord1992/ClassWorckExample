public class Runner {


    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Иванов", new EmployeeSolary(Months.January, SolaryType.rate, 3000), 400, true, false);
        employees[1] = new Employee("Сидоров", new EmployeeSolary(Months.January, SolaryType.hourly, 800), 150, false, true);
        employees[2] = new Employee("Петров", new EmployeeSolary(Months.January, SolaryType.piecework, 5500), 150, false, true);
        SolaryService.printEmployees(employees);
        SolaryService.printEmployeesWithPercent(employees);
        SolaryService.printEmployeesWithPercentAndChildrens(employees);
        SolaryService.printEmployeesSolaryWithTugrics(employees);
        SolaryService.printEmployeesSolaryWithOffshore(employees);
        SolaryService.printEmployeesSolaryWithPrize(employees);
    }


}
