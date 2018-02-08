package com.bewire.PL.Controllers.DTO;

import com.bewire.Models.User;

import java.util.List;

public class UserWalletsDTO {
    private User user;
    private List<WalletAssetsDTO> wallets;

    public UserWalletsDTO(User user, List<WalletAssetsDTO> wallets) {
        this.user = user;
        this.wallets = wallets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WalletAssetsDTO> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletAssetsDTO> wallets) {
        this.wallets = wallets;
    }
}
