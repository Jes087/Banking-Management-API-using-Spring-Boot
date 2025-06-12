package com.springbootproject.bankingapp.service;

import com.springbootproject.bankingapp.AccountDto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto GetAccountById(long id);

    AccountDto deposit(long id,double amount);

    AccountDto withdraw(long id,double amount);

    List<AccountDto> getAllAccounts();

    void DeleteAccount(long id);
}
