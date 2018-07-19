package com.instinctools.carsdealer.dao;

import com.instinctools.carsdealer.dao.IAd;
import com.instinctools.carsdealer.dao.IBaseEntity;

public interface IPhotoLink extends IBaseEntity {

    IAd getAd();

    void setAd(IAd ad);

    String getLink();

    void setLink(String link);
}
