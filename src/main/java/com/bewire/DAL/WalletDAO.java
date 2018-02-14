package com.bewire.DAL;

import com.bewire.Models.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WalletDAO extends CrudRepository<Wallet,Integer>{
    public List<Wallet> findAllByUserId(String id);
}
