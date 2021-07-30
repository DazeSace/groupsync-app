package app.groupsync.dev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.UUID;


@ApplicationScoped
@Default
@Entity
public class User extends PanacheEntityBase {

    private String firstname;
    private String lastname;
    private String birthday;
    private String uuid;


    @Transactional
    public static User userAdd(String firstname, String lastname, String birthday) {
        var user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setBirthday(birthday);
        user.persist();
        return user;
    }

    public static User findByUuid(String uuid) {
        return find("uuid", uuid).firstResult();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
