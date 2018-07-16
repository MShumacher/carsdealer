package com.instinctools.carsdealer;

import com.instinctools.carsdealer.dao.IModel;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelServiceTest extends AbstractTest {

    @Test
    public void testCreate() {
        final IModel entity = saveNewModel();

        final IModel entityFromDb = getModelService().get(entity.getId());

        assertEquals(entity.getName(), entityFromDb.getName());
        assertEquals(entity.getBrand(), entityFromDb.getBrand());
        assertNotNull(entityFromDb.getId());
        assertNotNull(entityFromDb.getCreated());
        assertNotNull(entityFromDb.getUpdated());
        assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
    }

    @Test
    public void testUpdate() throws InterruptedException {
        final IModel entity = saveNewModel();

        final IModel entityFromDB = getModelService().get(entity.getId());
        final String newName = "new-name-" + getRandomPrefix();
        entityFromDB.setName(newName);

        Thread.sleep(2); // make a short delay to see a new date in 'updated'
        // column
        getModelService().save(entityFromDB);

        final IModel udpatedEntityFromDB = getModelService().get(entityFromDB.getId());
        assertEquals(newName, udpatedEntityFromDB.getName());
        assertEquals(entity.getBrand(), udpatedEntityFromDB.getBrand());
        assertEquals(entity.getCreated(), udpatedEntityFromDB.getCreated());
        assertTrue(entity.getUpdated().after(udpatedEntityFromDB.getUpdated()));
    }


    @Test
    public void testDelete() {
        final IModel entity = saveNewModel();
        getModelService().delete(entity.getId());
        assertNull(getModelService().get(entity.getId()));
    }
}
