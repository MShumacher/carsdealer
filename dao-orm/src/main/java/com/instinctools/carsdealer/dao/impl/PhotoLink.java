package com.instinctools.carsdealer.dao.impl;

import com.instinctools.carsdealer.dao.IAd;
import com.instinctools.carsdealer.dao.IPhotoLink;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class PhotoLink extends BaseEntity implements IPhotoLink {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Ad.class)
    private IAd adId;

    @Column
    private String link;

    @Override
    public IAd getAdId() {
        return adId;
    }

    @Override
    public void setAdId(IAd adId) {
        this.adId = adId;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "PhotoLink{" +
                "id='" + getId() + '\'' +
                ", adId=" + adId +
                ", link='" + link + '\'' +
                '}';
    }
}
