package com.TNABank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TNABank.entity.Transfer;
import com.TNABank.model.ApiCustomResponse;
import com.TNABank.model.ErrorData;
import com.TNABank.model.TransferModel;
import com.TNABank.service.TransferService;

@RestController
@CrossOrigin
@RequestMapping("/tna/ebankingService")
public class TransferController {

	@Autowired
	private TransferService transferService;

	@PostMapping(value = "/transfer")
	public ResponseEntity<?> makeTransfer(@RequestBody TransferModel transferModel) {

		return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(transferService.makeTransfer(transferModel)),
				HttpStatus.OK);
	}

	@GetMapping(value = "/users/{userId}/transfers")
	public ResponseEntity<?> getUserTransfers(@PathVariable Long userId) {

		List<Transfer> transfers = transferService.getUserTransfers(userId);
		if (transfers != null) {
			return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(transfers), HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiCustomResponse>(
					new ApiCustomResponse(new ErrorData("004", "no transfers found")), HttpStatus.BAD_REQUEST);
		}

	}
}