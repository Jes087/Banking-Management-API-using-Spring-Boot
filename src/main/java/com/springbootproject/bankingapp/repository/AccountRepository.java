package com.springbootproject.bankingapp.repository;

import com.springbootproject.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
