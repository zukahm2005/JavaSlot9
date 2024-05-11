package test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import test.entity.Entity;

public class Model<T extends Entity<?>> {
    private List<T> entities = new ArrayList<>();

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public List<T> getEntities() {
        return entities;
    }

    public Optional<T> findEntityById(Object id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    public List<T> getAllEntities() {
        return new ArrayList<>(entities);
    }

    public boolean updateNameEntity(T updatedEntity) {
        Optional<T> optionalEntity = findEntityById(updatedEntity.getId());
        if (optionalEntity.isPresent()) {
            T existingEntity = optionalEntity.get();
            // Update fields
            // Example: existingEntity.setName(updatedEntity.getName());
            return true;
        }
        return false;
    }

    public boolean deleteEntity(Object id) {
        Optional<T> optionalEntity = findEntityById(id);
        if (optionalEntity.isPresent()) {
            entities.remove(optionalEntity.get());
            return true;
        }
        return false;
    }
}