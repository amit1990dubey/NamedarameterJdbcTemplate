package com.ibm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class Lab59 {

    public static void main(String[] args)  {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ibmindia.xml");
        CustomerDAO cdao = (CustomerDAO) ctx.getBean("cdao");

        //1. add customer
        CustomerTO cto = new CustomerTO(2100,"amit","a@gmail.com",99999,"Bangalore");
        cdao.addCustomer(cto);

        //2. update customer

        CustomerTO cto1 = new CustomerTO(2101,"atul","at@gmail.com",6767676,"Trv");
        cdao.updateCustomer(cto1);

        //3. delete customer
        cdao.deleteCustomer(205);

        //4. fetCustomerCid
        System.out.println("getCustomerByCid");
        CustomerTO cto2 = cdao.getCustomerBYCid(2101);
        System.out.println(cto2);


        //5. getAllCustomers
        System.out.println("getAllCustomers");
        List<CustomerTO> list = cdao.getAllCustomers();
        for(CustomerTO ct : list)
        {
            System.out.println(ct);
        }



    }
}
