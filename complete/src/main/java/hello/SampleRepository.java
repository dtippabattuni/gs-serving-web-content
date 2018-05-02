/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import hello.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dtippabattuni
 */
@Repository
public class SampleRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int getCustomersCount(){
       Integer count = jdbcTemplate.queryForObject("Select count(*) from APP.CUSTOMER", new Object[]{}, Integer.class);
       System.out.println("Count =" + count);
       return count;
    }
    
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        String sql = "SELECT * FROM CUSTOMER ORDER BY NAME";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        
        for(Map<String,Object> row : rows){
             Customer customer = new Customer();
            customer.setCustomerId((Integer)row.get("CUSTOMER_ID"));
            customer.setName((String)row.get("NAME"));
            customer.setDiscountCode((String)row.get("DISCOUNT_CODE"));
            customer.setAddressline1((String)row.get("ADDRESSLINE1"));
            customer.setAddressline2((String)row.get("ADDRESSLINE2"));
            customer.setCity((String)row.get("CITY"));
            customer.setState((String)row.get("STATE"));
            customer.setPhone((String)row.get("PHONE"));
            customer.setFax((String)row.get("FAX"));
            customer.setCreditLimit((Integer)row.get("CREDIT_LIMIT"));
            
            customers.add(customer);
        }

        System.out.println("Size = " + customers.size());
        return customers;
    }
    
    @Transactional
    public int addCustomer(Customer customer){
    
        Integer maxId = jdbcTemplate.queryForObject("Select max(customer_id) from APP.CUSTOMER", new Object[]{}, Integer.class);
        customer.setCustomerId(maxId + 1);
        String sql = "insert into APP.CUSTOMER values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
            customer.getCustomerId(),
            customer.getDiscountCode(),
            customer.getZip(),
            customer.getName(),
            customer.getAddressline1(),
            customer.getAddressline2(),
            customer.getCity(),
            customer.getState(),
            customer.getPhone(),
            customer.getFax(),
            customer.getEmail(),
            customer.getCreditLimit()
        });
        
        System.out.println("Successfully added customer!");
        return customer.getCustomerId();
    }
	
}
