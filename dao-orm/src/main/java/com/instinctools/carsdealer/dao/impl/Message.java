package com.instinctools.carsdealer.dao.impl;

import com.instinctools.carsdealer.dao.IAd;
import com.instinctools.carsdealer.dao.IMessage;
import com.instinctools.carsdealer.dao.IUserAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Message extends BaseEntity implements IMessage {

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private IUserAccount senderId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private IUserAccount recipientId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Ad.class)
    private IAd adId;

    @Column
    private boolean viewed;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public IUserAccount getSenderId() {
        return senderId;
    }

    @Override
    public void setSenderId(IUserAccount senderId) {
        this.senderId = senderId;
    }

    @Override
    public IUserAccount getRecipientId() {
        return recipientId;
    }

    @Override
    public void setRecipientId(IUserAccount recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public IAd getAdId() { return adId; }

    @Override
    public void setAdId(IAd adId) {
        this.adId = adId;
    }

    @Override
    public boolean isViewed() {
        return viewed;
    }

    @Override
    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + getId() + '\'' +
                ", message='" + message + '\'' +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", adId=" + adId +
                ", viewed=" + viewed +
                '}';
    }
}
