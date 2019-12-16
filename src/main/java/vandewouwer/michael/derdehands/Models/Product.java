package vandewouwer.michael.derdehands.Models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 4, max = 30,message = "Vul je naam in")
    private String gebruikersnaam;
    @NotBlank(message = "vul je e-mailadres in")
    private String email;
    @NotBlank(message = "mag niet leeg zijn")
    private String productnaam;
    @NotBlank (message = "Beschrijf je artikel")
    @Column(columnDefinition = "text")
    private String omschrijving;
    @DecimalMin(value = "0.05")
    private double initprijs;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public void setProductnaam(String productnaam) {
        this.productnaam = productnaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getInitprijs() {
        return initprijs;
    }

    public void setInitprijs(double initprijs) {
        this.initprijs = initprijs;
    }
}
