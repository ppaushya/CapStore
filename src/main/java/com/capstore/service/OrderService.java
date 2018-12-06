package com.capstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IOrderDao;
import com.capstore.model.Order;
import com.capstore.model.Product;

@Service("orderService")
public class OrderService implements IOrderService{

	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IProductService productService;
	
	@Override
	public List<Order> displayCart() {		//display the cart items
		return orderDao.findAll();
	}

	@Override
	public boolean placeOrder(Order order) {
		List<Product> products=order.getOrderedProducts();
		Map<Product, Product> inventoryProductsMap = new HashMap<>();
		
		//check if product is in sufficient quantity
		for(Product orderProduct:products) {
			//fetch product from inventory
			Product inventoryProduct = productService.getProduct(orderProduct.getProductId());
			
			//save orderProduct and inventoryProduct in map
			inventoryProductsMap.put(orderProduct, inventoryProduct);
			
			//check quantity
			int orderedQuantity = orderProduct.getQuantity();
			int availableQuantity = inventoryProduct.getQuantity();
			if(orderedQuantity>availableQuantity) {
				return false;
			}
		}
		
		//update quantity in inventory
		for(Map.Entry<Product, Product> productMap : inventoryProductsMap.entrySet()) {
			//fetch orderProduct
			Product orderProduct = productMap.getKey();
			//fetch inventoryProduct
			Product inventoryProduct = productMap.getValue();
			
			//quantity
			int orderedQuantity = orderProduct.getQuantity();
			int availableQuantity = inventoryProduct.getQuantity();
			
			//update quantity
			inventoryProduct.setQuantity(availableQuantity-orderedQuantity);
			productService.updateProduct(inventoryProduct);
		}
		
		return true;
	}
}
