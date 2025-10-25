package com.caiodev.dsecommerce.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private LocalDate bithDate;

    private String password;

    //Muitos para 1.
    @OneToMany(mappedBy = "client") //referencia o cliente do pedido
    private List<Order> orders = new ArrayList<>();

    public User() {
    }



    public User(long id, String name, String email, String phone, LocalDate bithDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bithDate = bithDate;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(bithDate, that.bithDate) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, bithDate, password);
    }
}
