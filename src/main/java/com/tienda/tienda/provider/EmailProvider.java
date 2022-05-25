package com.tienda.tienda.provider;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tienda.tienda.entity.Email;

@Service
@Transactional
public interface EmailProvider {
	void SendEmail(Email email, MultipartFile file);
	
}
