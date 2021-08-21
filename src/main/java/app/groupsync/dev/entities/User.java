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
public class User extends PanacheEntityBase {

    private String firstname;
    private String lastname;
    private String birthday;
    private String uuid;
    private String email;
    private String password;

    @Transactional
    public static User create(String firstname, String lastname, String birthday, String email, String password) {
        var user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setPassword(password);
        user.setUuid(generateUuid());
        user.persist();
        return user;
    }

    public static User findByUuid(String uuid) {
        return find("uuid", uuid).firstResult();
    }

    public static User findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public static List<User> getAll() {
        return listAll();
    }

    public boolean checkPassword(String password) {
        return password.equals(getPassword());
    }

    //Getter and Setter

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static String generateUuid() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (findByUuid(uuid.toString()) != null);
        return uuid.toString();
    }

    public String getEmail() {
        return email;
    }
}
