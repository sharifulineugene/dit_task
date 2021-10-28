package com.github.sharifulineugene.dao;

import com.github.sharifulineugene.dto.Balance;
import com.github.sharifulineugene.entity.Account;
import com.github.sharifulineugene.entity.Card;

import java.util.List;

public interface IAccountDao extends IDao<Account> {
    /**
     * Возвращает List<Card>, содержащий все карты аккаунта*/
    List<Card> getCardsByAccountId(int account_id);

    /**
     *Добавляет переданную карту к аккаунту с указанным id */
    void addCardToAccount(Card card, int account_id);
    /**
     *Пополняет баланс аккаунта с указанным id на указанную сумму*/
    void addBalance(int id, Balance deposit);
}
