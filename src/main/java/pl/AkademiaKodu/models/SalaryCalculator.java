package pl.AkademiaKodu.models;

public class SalaryCalculator {

    //declaration & initialization our variables
    private final double incomeTaxThreshold = 7127.333333333333;
    private final double taxThresholdFirst = 0.18;
    private final double taxThresholdSecond = 0.32;
    private final double taxHealthTemp = 0.075;
    private final double amountFreeOfTax = 46.33;
    private final double incomeAmountLocal = 112.25;
    private final double incomeAmountOutside = 139.06;
    private final double rateMedicalInsurance = 0.09;
    private final double rateRetirementContribution = 0.0976;
    private final double ratePensionContribution = 0.015;
    private final double rateSicknessContribution = 0.0245;

    //method to calculate net salary from gross
    public double salaryNetCalculator(double grossAmount, double bonus, int distanceFromWorkPlace){
        //1 calc total base
        double grossBase = grossAmount + bonus;
        if (grossBase<1){
            throw new IllegalArgumentException("Gross Base must be bigger than 0");
        }
        if (distanceFromWorkPlace<0){
            throw new IllegalArgumentException("Distance from work must be positive!");
        }

        //2 calc zus tribute
        double zusTribute = calcZUSTribute(grossBase);
        double grossAfterZus = grossBase - zusTribute;

        //3 calc healthTribute
        double healthTribute = calcMedicalInsurance(grossAfterZus);

        //4 calc advanceForIncomeTax
        double advanceForIncomeTax = calcAdvanceOfIncomeTax(grossAfterZus, distanceFromWorkPlace);

        return roundFinancial(grossBase - zusTribute - healthTribute - advanceForIncomeTax);
    }

    //method to rounded two decimal places (without using BigDecimals)
    public double roundFinancial( double amountToRounded){
        return Math.round(amountToRounded*100.0)/100.0;
    }

    public double calcZUSTribute(double totalGrossAmount){
        double retirementContribution = calcRetirementContribution(totalGrossAmount);
        double pensionContribution = calcPensionContribution(totalGrossAmount);
        double sicknessContribution = calcSicknessContribution(totalGrossAmount);
        return roundFinancial(retirementContribution + pensionContribution + sicknessContribution);
    }

    public double calcMedicalInsurance(double grossAfterZUS){
        return roundFinancial(grossAfterZUS*getRateMedicalInsurance());
    }

    public double calcRetirementContribution(double grossAmount){
        return roundFinancial(grossAmount * getRateRetirementContribution());
    }

    public double calcPensionContribution(double grossAmount) {
        return roundFinancial(grossAmount * getRatePensionContribution());
    }

    public double calcSicknessContribution(double grossAmount) {
        return roundFinancial(grossAmount * getRateSicknessContribution());
    }

    public int calcAdvanceOfIncomeTax(double grossAfterZus, int distanceFromWorkPlace){
        //calc income cost
        double advanceForIncomeTax = grossAfterZus - calcIncomeCost(distanceFromWorkPlace);
        if (advanceForIncomeTax<getIncomeTaxThreshold()){
            advanceForIncomeTax =  roundFinancial((advanceForIncomeTax*getTaxThresholdFirst()));
        } else {
            advanceForIncomeTax = roundFinancial((advanceForIncomeTax*getTaxThresholdSecond()));
        }
        advanceForIncomeTax-=getAmountFreeOfTax();
        advanceForIncomeTax-=calcTempHealthTribute(grossAfterZus);
        return (int)advanceForIncomeTax;
    }

    public double calcIncomeCost(int distanceFromWorkPlace){
        if (isLocal(distanceFromWorkPlace)){
            return getIncomeAmountLocal();
        }
        return getIncomeAmountOutside();
    }

    public boolean isLocal(int distanceFromWorkPlace){
        if (distanceFromWorkPlace>10){
            return false;
        }
        return true;
    }


    public double calcTempHealthTribute(double grossAfterZUS){
        return roundFinancial(grossAfterZUS * getTaxHealthTemp());
    }

    //getters
    public double getTaxThresholdFirst() {
        return taxThresholdFirst;
    }

    public double getTaxThresholdSecond() {
        return taxThresholdSecond;
    }

    public double getTaxHealthTemp() {
        return taxHealthTemp;
    }

    public double getAmountFreeOfTax() {
        return amountFreeOfTax;
    }

    public double getIncomeTaxThreshold() {
        return incomeTaxThreshold;
    }

    public double getIncomeAmountLocal() {
        return incomeAmountLocal;
    }

    public double getIncomeAmountOutside() {
        return incomeAmountOutside;
    }

    public double getRateMedicalInsurance() {
        return rateMedicalInsurance;
    }

    public double getRateRetirementContribution() {
        return rateRetirementContribution;
    }

    public double getRatePensionContribution() {
        return ratePensionContribution;
    }

    public double getRateSicknessContribution() {
        return rateSicknessContribution;
    }
}
