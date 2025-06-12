package com.springbootproject.bankingapp.service.Imp;
import com.springbootproject.bankingapp.AccountDto.AccountDto;
import com.springbootproject.bankingapp.AccountMapping.AccountMapper;
import com.springbootproject.bankingapp.entity.Account;
import com.springbootproject.bankingapp.repository.AccountRepository;
import com.springbootproject.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapDtoToAccount(accountDto);
        Account savedaccount=accountRepository.save(account);
        return AccountMapper.mapAccountToDto(savedaccount);
    }

    @Override
    public AccountDto GetAccountById(long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.mapAccountToDto(account);
    }

    @Override
    public AccountDto deposit(long id,double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        accountRepository.save(account);
        return AccountMapper.mapAccountToDto(account);

    }

    @Override
    public AccountDto withdraw(long id, double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if(account.getBalance()-amount<0){
            throw new RuntimeException("Insufficient balance");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedaccount=accountRepository.save(account);
        return AccountMapper.mapAccountToDto(savedaccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapAccountToDto).collect(Collectors.toList());

    }

    @Override
    public void DeleteAccount(long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.deleteById(id);
    }
}
