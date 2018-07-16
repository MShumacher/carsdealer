package com.instinctools.carsdealer.dao;

public interface ICarParameter extends IBaseEntity {

    String getBrand();

    void setBrand(String brand);

    String getEngineType();

    void setEngineType(String engineType);

    String getGearbox();

    void setGearbox(String gearbox);

    String getColor();

    void setColor(String color);
}
