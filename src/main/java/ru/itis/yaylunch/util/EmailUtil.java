package ru.itis.yaylunch.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailUtil {
//
//    @Autowired
//    private FreeMarkerConfigurer freeMarkerConfigurer;
//    private final JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String from;
//
//    public void sendConfirmMail(String to, String subject, String templateName, Account newAccount){
//        try {
//            Map<String, Object> templateData = new HashMap<>();
//            templateData.put("first_name", newAccount.getFirstName());
//            templateData.put("last_name", newAccount.getLastName());
//            templateData.put("confirm_code", newAccount.getConfirmCode());
//            templateData.put("email", newAccount.getEmail());
//
//            String templateContent = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(templateName), templateData);
//            MimeMessagePreparator preparator = mimeMessage -> {
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//                messageHelper.setSubject(subject);
//                messageHelper.setText(templateContent, true);
//                messageHelper.setTo(to);
//                messageHelper.setFrom(from);
//            };
//
//            new Thread(() -> mailSender.send(preparator)).start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendGiftNoticeMail(String to, String subject, String templateName, String email, String firstName, String lastName, String brand){
//        try {
//            Map<String, Object> templateData = new HashMap<>();
//            templateData.put("first_name", firstName);
//            templateData.put("last_name", lastName);
//            templateData.put("email", email);
//            templateData.put("brand", brand);
//
//            String templateContent = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(templateName), templateData);
//            MimeMessagePreparator preparator = mimeMessage -> {
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//                messageHelper.setSubject(subject);
//                messageHelper.setText(templateContent, true);
//                messageHelper.setTo(to);
//                messageHelper.setFrom(from);
//            };
//
//            new Thread(() -> mailSender.send(preparator)).start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
