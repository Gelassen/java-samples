package model;

import javax.persistence.*;

/**
 * Created by Gleichmut on 6/14/2014.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="Medicine.isExists",
                query="select m from Medicine m where m.name = :name and m.serial = :serial and m.factory = :factory"),
        @NamedQuery(name="Medicine.findByName", query="select m from Medicine m where m.name = :name")
})
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serial;
    private String factory;

    public Medicine() {
    }

    public Medicine(String name, String serial, String factory) {
        this.name = name;
        this.serial = serial;
        this.factory = factory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
