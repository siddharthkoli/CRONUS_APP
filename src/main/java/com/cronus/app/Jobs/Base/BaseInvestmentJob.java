package com.cronus.app.Jobs.Base;

import java.util.Date;

public class BaseInvestmentJob extends BaseJob {

    private String names;
    private String accNo;
    private Double intDeposited;
    private String principal;
    private String medium;
    private Date datef;
    private String nominee;
    private String master;

   

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAccNo() {
        return this.accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Double getIntDeposited() {
        return this.intDeposited;
    }

    public void setIntDeposited(Double intDeposited) {
        this.intDeposited = intDeposited;
    }

    public String getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Date getDatef() {
        return this.datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public String getNominee() {
        return this.nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getMaster() {
        return this.master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public BaseInvestmentJob(){
        super();
        this.accNo = accNo;
        this.names = names;
        this.intDeposited = intDeposited;
        this.principal = principal;
        this.medium = medium;
        this.datef = datef;
        this.nominee= nominee;
        this.master = master;
    }
    @Override
    void GetNotificationString() {
        // TODO Auto-generated method stub
        
    }
    
}
