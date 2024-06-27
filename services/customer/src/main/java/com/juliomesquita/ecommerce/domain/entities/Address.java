package com.juliomesquita.ecommerce.domain.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Validated
public class Address {
    private String nameRecipient;
    private String zipCode;
    private String state;
    private String city;
    private String district;
    private String street;
    private String numberHouse;
    private String complement;
    private String additionalInformation;
}
