package com.alvarorivas.finalproject.model.users;

import com.alvarorivas.finalproject.model.util.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "account_holder")
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer accountHolderId;

    @NotBlank
    private String name;

    @Past(message = "Must be a date in the past")
    private LocalDate birthDate;

    private Integer age;

    @Embedded
    @NotBlank
    private Address primaryAddress;

    @Embedded
    @NotBlank
    private Address mailingAddress;

    public AccountHolder() {
    }
    public AccountHolder(String name, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public Integer getAccountHolderId() {
        return accountHolderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
