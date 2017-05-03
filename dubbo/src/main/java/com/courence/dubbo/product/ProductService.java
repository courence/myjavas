package com.courence.dubbo.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	public String getProductName() {
		return "hello";
	}

}
