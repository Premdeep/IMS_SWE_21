package com.hpp.ims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hpp.ims.model.Hospital;
import com.hpp.ims.model.HospitalInventory;
import com.hpp.ims.model.Orders;
import com.hpp.ims.model.Supplier;
import com.hpp.ims.model.SupplierInventory;

@Repository
public class ImsDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	public Hospital getHospitalDetailById(int hospitalId) {

		String sql = "select * from hospital where hospital_id = ?";
		Hospital hospital = jdbctemplate.queryForObject(sql, new RowMapper<Hospital>() {

			@Override
			public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {

				Hospital h = new Hospital();

				h.setHospitalId(hospitalId);
				h.setHospitalName(rs.getString("hospital_name"));
				h.setCity(rs.getString("city"));
				h.setState(rs.getString("state"));
				h.setCountry(rs.getString("country"));
				h.setEmailId(rs.getString("email_id"));
				return h;
			}
		}, hospitalId);
		return hospital;
	}

	public Hospital getHospitalDetailByName(String hospitalName) {

		String sql = "select * from hospital where hospital_name like ?";
		Hospital hospital = jdbctemplate.queryForObject(sql, new RowMapper<Hospital>() {

			@Override
			public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {

				Hospital h = new Hospital();

				h.setHospitalId(rs.getInt("hospital_id"));
				h.setHospitalName(hospitalName);
				h.setCity(rs.getString("city"));
				h.setState(rs.getString("state"));
				h.setCountry(rs.getString("country"));
				h.setEmailId(rs.getString("email_id"));
				return h;
			}
		}, hospitalName);

		return hospital;
	}

	public Supplier getSupplierDetailById(int supplierId) {

		String sql = "select * from supplier where supplier_id = ?";
		Supplier supplier = jdbctemplate.queryForObject(sql, new RowMapper<Supplier>() {

			@Override
			public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {

				Supplier s = new Supplier();
				s.setSupplierId(supplierId);
				s.setSupplierName(rs.getString("supplier_name"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setEmailId(rs.getString("email_id"));

				return s;
			}
		}, supplierId);

		return supplier;
	}

	public List<HospitalInventory> getHospitalProdcutsDetailByHospitalId(int hospitalId) {

		String sql = "select * from hospital_inventory where hospital_id = ? ";
		List<HospitalInventory> hospitalinventory = jdbctemplate.query(sql, new RowMapper<HospitalInventory>() {

			@Override
			public HospitalInventory mapRow(ResultSet rs, int rowNum) throws SQLException {

				HospitalInventory hi = new HospitalInventory();
				hi.setHospitalInventoryId(rs.getInt("hospital_inventory_id"));
				hi.setHospitalId(hospitalId);
				hi.setProductId(rs.getInt("product_id"));
				hi.setProductName(rs.getString("product_name"));
				hi.setCurrentQuantity(rs.getInt("current_quantity"));
				hi.setMinQuanReq(rs.getInt("min_quan_req"));
				hi.setMaxQuantity(rs.getInt("max_quantity"));
				hi.setProductPrice(rs.getInt("product_price"));
				return hi;
			}
		}, hospitalId);

		return hospitalinventory;
	}

	public List<SupplierInventory> getSupplierProdcutsDetailBySupplierId(int supplierId) {
		String sql = "select * from supplier_inventory where supplier_id = ? ";
		List<SupplierInventory> supplierinventory = jdbctemplate.query(sql, new RowMapper<SupplierInventory>() {

			@Override
			public SupplierInventory mapRow(ResultSet rs, int rowNum) throws SQLException {

				SupplierInventory si = new SupplierInventory();
				si.setSupplierInventoryId(rs.getInt("supplier_inventory_id"));
				si.setSupplierId(supplierId);
				si.setProductId(rs.getInt("product_id"));
				si.setProductName(rs.getString("product_name"));
				si.setCurrentQuantity(rs.getInt("current_quantity"));
				si.setProductPrice(rs.getInt("product_price"));

				return si;
			}
		}, supplierId);

		return supplierinventory;
	}

	// ------- NEW API's ---------
	public List<SupplierInventory> getSupplierProductsDetails() {
		String sql = "select product_name from supplier_inventory";
		List<SupplierInventory> supplierinventory = jdbctemplate.query(sql, new RowMapper<SupplierInventory>() {

			@Override
			public SupplierInventory mapRow(ResultSet rs, int rowNum) throws SQLException {

				SupplierInventory si = new SupplierInventory();
				si.setProductName(rs.getString("product_name"));

				return si;
			}
		});

		return supplierinventory;
	}

	public void saveOrderDetails(Orders orders) {

		String sql = "insert into Orders(username, email, product_name_1, product_quantity_1) values (?,?,?,?)";

		jdbctemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				// Orders order = orders.get(i);
				ps.setString(1, orders.getUserName());
				ps.setString(2, orders.getEmail());
				ps.setString(3, orders.getProductName());
				ps.setString(4, orders.getProductQuantity());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return 0;
			}
		});

	}

}
