package com.ibm.spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<CustomerTO> {
    public CustomerTO mapRow(ResultSet resultSet, int i) throws SQLException  {

        CustomerTO cto = new CustomerTO();
        cto.setCid(resultSet.getInt(1));
        cto.setCname(resultSet.getString(2));
        cto.setEmail(resultSet.getString(3));
        cto.setPhone(resultSet.getLong(4));
        cto.setCity(resultSet.getString(5));
        return cto;
    }
}
