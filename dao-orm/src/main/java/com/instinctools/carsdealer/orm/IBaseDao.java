package com.instinctools.carsdealer.orm;

import java.util.List;

public interface IBaseDao<ENTITY, ID> {

    ENTITY createEntity();

    ENTITY get(ID id);

    void update(ENTITY entity);

    void insert(ENTITY entity);

    void delete(ID id);

    void deleteAll();

//    List<ENTITY> selectAll();

//    ENTITY getFullInfo(ID id);

//    List<ENTITY> getAllFullInfo();
}
