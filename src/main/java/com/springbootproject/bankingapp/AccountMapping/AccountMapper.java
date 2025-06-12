package com.springbootproject.bankingapp.AccountMapping;
import com.springbootproject.bankingapp.AccountDto.AccountDto;
import com.springbootproject.bankingapp.entity.Account;

public class AccountMapper {

    public static AccountDto mapAccountToDto(Account account) {
        AccountDto dto = new AccountDto(
                account.getId(),
                account.getAccountholderName(),
                account.getBalance()
        );
        return dto;
    }
    public static Account mapDtoToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }
}
