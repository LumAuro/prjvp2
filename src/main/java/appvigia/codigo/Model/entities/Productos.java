package appvigia.codigo.Model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(length = 255, name = "name")
    private String name;
    @Column(length = 255, name = "brand")
    private String brand;
    @Column(length = 255, name = "description")
    private String description;
    @Column(name = "ean13")
    private String ean13;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Productos() {
    }

    public Productos(long id, String name, String brand, String description, String ean13) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.ean13 = ean13;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    @Override
    public String toString() {
        return "Productos [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description
                + ", ean13=" + ean13 + "]";
    }

}
