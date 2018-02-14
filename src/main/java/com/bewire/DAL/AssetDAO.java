package com.bewire.DAL;

import com.bewire.Models.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssetDAO extends CrudRepository<Asset,Integer> {
    public List<Asset> findAllByWalletId(int id);
}
