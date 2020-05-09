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
        namedParameterJdbcTemplate.update(sql,parameters);

    }

    public void updateCustomer(CustomerTO cto) {

        String sql = "update customers set cname =:cname, email = :email,phone=:phone,city=:city,where cid =:cid";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cname", cto.getCname());
        parameters.put("email", cto.getEmail());
        parameters.put("phone", cto.getPhone());
        parameters.put("city", cto.getCity());
        parameters.put("cid", cto.getCid());
        namedParameterJdbcTemplate.update(sql,parameters);

    }

    public void deleteCustomer(int cid) {

        String sql = "delete from customers where cid =:cid";

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("cid", cid);
        namedParameterJdbcTemplate.update(sql, parameter);
    }

    public CustomerTO getCustomerBYCid(int cid) throws EmptyResultDataAccessException {

        try {


            String sql = "select * from customers where cid =:cid";
            SqlParameterSource parameter = new MapSqlParameterSource("cid", cid);

            CustomerTO cto = (CustomerTO) namedParameterJdbcTemplate.queryForObject(sql, parameter, new CustomerRowMapper());


            return cto;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomerTO> getAllCustomers() {

        try {
            String sql = "select * from customers";
            Map<String, Object> map = new HashMap<String,Object>();
            List<CustomerTO> list = (List<CustomerTO>) namedParameterJdbcTemplate.query(sql, map, new CustomerRowMapper());


            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}







