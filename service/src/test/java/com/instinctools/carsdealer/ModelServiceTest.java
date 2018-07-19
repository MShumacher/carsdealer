package com.instinctools.carsdealer;

import com.instinctools.carsdealer.dao.IModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelServiceTest extends AbstractTest {

    @Before
    public void cleanTables() {
        getModelService().deleteAll();
    }

    @Test
    public void testCreate() {
        final IModel entity = saveNewModel();

        final IModel entityFromDB = getModelService().get(entity.getId());

        assertEquals(entity.getId(), entityFromDB.getId());
        assertEquals(entity.getName(), entityFromDB.getName());
        assertEquals(entity.getBrand(), entityFromDB.getBrand());
//        assertEquals(entity.getCreated().getTime(),entityFromDB.getCreated().getTime());
//        assertEquals(entity.getUpdated().getTime(),entityFromDB.getUpdated().getTime());
        assertNotNull(entityFromDB.getId());
        assertNotNull(entityFromDB.getName());
        assertNotNull(entityFromDB.getBrand());
        assertNotNull(entityFromDB.getCreated());
        assertNotNull(entityFromDB.getUpdated());

        assertEquals(entityFromDB.getCreated().getTime(),entityFromDB.getUpdated().getTime());
    }

    @Test
    public void testUpdate() throws InterruptedException {
        final IModel entity = saveNewModel();

        final IModel entityFromDB = getModelService().get(entity.getId());
        final String newName = "new-name-" + getRandomPrefix();
        entityFromDB.setName(newName);

        Thread.sleep(2); // make a short delay to see a new date in 'updated' column
        getModelService().save(entityFromDB);

        final IModel updatedEntityFromDB = getModelService().get(entityFromDB.getId());
        assertEquals(entityFromDB.getId(), updatedEntityFromDB.getId());
        assertEquals(newName, updatedEntityFromDB.getName());
        assertEquals(entityFromDB.getBrand(), updatedEntityFromDB.getBrand());
//        assertEquals(entityFromDB.getCreated().getTime(),updatedEntityFromDB.getCreated().getTime());

        assertTrue(entityFromDB.getUpdated().after(updatedEntityFromDB.getUpdated()));
     }


    @Test
    public void testDelete() {
        final IModel entity = saveNewModel();
        getModelService().delete(entity.getId());
        assertNull(getModelService().get(entity.getId()));
    }

//    @Test
//    public void testDeleteAll() {
//        saveNewModel();
//        getModelService().deleteAll();
//        assertEquals(0, getModelService().getAll().size());
//    }
}
