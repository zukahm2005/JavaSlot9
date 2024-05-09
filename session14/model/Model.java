package session14.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import session14.entity.Entity;

public class Model<T extends Entity<?>> {
    private List<T> entities = new ArrayList<>();

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public List<T> getEntities() {
        return entities;
    }
}
