package com.hpp.ims.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpp.ims.model.Hospital;
import com.hpp.ims.model.HospitalInventory;
import com.hpp.ims.model.Orders;
// import com.hpp.ims.model.Supplier;
import com.hpp.ims.model.SupplierInventory;
import com.hpp.ims.service.ImsService;

//RESTAPI

@RestController
public class ImsController {

	private static final Logger log = LoggerFactory.getLogger(ImsController.class);

	@Autowired
	ImsService imsservice;

	/**
	 * Get Hospital Details by id
	 * 
	 * @param hospitalId
	 * @return
	 */
	@GetMapping(path = "/getHospitalDetailById/{hospitalId}")
	public ResponseEntity<Hospital> getHospitalDetailById(@PathVariable("hospitalId") int hospitalId) {

		ResponseEntity<Hospital> responseentity = new ResponseEntity<Hospital>(
				imsservice.getHospitalDetailById(hospitalId), HttpStatus.ACCEPTED);
		return responseentity;

	}

	/**
	 * Get Hospital Details by name
	 * 
	 * @param hospitalName
	 * @return
	 */
	@GetMapping(path = "/getHospitalDetailByName/{hospitalName}")
	public ResponseEntity<Hospital> getHospitalDetailByName(@PathVariable("hospitalName") String hospitalName) {

		ResponseEntity<Hospital> responseentity = new ResponseEntity<Hospital>(
				imsservice.getHospitalDetailByName(hospitalName), HttpStatus.ACCEPTED);
		return responseentity;

	}

	/**
	 * end point for getting information of supplier by hospital id
	 * 
	 * @param supplierId
	 * @return
	 */
	@GetMapping(path = "/getSupplierDetailById/{supplierId}")
	public ResponseEntity<Object> getSupplierDetailById(@PathVariable("supplierId") int supplierId) {
		log.info("Executing controller method");
		try {
			return ResponseEntity.status(HttpStatus.OK).body(imsservice.getSupplierDetailById(supplierId));

		} catch (Exception e) {
			log.error("Exception occured while getting information of supplier by hospital id");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Error. Please conatct Admin");

		}

	}

	// end point for getting information of Hospital products by hospital id from
	// hospital inventory

	@GetMapping(path = "/getHospitalProdcutsDetailByHospitalId/{hospitalId}")
	public ResponseEntity<List<HospitalInventory>> getHospitalProdcutsDetailByHospitalId(
			@PathVariable("hospitalId") int hospitalId) {

		ResponseEntity<List<HospitalInventory>> responseentity = new ResponseEntity<List<HospitalInventory>>(
				imsservice.getHospitalProdcutsDetailByHospitalId(hospitalId), HttpStatus.ACCEPTED);
		return responseentity;

	}

	// end point for getting information of supplier products by supplier id from
	// supplier inventory

	@GetMapping(path = "/getSupplierProdcutsDetailBySupplierId/{supplierId}")
	public ResponseEntity<List<SupplierInventory>> getSupplierProdcutsDetailBySupplierId(
			@PathVariable("supplierId") int supplierId) {

		ResponseEntity<List<SupplierInventory>> responseentity = new ResponseEntity<List<SupplierInventory>>(
				imsservice.getSupplierProdcutsDetailBySupplierId(supplierId), HttpStatus.ACCEPTED);
		return responseentity;

	}

	// ------- NEW API's ---------
	@GetMapping(path = "/getSupplierProductsDetails")
	public ResponseEntity<List<SupplierInventory>> getSupplierProductsDetails() {

		ResponseEntity<List<SupplierInventory>> responseentity = new ResponseEntity<List<SupplierInventory>>(
				imsservice.getSupplierProductsDetails(), HttpStatus.ACCEPTED);
		return responseentity;
	}

	@PostMapping(path="/saveOrderDetails")
	public String saveOrderDetails(@RequestBody Orders orders) { 
		
		imsservice.saveOrderDetails(orders);
		
		return "Order Details Saved Successfully!";
		
	}

}
