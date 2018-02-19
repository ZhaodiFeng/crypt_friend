package com.bewire.DAL;

import com.bewire.Models.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface AssetDAO extends CrudRepository<Asset,Integer> {
    public List<Asset> findAllByWalletId(int id);
    public List<Asset> findAllByWalletIdInAndCurrencyId(Collection<Integer> walletId, int currencyId);
    public Asset findByWalletIdAndCurrencyId(int walletId,int currebcyId);
}
