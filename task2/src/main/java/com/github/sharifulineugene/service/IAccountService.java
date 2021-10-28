package com.github.sharifulineugene.service;

import com.github.sharifulineugene.dto.AccountDto;
import com.github.sharifulineugene.dto.Balance;
import com.github.sharifulineugene.dto.CardDto;

import java.util.List;

public interface IAccountService extends Service<AccountDto>{
    /**
     * Возвращает List<CardDto>, содержащий DTO всех карт, принадлежащих аккаунту с указанным id
     *
     * */
    List<CardDto> getCardsByAccountId(int account_id);
    /**
     * Добавляет карту, которая соответствует переданному ДТО, аккаунту с указанным id
     * */
    void addCardToAccount(CardDto card, int account_id);
    /**
     * Пополняет баланса аккаунта с указанным id на указанную сумму
     * */
    void addBalance(int id, Balance deposit);
}
