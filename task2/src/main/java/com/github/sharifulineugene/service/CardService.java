package com.github.sharifulineugene.service;

import com.github.sharifulineugene.dao.ICardDao;
import com.github.sharifulineugene.dto.CardDto;
import com.github.sharifulineugene.dto.mappers.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardService implements ICardService{

    private final ICardDao cardDAO;
    private final CardMapper cardMapper;

    @Autowired
    public CardService(ICardDao cardDAO, CardMapper cardMapper) {
        this.cardDAO = cardDAO;
        this.cardMapper = cardMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CardDto> getAll() {
        return cardDAO.index().stream().map(cardMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(CardDto object) {
        cardDAO.save(cardMapper.toEntity(object));
    }

    @Transactional(readOnly = true)
    @Override
    public CardDto get(int id) {
        return cardMapper.toDto(cardDAO.show(id));
    }

}
