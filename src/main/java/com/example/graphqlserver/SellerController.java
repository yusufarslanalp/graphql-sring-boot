package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SellerController {


    @QueryMapping
    public Seller getSeller() {
        return Seller.getSeller();
    }
}