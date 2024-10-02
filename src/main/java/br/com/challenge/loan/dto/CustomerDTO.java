package br.com.challenge.loan.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.br.CPF;

public class CustomerDTO {

    @Min(value = 18, message = "Age above 18 only!")
    @NotNull(message = "Age must be not null!!")
    private Integer age;
    @CPF(message = "Invalid format!")
    @NotNull(message = "CPF must be not null!!")
    private String cpf;
    @NotBlank(message = "Name must be not null!")
    private String name;
    @PositiveOrZero(message = "Income must be positive value or zero!!")
    @NotNull(message = "Income must be not null!!")
    private Double income;
    @NotBlank(message = "Location must be not null!")
    private String location;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
