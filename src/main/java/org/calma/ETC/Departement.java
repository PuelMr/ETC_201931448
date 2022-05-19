package org.calma.ETC;

public class Departement extends AbstractObject {
    public Departement(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Departement() {
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
