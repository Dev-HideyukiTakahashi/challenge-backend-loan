package br.com.challenge.loan.services;

import br.com.challenge.loan.entities.Customer;

public class CustomerFactory {

    public static Customer build() {
        return new Customer(26, "275.484.389-23",
                "Vuxaywua Zukiagou", 7000.0, "SP");
    }

    public static Customer build(int age) {
        return new Customer(age, "275.484.389-23",
                "Vuxaywua Zukiagou", 7000.0, "SP");
    }

    public static Customer build(double income) {
        return new Customer(26, "275.484.389-23",
                "Vuxaywua Zukiagou", income, "SP");
    }

    public static Customer build(String location) {
        return new Customer(26, "275.484.389-23",
                "Vuxaywua Zukiagou", 5000.00, location);
    }
}
