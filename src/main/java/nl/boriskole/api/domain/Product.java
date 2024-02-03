package nl.boriskole.api.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "out_of_stock", nullable = false)
    private Boolean outOfStock;

    public Product() { }

    public Product(Long id, String name, Double price, Boolean outOfStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.outOfStock = outOfStock;
    }

    public Product(String name, Double price, Boolean outOfStock) {
        this.name = name;
        this.price = price;
        this.outOfStock = outOfStock;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());

        return result;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;

        return Objects.equals(id, other.id);

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", outOfStock=" + outOfStock +
                '}';
    }

}
