import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = Integer.parseInt(scanner.nextLine());
        System.out.print("Yearly revenue rate %: ");
        double yearlyRevPercentage = Double.parseDouble(scanner.nextLine());
        System.out.print("Period in years: ");
        int periodYears = Integer.parseInt(scanner.nextLine());

        System.out.printf("Mortgage: $ %.2f", calculateMortgage(principal, yearlyRevPercentage, periodYears));

    }

    private static double calculateMortgage(int principal, double yearlyRevPercentage, int periodYears) {
        double monthlyPercent = yearlyRevPercentage/12/100;
        int periodMonths = periodYears*12;
        double topPart = monthlyPercent * Math.pow((1+monthlyPercent), periodMonths);
        double bottomPart = Math.pow((1 + monthlyPercent), periodMonths) - 1;

        double mortgage = principal * topPart / bottomPart;

        return mortgage;
    }
}