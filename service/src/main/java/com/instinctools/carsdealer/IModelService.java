package com.instinctools.carsdealer;

import com.instinctools.carsdealer.dao.IModel;

import javax.transaction.Transactional;
import java.util.List;

public interface IModelService {

        IModel createEntity();

        IModel get(Integer id);

        List<IModel> selectAll();

        List<IModel> selectAllFullInfo();

        @Transactional
        void save(IModel entity);

        @Transactional
        void delete(Integer id);

        @Transactional
        void deleteAll();



//        List<IModel> find(ModelFilter filter);
//
//        long getCount(ModelFilter filter);

    }

