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
    private final int distanceMaxToWork = 10;

    //method to calculate net salary from gross
    public double salaryNetCalculator(double grossAmount, double bonus, int distanceFromWorkPlace){
        //todo
        return 0;
    }

    //method to rounded two decimal places (without using BigDecimals)
    public double roundFinancial( double amountToRounded){
        return Math.round(amountToRounded*100.0)/100.0;
    }

    public double calcZUSTribute(double totalGrossAmount){
        //todo
        return 0;
    }

    public double calcMedicalInsurance(double grossAfterZUS){
        return roundFinancial(grossAfterZUS*getRateMedicalInsurance());
    }

    public double calcRetirementContribution(double grossAmount){
        //todo
        return 0;
    }

    public double calcPensionContribution(double grossAmount) {
        //todo
        return 0;
    }

    public double calcSicknessContribution(double grossAmount) {
        //todo
        return 0;
    }

    public int calcAdvanceOfIncomeTax(double grossAfterZus, int distanceFromWorkPlace){
        //todo
        return (int)0.0;
    }

    public double calcIncomeCost(int distanceFromWorkPlace){
        //todo
        return 0;
    }

    public boolean isLocal(int distanceFromWorkPlace){
        //todo
        return false;
    }


    public double calcTempHealthTribute(double grossAfterZUS){
        //todo
        return 0;
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

    public int getDistanceMaxToWork() {
        return distanceMaxToWork;
    }
}
