package com.JPAJakartaEE8.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Allowance extends AbstractEntity{
    @Column(name = "allowance_Amount")
    private BigDecimal allowanceAmount;
    @Column(name = "allowance_Name")
    private BigDecimal allowanceName;

    public BigDecimal getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public BigDecimal getAllowanceName() {
        return allowanceName;
    }

    public void setAllowanceName(BigDecimal allowanceName) {
        this.allowanceName = allowanceName;
    }
}
