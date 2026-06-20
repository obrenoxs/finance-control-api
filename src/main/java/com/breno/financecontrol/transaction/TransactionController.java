package com.breno.financecontrol.transaction;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> create(@RequestBody TransactionRequestDTO dto){
		Transaction transaction = transactionService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
		return ResponseEntity.created(uri).body(transaction);
	}
	
	@GetMapping
	public ResponseEntity<List<TransactionResponseDTO>> findAll(){
		List<TransactionResponseDTO> list = transactionService.findAllResponse();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TransactionResponseDTO> findById(@PathVariable Long id){
		TransactionResponseDTO obj = transactionService.findByIdResponse(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		transactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody TransactionRequestDTO dto){
		Transaction obj = transactionService.update(id, dto);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/balance")
	public ResponseEntity<BalanceDTO> getBalance(){
		BalanceDTO balance = transactionService.getBalance();
		return ResponseEntity.ok().body(balance);
	}
}
