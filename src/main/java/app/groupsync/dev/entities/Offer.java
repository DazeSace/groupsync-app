package app.groupsync.dev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Default
@Table
@Entity
public class Offer extends PanacheEntityBase {
    private String offerer;
    private String name;
    private int capacity;
    private double price;
    private double length;
    private String location;
    @Id
    private String uuid;

    @Transactional
    public static Offer create(String offerer, String name, int capacity, double price, double length, String location) {
        var offer = new Offer();
        offer.setOfferer(offerer);
        offer.setName(name);
        offer.setCapacity(capacity);
        offer.setPrice(price);
        offer.setLength(length);
        offer.setLocation(location);
        offer.setUuid(generateUuid());
        offer.persist();
        return offer;
    }

    public static Offer findByUuid(String uuid) {
        return find("uuid", uuid).firstResult();
    }

    public static List<Offer> getAll() {
        return listAll();
    }

    // Getter and Setter

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    private static String generateUuid() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (findByUuid(uuid.toString()) != null);
        return uuid.toString();
    }
}
