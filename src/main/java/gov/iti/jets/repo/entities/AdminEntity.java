package gov.iti.jets.repo.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "admin")
public class AdminEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "AdminEntity [Name=" + name + ", email=" + email + ", id=" + id + "]";
    }

    
}
