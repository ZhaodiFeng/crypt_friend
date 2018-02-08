package com.bewire.DAL;

import com.bewire.Models.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WalletDAO extends CrudRepository<Wallet,Long>{
    public List<Wallet> findAllByUserId(String id);
}
