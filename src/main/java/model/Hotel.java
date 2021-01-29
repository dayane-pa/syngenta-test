package model;

import helper.DateConverterHelper;

public class Hotel {
    private String name;
    private int classification;
    private double taxWeekDayNormalCustomer;
    private double taxWeekDayRewardCustomer;
    private double taxWeekendNormalCustomer;
    private double taxWeekendRewardCustomer;

    public Hotel() {
    }
   public static DateConverterHelper dateConverterHelper=new DateConverterHelper();

    public Hotel(String name, int classification, double taxWeekDayNormalCustomer, double taxWeekDayRewardCustomer,
                 double taxWeekendNormalCustomer, double taxWeekendRewardCustomer) {
        this.name = name;
        this.classification = classification;
        this.taxWeekDayNormalCustomer = taxWeekDayNormalCustomer;
        this.taxWeekDayRewardCustomer = taxWeekDayRewardCustomer;
        this.taxWeekendNormalCustomer = taxWeekendNormalCustomer;
        this.taxWeekendRewardCustomer = taxWeekendRewardCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public double getTaxWeekDayNormalCustomer() {
        return taxWeekDayNormalCustomer;
    }

    public void setTaxWeekDayNormalCustomer(double taxWeekDayNormalCustomer) {
        this.taxWeekDayNormalCustomer = taxWeekDayNormalCustomer;
    }

    public double getTaxWeekDayRewardCustomer() {
        return taxWeekDayRewardCustomer;
    }

    public void setTaxWeekDayRewardCustomer(double taxWeekDayRewardCustomer) {
        this.taxWeekDayRewardCustomer = taxWeekDayRewardCustomer;
    }

    public double getTaxWeekendNormalCustomer() {
        return taxWeekendNormalCustomer;
    }

    public void setTaxWeekendNormalCustomer(double taxWeekendNormalCustomer) {
        this.taxWeekendNormalCustomer = taxWeekendNormalCustomer;
    }

    public double getTaxWeekendRewardCustomer() {
        return taxWeekendRewardCustomer;
    }

    public void setTaxWeekendRewardCustomer(double taxWeekendRewardCustomer) {
        this.taxWeekendRewardCustomer = taxWeekendRewardCustomer;
    }

    public double getTaxByConfiguration(boolean isWeekend, boolean isReward) {
        if (isWeekend) {
            if (isReward) {
                return taxWeekendRewardCustomer;
            }
            return taxWeekendNormalCustomer;

        } else {
            if (isReward) {
                return taxWeekDayRewardCustomer;
            }
            return taxWeekDayNormalCustomer;
        }
    }
}
