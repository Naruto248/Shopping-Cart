package com.shoppingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.shoppingcart.beans.Product;

@Component("Account")
public class Account {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> getAllProducts() {

		return jdbc.query("SELECT * FROM product", new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				p.setDesc(rs.getString("description"));
				return p;
			}

		});
	}

	public Product getOneProduct(int id) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return jdbc.queryForObject("SELECT * FROM product where id=:id", map, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				p.setDesc(rs.getString("description"));
				return p;
			}

		});
	}
}
