package com.springbootproject.bankingapp.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private long Id;
    private String AccountHolderName;
    private double balance;

}
