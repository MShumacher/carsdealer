package com.instinctools.carsdealer.dao;

public interface IMessage extends IBaseEntity {

    String getMessage();

    void setMessage(String message);

    IUserAccount getSenderId();

    void setSenderId(IUserAccount senderId);

    IUserAccount getRecipientId();

    void setRecipientId(IUserAccount recipientId);

    IAd getAdId();

    void setAdId(IAd adId);

    boolean isViewed();

    void setViewed(boolean viewed);
}
