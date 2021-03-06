package com.instinctools.carsdealer.dao.impl;

import com.instinctools.carsdealer.dao.IAd;
import com.instinctools.carsdealer.dao.IModel;
import com.instinctools.carsdealer.dao.IParameter;
import com.instinctools.carsdealer.dao.IUserAccount;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ad extends BaseEntity implements IAd {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private IUserAccount userAccountId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Model.class)
    private IModel modelId;

    @Column
    private String engineTypeName;

    @Column
    private Integer engineVolume;

    @Column
    private String gearboxName;

    @Column
    private Integer year;

    @Column
    private Integer mileage;

    @Column
    private String color;

    @Column
    private Integer price;

    @Column
    private boolean barter;

    @Column
    private boolean active;

    @JoinTable(name = "ad_parameter", joinColumns = { @JoinColumn(name = "ad_id") }, inverseJoinColumns = {
            @JoinColumn(name = "parameter_id") })
    @ManyToMany(targetEntity = Parameter.class, fetch = FetchType.LAZY)
//    @OrderBy("title ASC")
    private Set<IParameter> engines = new HashSet<>();

    @Override
    public IUserAccount getUserAccountId() {
        return userAccountId;
    }

    @Override
    public void setUserAccountId(IUserAccount userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public IModel getModelId() {
        return modelId;
    }

    @Override
    public void setModelId(IModel modelId) {
        this.modelId = modelId;
    }

    @Override
    public String getEngineTypeName() {
        return engineTypeName;
    }

    @Override
    public void setEngineTypeName(String engineTypeName) {
        this.engineTypeName = engineTypeName;
    }

    @Override
    public Integer getEngineVolume() {
        return engineVolume;
    }

    @Override
    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String getGearboxName() {
        return gearboxName;
    }

    @Override
    public void setGearboxName(String gearboxName) {
        this.gearboxName = gearboxName;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public Integer getMileage() {
        return mileage;
    }

    @Override
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean isBarter() {
        return barter;
    }

    @Override
    public void setBarter(boolean barter) {
        this.barter = barter;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Set<IParameter> getEngines() {
        return engines;
    }

    @Override
    public void setEngines(Set<IParameter> engines) {
        this.engines = engines;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + getId() + '\'' +
                ", userAccountId=" + userAccountId +
                ", modelId=" + modelId +
                ", engineTypeName='" + engineTypeName + '\'' +
                ", engineVolume=" + engineVolume +
                ", gearboxName='" + gearboxName + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", barter=" + barter +
                ", active=" + active +
                ", engines=" + engines +
                '}';
    }
}
