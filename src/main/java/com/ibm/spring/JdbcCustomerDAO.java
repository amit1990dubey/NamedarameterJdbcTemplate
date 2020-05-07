package com.ibm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcCustomerDAO implements CustomerDAO {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void addCustomer(CustomerTO cto) {


            String sql = "insert into customers values(:cid,:cname,:email,:phone,:city)";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("cid", cto.getCid());
            parameters.put("cname", cto.getCname());
            parameters.put("email", cto.getEmail());
            parameters.put("phone", cto.getPhone());
            parameters.put("city", cto.getCity());




    }
    public void updateCustomer(CustomerTO cto) {

        String sql = "update customer set cname =:cname, email = :email,phone=:phone,city=:city,where cid =:cid";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cname", cto.getCname());
        parameters.put("email", cto.getEmail());
        parameters.put("phone", cto.getPhone());
        parameters.put("city", cto.getCity());
        parameters.put("cid", cto.getCid());

    }
    public void deleteCustomer(int cid) {

        String sql = "delete from customers where cid =:cid";

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("cid", cid);
        namedParameterJdbcTemplate.update(sql, parameter);
    }
    public CustomerTO getCustomerBYCid(int cid) throws  EmptyResultDataAccessException {




            String sql = "select * from customers where cid =:cid";
            SqlParameterSource parameter = new MapSqlParameterSource("cid", cid);

            CustomerTO cto = (CustomerTO) namedParameterJdbcTemplate.queryForObject(sql, parameter, new CustomerRowMapper());



        return cto;
    }
    public List<CustomerTO> getAllCustomers() throws EmptyResultDataAccessException {


            String sql = "select * from customers";
            Map<String, ?> map = null;
            List<CustomerTO> list = (List<CustomerTO>) namedParameterJdbcTemplate.query(sql, map, new CustomerRowMapper());


        return list;
    }


}







