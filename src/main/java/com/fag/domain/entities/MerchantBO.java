package com.fag.domain.entities;

public class MerchantBO {
    
    private String postalCode;

    private String city;

    private String categoryCode;

    private String name;

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getName() {
        return name;
    }

    public MerchantBO(String postalCode, String city, String merchantCategoryCode, String name) {
        this.postalCode = postalCode;
        this.city = city;
        this.categoryCode = merchantCategoryCode;
        this.name = name;
    }
}
