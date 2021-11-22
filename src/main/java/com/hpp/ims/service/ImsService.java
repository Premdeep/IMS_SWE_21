package com.hpp.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hpp.ims.dao.ImsDao;
import com.hpp.ims.model.Hospital;
import com.hpp.ims.model.HospitalInventory;
import com.hpp.ims.model.Orders;
import com.hpp.ims.model.Supplier;
import com.hpp.ims.model.SupplierInventory;

@Component
public class ImsService {

	@Autowired
	ImsDao imsdao;

	public Hospital getHospitalDetailById(int hospitalId) {

		return imsdao.getHospitalDetailById(hospitalId);
	}

	public Hospital getHospitalDetailByName(String hospitalName) {
		return imsdao.getHospitalDetailByName(hospitalName);
	}

	public Supplier getSupplierDetailById(int supplierId) {
		return imsdao.getSupplierDetailById(supplierId);
	}

	public List<HospitalInventory> getHospitalProdcutsDetailByHospitalId(int hospitalId) {

		return imsdao.getHospitalProdcutsDetailByHospitalId(hospitalId);
	}

	public List<SupplierInventory> getSupplierProdcutsDetailBySupplierId(int supplierId) {
		return imsdao.getSupplierProdcutsDetailBySupplierId(supplierId);
	}

	// ------- NEW API's ---------
	public List<SupplierInventory> getSupplierProductsDetails() {
		return imsdao.getSupplierProductsDetails();
	}

	public void saveOrderDetails(Orders orders) {
		imsdao.saveOrderDetails(orders);
	}

}
