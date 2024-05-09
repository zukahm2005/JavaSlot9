package session14.controller;

import java.util.List;

import session14.entity.Entity;
import session14.model.Model;

public class ControllerCustomers<T extends Entity<?>> {
    public Model<T> model;

    public ControllerCustomers(Model<T> model) {
        this.model = model;
    }

    public void addEntityController(T entity) {
        model.addEntity(entity);
    }

    public List<T> getAllEntityController() {
        return model.getEntities();
    }
}
