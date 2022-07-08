package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import type.AccountStatus;
import type.ErrorCode;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountUserRepository accountUserRepository;

    /**
     * 사용자가 있는지 조회
     * 계좌의 번호를 생성하고
     * 계좌를 저장하고, 그 정보를 넘긴다.
     * @param userId 유저의 id
     * @param initialBalance 초기 넣어주는 금액
     */
    @Transactional
    public void createAccount(Long userId, Long initialBalance) {
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(()->new AccountException(ErrorCode.USER_NOT_FOUND));

        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber())+1 + ""))
                .orElse("10000000000");

        accountRepository.save(
                Account.builder()
                        .accountUser(accountUser)
                        .accountStatus(IN_USE)
                        .accountNumber(newAccountNumber)
                        .balance(initialBalance)
                        .registeredAt(LocalDateTime.now())
                        .build()
        );
    }

    @Transactional
    public Account getAccount(Long id) {
        if(id < 0){
            throw new RuntimeException("Minus");
        }
        return accountRepository.findById(id).get();
    }
}
