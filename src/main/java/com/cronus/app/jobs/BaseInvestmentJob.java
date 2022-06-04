package com.cronus.app.jobs;

public abstract class BaseInvestmentJob extends BaseJob {
    private String accNo;
    private String[] names;
    private Double intDeposited;
    private Double principal;
    private String medium;
    private String date;
    private String nominee;
    private String master;

    public BaseInvestmentJob(String accNo, String[] names, Double intDeposited, Double principal, String medium,
            String date, String nominee, String master) {
        this.accNo = accNo;
        this.names = names;
        this.intDeposited = intDeposited;
        this.principal = principal;
        this.medium = medium;
        this.date = date;
        this.nominee = nominee;
        this.master = master;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Double getIntDeposited() {
        return intDeposited;
    }

    public void setIntDeposited(Double intDeposited) {
        this.intDeposited = intDeposited;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

}
