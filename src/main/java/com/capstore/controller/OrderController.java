package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.capstore.model.Cart;
import com.capstore.model.Order;
import com.capstore.model.Product;
import com.capstore.service.IOrderService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/displayCartProducts/{orderId}")
	public ResponseEntity<List<Product>> displayCartProducts(HttpSession session,@PathVariable("orderId") Integer orderId) {
		List<Product> mycart=orderService.displayCartProducts(orderId);
		return new ResponseEntity<List<Product>>(mycart,HttpStatus.OK);
	}
	
	@GetMapping("/findOrderById/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable("orderId") Integer orderId ) {
		Order order = orderService.findOrderById(orderId);
		if (order == null)
			return new ResponseEntity("Sorry! Product is not available!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@PostMapping("/checkAvailabilityInInventory") 
	public ResponseEntity<String> checkAvailabilityInInventory(@RequestBody Order order) {
		if(orderService.checkAvailabilityInInventory(order)) {
			return new ResponseEntity("All products are available!", HttpStatus.OK);
		}else{
			return new ResponseEntity("Sorry, Order is not available!", HttpStatus.OK);
		}
	}
	
	@PostMapping("/placeOrder") 
	public ResponseEntity<String> placeOrder(@RequestBody Order order){
		if(orderService.placeOrder(order)) {
			return new ResponseEntity("Order placed!", HttpStatus.OK);
		}else{
			return new ResponseEntity("Error occured while placing order", HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/deliverOrderAndUpdateInventory")
	public ResponseEntity<String> deliverOrderAndUpdateInventory(@RequestBody Order order){
		if(orderService.deliverOrderAndUpdateInventory(order)) {
			return new ResponseEntity("Inventory updated", HttpStatus.OK);
		}else{
			return new ResponseEntity("Error occured while updating inventory", HttpStatus.OK);
		}
	}
	

}