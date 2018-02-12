package com.bewire.BLL;

import com.bewire.PL.DTO.UserWalletsDTO;

public interface IUserAssetsBLL {
    UserWalletsDTO getAllWalletsAndAssets(String id);
}
