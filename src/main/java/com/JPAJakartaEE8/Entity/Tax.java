package com.JPAJakartaEE8.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TAXES")
@AttributeOverride(name = "Id",column = @Column(name = "TAX_ID"))
public class Tax extends AbstractEntity {

    @Column(name = "TAX_RATE")
    private BigDecimal taxRate;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }


}
