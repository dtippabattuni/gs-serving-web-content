/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import hello.domain.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dtippabattuni
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    SampleRepository sampleRepository;
    
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        System.out.println("customer name="+ customer.getName());
        
        model.addAttribute("name", customer.getName());
        return "greeting";
    }
    
    @GetMapping("/list")
    public String greeting(Model model) {
        int count = sampleRepository.getCustomersCount();
        List<Customer> customers = sampleRepository.getCustomers();
        model.addAttribute("count", count);
        model.addAttribute("customers", customers);  
        return "customer";
    }
}
