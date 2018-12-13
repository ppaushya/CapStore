package com.capstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.model.Product;
import com.capstore.service.ICartService;
import com.capstore.service.StorageService;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CartController {

	@Autowired
	ICartService cartService;
	@Autowired
	StorageService storageService;

	List<String> files = new ArrayList<String>();
	@DeleteMapping("/deleteProductFromCart/{customerId}/{productId}")
	public ResponseEntity<List<CartProduct>> deleteCartProduct(@PathVariable("customerId") Integer customerId,
													@PathVariable("productId") Integer productId)
	{
		Cart cart=cartService.deleteProductFromCart(customerId,productId);
		List<CartProduct> cartProducts=cart.getCartProducts();
		if(cart==null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<CartProduct>>(cartProducts, HttpStatus.OK);
	}
	

	@PostMapping("/addProductToCart/{custId}")
	public ResponseEntity<Cart> addProductToCart(@RequestBody CartProduct cartProduct,
													@PathVariable("custId") Integer custId, HttpSession session) 
	{
		Cart cart = cartService.addProductToCart(cartProduct, custId);
	
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@GetMapping("/getCartProducts/{customerId}")
	public ResponseEntity<List<CartProduct>> getCartProducts(HttpSession sessison, @PathVariable("customerId") Integer customerId) {
		
		Cart cart=cartService.getCartProducts(customerId);
		
		List<CartProduct> cartProducts=cart.getCartProducts();
		
		
		
		
		if (cartProducts.isEmpty())
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<CartProduct>>(cartProducts, HttpStatus.OK);

	}
	
	@PutMapping("/updateCartProductQuantity/{customerId}")
	public ResponseEntity<List<CartProduct>> updateCartProductQuantity(@RequestBody CartProduct cartProduct,
														@PathVariable("customerId") Integer customerId, HttpSession session){
		
		Cart cart=cartService.updateCartProductQuantity(cartProduct,customerId);
		List<CartProduct> cartProducts=cart.getCartProducts();
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<CartProduct>>(cartProducts, HttpStatus.OK);
		
	}
	@GetMapping("/getallfiles/{productId}")
	public ResponseEntity<List<String>> getListFiles(Model model,@PathVariable("productId") String productId) {
		
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(CartController.class, "getFile", productId+".jpg").build().toString())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		
		Resource file = storageService.loadFile(filename);
		System.out.println("Check2:");
		System.out.println(filename);
		System.out.println(file);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
		
	}
	
	
}
