package wk06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	Map<String, Product> products = new HashMap<>();

	public ProductService() {
		Product p = new Product("101", "아이폰 15", "애플", 1200000, "2023.10.1");
		products.put("101", p);
		p = new Product("102", "갤럭시 Z 플립 5", "삼성전자", 1300000, "2023.6.1");
		products.put("102", p);
		p = new Product("103", "갤럭시 S21", "삼성전자", 1500000, "2023.4.23");
		products.put("103", p);
	}

	public List<Product> findAll() {
		return new ArrayList<>(products.values());
	}

	public Product find(String id) {
		return products.get(id);
	}
}
