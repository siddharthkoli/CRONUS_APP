package com.cronus.app.utils;

public class ExcelRow {
    private String accNo;
    private String[] names;
    private Double intDeposited;
    private Double principal;
    private String medium;
    private String maturityDate;
    private int maturityDay;
    private int maturityMonth;
    private int maturityYear;
    private String master;

    public ExcelRow(String accNo, String[] names, Double intDeposited, Double principal, String medium, String maturityDate,
            int maturityDay, int maturityMonth, int maturityYear, String master) {
        this.accNo = accNo;
        this.names = names;
        this.intDeposited = intDeposited;
        this.principal = principal;
        this.medium = medium;
        this.maturityDate = maturityDate;
        this.maturityDay = maturityDay;
        this.maturityMonth = maturityMonth;
        this.maturityYear = maturityYear;
        this.master = master;
    }

    public int getMaturityDay() {
        return maturityDay;
    }

    public int getMaturityMonth() {
        return maturityMonth;
    }

    public int getMaturityYear() {
        return maturityYear;
    }

    public String getAccNo() {
        return accNo;
    }

    public String[] getNames() {
        return names;
    }

    public Double getIntDeposited() {
        return intDeposited;
    }

    public Double getPrincipal() {
        return principal;
    }

    public String getMedium() {
        return medium;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public String getMaster() {
        return master;
    }

}
