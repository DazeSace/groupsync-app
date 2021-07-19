package app.groupsync.dev;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.time.LocalDateTime;


@ApplicationScoped
@Default
@Entity

public class User extends PanacheEntity {

    private String firstname;
    private String lastname;
    private LocalDateTime birthday;
}
