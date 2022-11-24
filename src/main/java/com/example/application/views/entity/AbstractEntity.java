package com.example.application.views.entity;

import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
/*A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity except
that the mappings will apply only to its subclasses since no table exists for the mapped superclass itself.
When applied to the subclasses the inherited mappings will apply in the context of the subclass tables.
Mapping information may be overridden in such subclasses by using the AttributeOverride and AssociationOverride
annotations or corresponding XML elements.*/

public abstract class AbstractEntity {

    @Id //indica que este será un ID, el identificador propio
    @GeneratedValue //autogenera el ID
    @Type(type = "uuid-char")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity)) {
            return false; // null or other class
        }
        AbstractEntity other = (AbstractEntity) obj;

        if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }
}
