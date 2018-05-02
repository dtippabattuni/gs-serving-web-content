/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import hello.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author dtippabattuni
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = Application.class)
public class SampleRepositoryTest {
    
    @Autowired
    SampleRepository sampleRepository;
    
    @Test
    public void test(){
        Assert.assertTrue(sampleRepository.getCustomersCount() > 0 );
    }
    
    @Test
    public void testAddCustomer(){
        Customer customer = new Customer();
        customer.setName("Dominic");
        customer.setDiscountCode("H");
        customer.setZip("95051");
        customer.setName("Dominic");
        customer.setAddressline1("20 Brickyard");
        customer.setAddressline2("");
        customer.setCity("Bloomington");
        customer.setState("IL");
        customer.setPhone("6185788423");
        customer.setFax("5342342342");
        customer.setEmail("dominic.tippabattuni@gmail.com");
        customer.setCreditLimit(30000);
        
        int id = sampleRepository.addCustomer(customer);
        
        System.out.println("Customer ID = " +id);
    }
}
