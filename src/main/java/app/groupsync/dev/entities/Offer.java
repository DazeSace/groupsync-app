package app.groupsync.dev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.transaction.Transactional;

@ApplicationScoped
@Default
@Entity
public class Offer extends PanacheEntity {
    private String offerer;
    private String name;
    private int capacity;
    private float price;
    private float length;
    private String location;

    @Transactional
    public static Offer createOffer(String offerer, String name, int capacity, float price, float length, String location) {
        var offer = new Offer();
        offer.setOfferer(offerer);
        offer.setName(name);
        offer.setCapacity(capacity);
        offer.setPrice(price);
        offer.setLength(length);
        offer.setLocation(location);
        offer.persist();
        return offer;
    }

    public String getOfferer() {
        return offerer;
    }

    public void setOfferer(String offerer) {
        this.offerer = offerer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
