package controller.crypter;

import model.entity.Entity;

public class SecurityEntity<T extends Entity> {
    private int fakeId;

    private T entity;

    public SecurityEntity(int fakeId, T entity) {
        this.fakeId = fakeId;
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
