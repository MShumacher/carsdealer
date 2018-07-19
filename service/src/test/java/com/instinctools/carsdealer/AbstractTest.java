package com.instinctools.carsdealer;

import com.instinctools.carsdealer.dao.IModel;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = "classpath:test-context.xml")
    public abstract class AbstractTest {

        @Autowired
        private IModelService modelService;

        private static final Random RANDOM = new Random();

        protected int getRandomPrefix() {
            return RANDOM.nextInt(99999);
        }

        protected int getRandomObjectsCount() {
            return RANDOM.nextInt(9) + 1;
        }

        public IModelService getModelService() {
            return modelService;
        }

        public Random getRANDOM() {
            return RANDOM;
        }

        protected IModel saveNewModel() {
            final IModel entity = getModelService().createEntity();
            entity.setName("Name-"+getRandomPrefix());
            entity.setBrand("Brand-" + getRandomPrefix());
            getModelService().save(entity);
            return entity;
        }
}
