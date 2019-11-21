package fr.cesi.commerce.doa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.commerce.model.Product;
import fr.cesi.commerce.model.UnknownProductException;


public class ProductDao {
	
	private static List<Product> products = new ArrayList<Product>();
	private static Long idSequence = 1L;
	
	private ProductDao() { }
	
	
	public static void addProduct(Product product) {
		product.setId(idSequence++);
		products.add(product);
	}
	
	
	public static void updateProduct(Product product) throws UnknownProductException {
		int index = getProductIndexById(product.getId());
		if(index > -1) {
			products.set(index, product);
		} else {
			throw new UnknownProductException(product.getId());
		}
	}
	
	
	public static Product findProductById(Long id) throws UnknownProductException {
		int index = getProductIndexById(id);
		if(index > -1) {
			Product product = products.get(index);
			return product;
		}
		throw new UnknownProductException(id);
	}
	
	
	public static List<Product> getAllProducts() {
		return Collections.unmodifiableList(products);
	}
	
	
	public static void removeProduct(Product product) throws UnknownProductException {
		removeProduct(product.getId());
	}
	
	
	public static void removeProduct(Long id) throws UnknownProductException {
		int index = getProductIndexById(id);
		if(index > -1) {
			products.remove(index);
		} else {
			throw new UnknownProductException(id);
		}
	}
	
	private static int getProductIndexById(Long id) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if(product.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}
