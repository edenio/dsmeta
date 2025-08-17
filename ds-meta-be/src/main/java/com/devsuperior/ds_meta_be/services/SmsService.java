package com.devsuperior.ds_meta_be.services;

import org.springframework.stereotype.Service;

import com.devsuperior.ds_meta_be.entities.Sales;
import com.devsuperior.ds_meta_be.infrastructure.Properties;
import com.devsuperior.ds_meta_be.repository.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SmsService {

	private final SalesRepository salesRepository;
	private final Properties properties;
	
	public void sendSms(Long saleId) {
		
		Sales sales = salesRepository.findById(saleId).get();
		
		String date = sales.getDate().getMonthValue() + "/" + sales.getDate().getYear();
		
		String msg = "O Vendedor " + sales.getSellerName() + " foi destaque em " + date
		+ "com um total de R$ " + String.format("%.2f", sales.getAmount());

		String twilioSid = properties.getTwilio().getSid();
		String twilioKey = properties.getTwilio().getKey();
		
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(properties.getTwilio().getPhone().getTo());
		PhoneNumber from = new PhoneNumber(properties.getTwilio().getPhone().getFrom());

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}