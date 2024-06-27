package com.juliomesquita.ecommerce.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Customer {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Address address;
}
