package com.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstore.model.Feedback;

@Repository("feedbackDao")
@Transactional
public interface IFeedbackDao extends JpaRepository<Feedback,Integer>  {
	
	@Query("from Feedback where product.productId=:productId")
	public List<Feedback> findByProductId(int productId);
	
	@Query("from Feedback where merchant.merchantId=:merchantId")
	public List<Feedback> findByMerchantId(int merchantId);
}