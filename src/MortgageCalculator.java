import constants.Constants;

class MortgageCalculator {


    public double calculateMonthlyPayment(double principle, float annualInterestRate, int mortgageTerm) {


        float monthlyInterestRate = annualInterestRate / Constants.MONTHS_IN_A_YEAR;
        int numberOfPayments = mortgageTerm * Constants.MONTHS_IN_A_YEAR;

        double monthlyPayment = principle * ((monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) / ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1));

        return Math.ceil(monthlyPayment); // Round up monthly payment
    }

    public double calculateTotalPayback(double monthlyPayment, int mortgageTerm) {
        return monthlyPayment * mortgageTerm * Constants.MONTHS_IN_A_YEAR;
    }

}