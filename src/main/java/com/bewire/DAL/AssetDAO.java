package com.bewire.DAL;

import com.bewire.Models.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AssetDAO extends CrudRepository<Asset,Long> {
    public Asset findByUserId();
}
