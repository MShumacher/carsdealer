package com.instinctools.carsdealer.dao;

import com.instinctools.carsdealer.dao.IAd;
import com.instinctools.carsdealer.dao.IBaseEntity;

public interface IPhotoLink extends IBaseEntity {

    IAd getAdId();

    void setAdId(IAd adId);

    String getLink();

    void setLink(String link);
}
