package com.ibm.spring;

import java.util.List;

public interface CustomerDAO {

    public void addCustomer(CustomerTO cto);

    public void updateCustomer(CustomerTO cto);

    public void deleteCustomer(int cid);

    public CustomerTO getCustomerBYCid(int cid);

    public List<CustomerTO> getAllCustomers();
}
