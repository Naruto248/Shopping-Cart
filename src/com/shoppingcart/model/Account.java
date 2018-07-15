package com.shoppingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shoppingcart.beans.Product;
import com.shoppingcart.beans.Vendor;

@Component("Account")
public class Account {
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passenc;

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
	
	public void createVendor(Vendor v) {
		//BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(v);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", v.getName());
		map.put("city", v.getCity());
		map.put("email", v.getEmail());
		map.put("password", passenc.encode(v.getPassword()));
		map.put("enabled", v.getEnabled());
		map.put("authority", v.getAuthority());
		jdbc.update("INSERT INTO vendor(name, city, email) VALUES(:name, :city, :email)", map);
		jdbc.update("INSERT INTO users(username, password, enabled) VALUES(:email, :password, :enabled)", map);
		jdbc.update("INSERT INTO authorities(username, authority) VALUES(:email, :authority)", map);
	}
}
