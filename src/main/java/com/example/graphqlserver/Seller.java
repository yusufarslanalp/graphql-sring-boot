package com.example.graphqlserver;

public record Seller(String name, Product product) {
    public static Seller getSeller(){
        return new Seller("n11", new Product("air-fryer"));
    }
}
