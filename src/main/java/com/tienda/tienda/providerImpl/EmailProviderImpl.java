package com.tienda.tienda.providerImpl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import com.tienda.tienda.entity.Email;
import com.tienda.tienda.provider.EmailProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EmailProviderImpl implements EmailProvider {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void SendEmail(Email email, MultipartFile file) {
		

		try {
		
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessage message2 = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			MimeMessageHelper helper2 = new MimeMessageHelper(message2,true);
			
			helper.setFrom("testossot@gmail.com");
            helper.setTo(email.getEmail());
            helper.setSubject("Gracias");
            helper.setText("En breves le responderemos");
            
            helper2.setFrom("testossot@gmail.com");
            helper2.setTo("testossot@gmail.com");
            helper2.setSubject("Email enviado por: "+email.getEmail());
            helper2.setText("Con asunto: "+email.getAsunto()+ " y mensaje: "+email.getMensaje());
            
            if(file!=null) {
            byte[] fichBytes = file.getBytes();
           
            helper2.addAttachment(file.getOriginalFilename(), new ByteArrayResource(fichBytes));
            }
           javaMailSender.send(message,message2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		}
	}

