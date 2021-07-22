package app.groupsync.dev;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.transaction.Transactional;


@ApplicationScoped
@Default
@Entity
public class User extends PanacheEntity {

    private String firstname;
    private String lastname;
    private String birthday;

    @Transactional
    public static User userAdd(String firstname, String lastname, String birthday) {
        var user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setBirthday(birthday);
        user.persist();
        return user;
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
}
