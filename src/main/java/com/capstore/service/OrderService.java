package com.capstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IOrderDao;
import com.capstore.model.Order;
import com.capstore.model.Product;

@Service("orderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IProductService productService;

	@Override
	public List<Product> displayCartProducts(int orderId) {		//display the cart items
		Order order = findOrderById(orderId);
		return order.getOrderedProducts();
	}

	@Override
	public Order findOrderById(int orderId) {		//finding the order
		Optional<Order> optional = orderDao.findById(orderId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean checkAvailabilityInInventory(Order order) {//checking availability of ordered products
		List<Product> products = order.getOrderedProducts();

		// check if product is in sufficient quantity
		for (Product orderProduct : products) {
			// fetch product from inventory
			Product inventoryProduct = productService.getProduct(orderProduct.getProductId());

			// save orderProduct and inventoryProduct in map
			// inventoryProductsMap.put(orderProduct, inventoryProduct);

			// check quantity
			int orderedQuantity = orderProduct.getQuantity();
			int availableQuantity = inventoryProduct.getQuantity();
			if (orderedQuantity > availableQuantity) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean placeOrder(Order order) {
		orderDao.save(order);
		return true;
	}

	@Override
	public boolean deliverOrderAndUpdateInventory(Order order) {
		List<Product> products = order.getOrderedProducts();
		Map<Product, Product> inventoryProductsMap = new HashMap<>();

		for (Product orderProduct : products) {
			// fetch product from inventory
			Product inventoryProduct = productService.getProduct(orderProduct.getProductId());

			// save orderProduct and inventoryProduct in map
			inventoryProductsMap.put(orderProduct, inventoryProduct);
		}

		// update quantity in inventory
		for (Map.Entry<Product, Product> productMap : inventoryProductsMap.entrySet()) {
			// fetch orderProduct
			Product orderProduct = productMap.getKey();
			// fetch inventoryProduct
			Product inventoryProduct = productMap.getValue();

			// quantity
			int orderedQuantity = orderProduct.getQuantity();
			int availableQuantity = inventoryProduct.getQuantity();

			// update quantity
			inventoryProduct.setQuantity(availableQuantity - orderedQuantity);
			productService.updateProduct(inventoryProduct);
		}

		return true;
	}

	@Override
	public List<Order> getOrdersForCustomer(int custId) { // to get orders for a customer
		
		return orderDao.getOrdersForCustomer(custId) ;
	}

}
