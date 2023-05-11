package ru.itis.yaylunch.controllers.old;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.CertificateInstanceDto;
import ru.itis.yaylunch.dto.CertificateTemplateDto;
import ru.itis.yaylunch.dto.forms.CertificateTemplateForm;
import ru.itis.yaylunch.services.CertificatesService;

@RequiredArgsConstructor
@RestController
public class CertificatesController {
    private final CertificatesService certificatesService;

    @GetMapping("/api/students-giftery/certificates/{certificate-id}/buy/")
    public ResponseEntity<CertificateInstanceDto> buyCertificate(Long certificateId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(certificatesService.buyCertificate(certificateId));
    }

    @GetMapping("/api/students-giftery/certificates/{certificate-id}/buyAsGift/{account-id}/")
    public ResponseEntity<CertificateInstanceDto> buyCertificateAsGift(Long certificateId, Long accountId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(certificatesService.buyCertificateAsGift(certificateId, accountId));
    }

    @PostMapping("/api/students-giftery/certificates/{certificate-id}/spend/")
    public ResponseEntity<CertificateInstanceDto> spendCertificate(Long certificateId, Long purchasePrice) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(certificatesService.spendCertificate(certificateId, purchasePrice));
    }

    @PostMapping("/api/students-giftery/brands/{brand-id}/certificates/")
    public ResponseEntity<CertificateTemplateDto> addCertificateTemplate(Long brandId, CertificateTemplateForm certificateForm) {
        CertificateTemplateDto certificateTemplateDto =
                certificatesService.addCertificateTemplateToBrand(brandId, certificateForm);

        if(certificateTemplateDto == null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(certificateTemplateDto);
    }

    @DeleteMapping("/api/students-giftery/brands/{brand-id}/certificates/")
    public ResponseEntity<CertificateTemplateDto> deleteCertificateTemplate(Long brandId, Long certificateTemplateId) {
        return ResponseEntity.status(HttpStatus.OK).body(certificatesService.deleteCertificateTemplate(certificateTemplateId));
    }
}
