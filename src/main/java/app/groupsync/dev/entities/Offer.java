package app.groupsync.dev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Default
@Entity
public class Offer extends PanacheEntityBase {
    private String offerer;
    private String name;
    private int capacity;
    private float price;
    private float length;
    private String location;
    private String uuid;

    @Transactional
    public static Offer createOffer(String offerer, String name, int capacity, float price, float length, String location) {
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Id
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
