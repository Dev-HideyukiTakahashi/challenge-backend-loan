package br.com.challenge.loan.services;

import br.com.challenge.loan.entities.Customer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Nested
    class personalLoan {

        @Test
        void shouldBeTrueWhenIncomeBetween() {
            Customer customer = CustomerFactory.build(4200.00);
            assertTrue(customer.getIncome() > 3000.0 && customer.getIncome() < 5000.0);
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            Customer customer = CustomerFactory.build(2600.00);
            assertTrue(customer.getIncome() <= 3000.00);
        }

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            Customer customer = CustomerFactory.build(22);
            assertTrue(customer.getAge() < 30);
        }

        @Test
        void shouldBeTrueWhenLocationEquals() {
            Customer customer = CustomerFactory.build("SP");
            assertEquals("SP", customer.getLocation());
        }
    }

    @Nested
    class consignmentLoan {

        @Test
        void shouldBeTrueWhenIncomeIsHigherOrEquals() {
            Customer customer = CustomerFactory.build(5000.00);
            assertTrue(customer.getIncome() >= 5000.0);
        }
    }

    @Nested
    class guaranteedLoan {
        @Test
        void shouldBeTrueWhenIncomeBetween() {
            Customer customer = CustomerFactory.build(4200.00);
            assertTrue(customer.getIncome() > 3000.0 && customer.getIncome() < 5000.0);
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            Customer customer = CustomerFactory.build(2600.00);
            assertTrue(customer.getIncome() <= 3000.00);
        }

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            Customer customer = CustomerFactory.build(22);
            assertTrue(customer.getAge() < 30);
        }

        @Test
        void shouldBeTrueWhenLocationEquals() {
            Customer customer = CustomerFactory.build("SP");
            assertEquals("SP", customer.getLocation());
        }
    }
}