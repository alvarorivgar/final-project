package com.alvarorivas.finalproject.model.accounts;

import com.alvarorivas.finalproject.model.users.AccountHolder;
import com.alvarorivas.finalproject.model.util.Money;
import com.alvarorivas.finalproject.model.util.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "checking")
@AttributeOverrides({
        @AttributeOverride(name = "minimumBalance.amount", column = @Column(name = "min_balance_amount")),
        @AttributeOverride(name = "monthlyMaintenanceFee.amount", column = @Column(name = "monthly_maintenance_fee_amount")),
        @AttributeOverride(name = "minimumBalance.currency", column = @Column(name = "min_balance_currency")),
        @AttributeOverride(name = "monthlyMaintenanceFee.currency", column = @Column(name = "monthly_maintenance_fee_currency"))
})
public class Checking extends Account{

    private String secretKey;

    @Embedded
    private Money minimumBalance = new Money(new BigDecimal(250));

    private LocalDate lastPenaltyFeeCheck = getCreationDate().plusMonths(1).withDayOfMonth(1);

    private LocalDate lastMaintenanceFeeApplication = getCreationDate().plusMonths(1).withDayOfMonth(1);

    @Embedded
    private Money monthlyMaintenanceFee = new Money(new BigDecimal(12));

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Status status, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, status);
        this.secretKey = secretKey;
    }

    public Checking() {
        super();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getLastPenaltyFeeCheck() {
        return lastPenaltyFeeCheck;
    }

    public void setLastPenaltyFeeCheck(LocalDate lastPenaltyApplication) {
        this.lastPenaltyFeeCheck = lastPenaltyApplication;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public LocalDate getLastMaintenanceFeeApplication() {
        return lastMaintenanceFeeApplication;
    }

    public void setLastMaintenanceFeeApplication(LocalDate lastMaintenanceFeeApplication) {
        this.lastMaintenanceFeeApplication = lastMaintenanceFeeApplication;
    }
}
