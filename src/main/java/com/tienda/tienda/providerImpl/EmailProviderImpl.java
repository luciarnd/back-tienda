package com.tienda.tienda.providerImpl;

import java.io.ByteArrayInputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import com.tienda.tienda.entity.EmailEntity;
import com.tienda.tienda.provider.EmailProvider;
import com.tienda.tienda.provider.ProductoProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EmailProviderImpl implements EmailProvider {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private ProductoProvider productoProvider;
	
	@Override
	public void SendEmail(EmailEntity email, MultipartFile file) {

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

	 @Scheduled( cron = "0 0 0 1/7 * *")

	public void sendEmailAuto() {
		try {
			MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
		
			mimeMessageHelper.setFrom("testossot@gmail.com");
			mimeMessageHelper.setTo("testossot@gmail.com");
			mimeMessageHelper.setSubject("Correo Automatico");
			mimeMessageHelper.setText("");
			ByteArrayInputStream stream = ExcelProviderImpl.createExcel(productoProvider.findAllProductos());
			byte[] c= stream.readAllBytes();
			mimeMessageHelper.addAttachment("fg.xlsx",  new ByteArrayResource(c));
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

