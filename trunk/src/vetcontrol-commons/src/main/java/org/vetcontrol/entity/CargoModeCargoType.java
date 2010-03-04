/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Artem
 */
@Entity
@Table(name = "cargo_mode_cargo_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CargoModeCargoType implements IUpdated, IQuery, IEmbeddedId<CargoModeCargoType.Id> {

    @Embeddable
    @XmlType
    public static class Id implements Serializable {

        @Column(name = "cargo_mode_id")
        private Long cargoModeId;
        @Column(name = "cargo_type_id")
        private Long cargoTypeId;

        public Id() {
        }

        public Id(Long cargoModeId, Long cargoTypeId) {
            this.cargoModeId = cargoModeId;
            this.cargoTypeId = cargoTypeId;
        }

        public void setCargoModeId(Long cargoModeId) {
            this.cargoModeId = cargoModeId;
        }

        public Long getCargoModeId() {
            return cargoModeId;
        }

        public void setCargoTypeId(Long cargoTypeId) {
            this.cargoTypeId = cargoTypeId;
        }

        public Long getCargoTypeId() {
            return cargoTypeId;
        }

        @Override
        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.cargoModeId.equals(that.cargoModeId)
                        && this.cargoTypeId.equals(that.cargoTypeId);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return 2*cargoModeId.hashCode() + 3*cargoTypeId.hashCode();
        }
    }
    @EmbeddedId
    private Id id = new Id();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_mode_id", insertable = false, updatable = false)
    @XmlTransient
    private CargoMode cargoMode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_type_id", insertable = false, updatable = false)
    @XmlTransient
    private CargoType cargoType;

    @Transient
    @XmlTransient
    private boolean needToUpdateVersion;

    public CargoModeCargoType() {
    }

    public CargoMode getCargoMode() {
        return cargoMode;
    }

    public void setCargoMode(CargoMode cargoMode) {
        this.cargoMode = cargoMode;
        id.setCargoModeId(cargoMode.getId());
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
        if (cargoType != null) {
            id.setCargoTypeId(cargoType.getId());
        } else {
            id.setCargoTypeId(null);
        }
    }

    @Override
    public Id getId() {
        return id;
    }

    @Override
    public void setId(Id id) {
        this.id = id;
    }

    public boolean isNeedToUpdateVersion() {
        return needToUpdateVersion;
    }

    public void setNeedToUpdateVersion(boolean needToUpdateVersion) {
        this.needToUpdateVersion = needToUpdateVersion;
    }

    @Column(name = "updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public Query getInsertQuery(EntityManager em) {
        return em.createNativeQuery("insert into cargo_mode_cargo_type (cargo_mode_id, cargo_type_id, updated) " +
                "value (:cargo_mode_id, :cargo_type_id, :updated)")
                .setParameter("cargo_mode_id", id.cargoModeId)
                .setParameter("cargo_type_id", id.cargoTypeId)
                .setParameter("updated", updated);
    }

    @Override
    public Query getUpdateQuery(EntityManager em) {
        return em.createNativeQuery("update cargo_mode_cargo_type set updated = :updated  " +
                "where cargo_mode_id = :cargo_mode_id and cargo_type_id = :cargo_type_id")
                .setParameter("cargo_mode_id", id.cargoModeId)
                .setParameter("cargo_type_id", id.cargoTypeId)
                .setParameter("updated", updated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoModeCargoType)) return false;

        CargoModeCargoType that = (CargoModeCargoType) o;

        if (cargoMode != null ? !cargoMode.equals(that.cargoMode) : that.cargoMode != null) return false;
        if (cargoType != null ? !cargoType.equals(that.cargoType) : that.cargoType != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cargoMode != null ? cargoMode.hashCode() : 0);
        result = 31 * result + (cargoType != null ? cargoType.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "cmId = "+id.cargoModeId + " ctId = "+id.cargoTypeId;
    }
}
