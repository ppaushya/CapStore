package com.capstore.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstore.dao.IImageUploadDao;
import com.capstore.model.Product;
import com.capstore.model.ProductImage;


@Service("storageService")
public class StorageService {

	
	@Autowired
	   IImageUploadDao uploadDao;
	   @Autowired
	  IProductService productService;
		Logger log = LoggerFactory.getLogger(this.getClass().getName());
		

		private final Path rootLocation = Paths.get("D:\\Users\\mokotha\\Desktop\\CapStore\\src\\main\\resources\\static\\upload-dir");

		
		ProductImage productImage=new ProductImage();
		Product  product=new Product();
		public void store(MultipartFile file,String productId) {
			product=productService.getProduct(Integer.parseInt(productId));
			try {
				productId=productId+".jpg";
				Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename().replace(file.getOriginalFilename(), productId)));
				//dbStore(productId);
				dbStore(this.rootLocation.resolve(file.getOriginalFilename().replace(file.getOriginalFilename(), productId)).toString());
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
		}
		
		public void dbStore(String string) {
			productImage.setImageUrl(string);
			productImage.setImageStatus("main");
			productImage.setProduct(product);
			uploadDao.save(productImage);
		}

		public void init() {
			try {
				if(!Files.isDirectory(rootLocation))
				    Files.createDirectories(rootLocation);
			} catch (IOException e) {
				throw new RuntimeException("Could not initialize storage!");
			}
		}
}
