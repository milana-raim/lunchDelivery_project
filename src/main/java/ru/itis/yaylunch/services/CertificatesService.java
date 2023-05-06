package ru.itis.yaylunch.services;

import ru.itis.yaylunch.dto.CertificateInstanceDto;
import ru.itis.yaylunch.dto.CertificateTemplateDto;
import ru.itis.yaylunch.dto.forms.CertificateTemplateForm;

public interface CertificatesService {
    CertificateTemplateDto addCertificateTemplateToBrand(Long brandId, CertificateTemplateForm certificateForm);

    CertificateInstanceDto buyCertificate(Long certificateTemplateId);

    CertificateInstanceDto buyCertificateAsGift(Long certificateTemplateId, Long accountId);

    CertificateInstanceDto spendCertificate(Long certificateInstanceId, Long purchasePrice);

    CertificateTemplateDto deleteCertificateTemplate(Long certificateTemplateId);
}
