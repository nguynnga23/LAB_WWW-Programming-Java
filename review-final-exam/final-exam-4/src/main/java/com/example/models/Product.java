package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Pattern(regexp = "^Pro\\d{3}-(0[1-9]|1[0-2])$", message = "Code must be in ProXXX-MM format (Example : Pro123-05).")
    private String code;

    @Size(max = 20, message = "Name must not exceed 20 characters.")
    private String name;
    @NotBlank(message = "Description must not be blank.")
    private String description;

    @PastOrPresent(message = "Register date must be the previous day or equals to the current day.")
    @Column(name = "register_date")
    private Date registerDate;

    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be a real number and greater than 0.")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Category category;

}
