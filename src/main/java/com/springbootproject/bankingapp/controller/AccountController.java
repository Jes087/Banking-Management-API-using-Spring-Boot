package com.springbootproject.bankingapp.controller;

import com.springbootproject.bankingapp.AccountDto.AccountDto;
import com.springbootproject.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add RESTAPI for creating account
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }
    //restapi for getting account details
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountFromId(@PathVariable long id){
        AccountDto accountdto=accountService.GetAccountById(id);
        return ResponseEntity.ok(accountdto);
    }

    //deposit RESTapi
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>  Deposit(@PathVariable long id,@RequestBody Map<String,Double> request){
        AccountDto accountDto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>  withdraw(@PathVariable long id,@RequestBody Map<String,Double> request){
        AccountDto accountDto=accountService.withdraw(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id){
        accountService.DeleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }
}
