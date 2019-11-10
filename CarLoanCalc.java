import java.util.Scanner;

public class CarLoanCalc {
    public static void main (String[] args){

        double carPrice, downPay, principal, totalInt=0, monthlyRepay, totalLoan=0, totalprincipal=0, balance;
        int loanPeriod, intRate;

        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Car Price (RM): ");
            carPrice = input.nextDouble();

        } while (carPrice < 30000);

        do {
            System.out.print("Down Payment (RM): ");
            downPay = input.nextDouble();

        } while (downPay < 0);

        do {
            System.out.print("Loan Period (Years): ");
            loanPeriod = input.nextInt();

        } while (loanPeriod < 5 || loanPeriod > 9);

        do {
            System.out.print("Interest Rate (%): ");
            intRate = input.nextInt();

        } while (intRate < 3 || intRate > 7);

        totalInt = (carPrice - downPay) * intRate / 100;
        principal = (carPrice - downPay) / loanPeriod + totalInt;

        monthlyRepay = principal / 12;
        System.out.format("\nMonthly Repayment = RM %.2f\n\n", monthlyRepay);

        totalLoan = (carPrice - downPay) + (totalInt * loanPeriod);

        System.out.printf("%-5s%20s%20s%20s\n", "YEARS", "PRINCIPAL(RM)", "INTEREST(RM)", "BALANCE(RM)");
        for (int i = 1; i <= loanPeriod; i++) {
            totalprincipal += principal;
            totalInt += intRate;
            balance = totalLoan - totalprincipal;
            System.out.format("%3s%19.2f%20.2f%21.2f\n", i,  totalprincipal, totalInt, balance);

        }
    }
}