package com.cts.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entity.Product;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	private List<Product> prods=null;
	public ProductController(){
		prods = new ArrayList<Product>();

		Product prod1 = new Product();
		prod1.setProdId(10);
		prod1.setProdName("Laptop");
		prod1.setPrice(45000);

		Product prod2 = new Product();
		prod2.setProdId(11);
		prod2.setProdName("Mobile");
		prod2.setPrice(25000);

		Product prod3 = new Product();
		prod3.setProdId(12);
		prod3.setProdName("Ipad");
		prod3.setPrice(85000);
		prods.add(prod1);
		prods.add(prod2);
		prods.add(prod3);
	}

	@GetMapping("/greet")
	public String greetMe() {
		return "Good Morning";
	}

	@GetMapping
	public List<Product> listProducts() {
	
		return prods;
	}

	@GetMapping("/{pid}")
	public ResponseEntity<?> getProduct(@PathVariable("pid") int pid) {
		for(Product prod:prods) {
			if(prod.getProdId()==pid) {
				return new ResponseEntity<Product>(prod,HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<String>("Product Id "+pid+" Not Found",HttpStatus.NOT_FOUND); // returns JSON back to client
	}

}
