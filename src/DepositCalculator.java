import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double futureValue = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(futureValue, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundValue(double value, int power) {
        double raisingToPower = Math.pow(10, power);
        return Math.round(value * raisingToPower) / raisingToPower;
    }

    void countDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double depositResult = 0;

        if (action == 1) {
            depositResult = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositResult = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().countDeposit();
    }
}