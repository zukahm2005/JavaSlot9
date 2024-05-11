package test.model;

import test.entity.*;
import test.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Model<T extends Entity<?>> {
    private List<T> entities = new ArrayList<>();
    public void addEntity(T entity){
        entities.add(entity);
    }
    public List<T> getAllEntities(){
        return entities;
    }
}
