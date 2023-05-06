package ru.itis.yaylunch.dto.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.itis.yaylunch.dto.CertificateInstanceDto;
import ru.itis.yaylunch.dto.CertificateTemplateDto;
import ru.itis.yaylunch.models.CertificateInstance;
import ru.itis.yaylunch.models.CertificateTemplate;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CertificateMapper {

    public abstract CertificateTemplate toCertificate(CertificateTemplateDto certificateTemplateDto);

    public abstract CertificateTemplateDto toCertificateTemplateDto(CertificateTemplate certificateTemplate);

    public abstract List<CertificateTemplateDto> toCertificateTemplateDtoList(List<CertificateTemplate> certificateTemplates);

    public abstract CertificateInstance toCertificateInstance(CertificateInstanceDto certificateInstanceDto);

    public abstract CertificateInstanceDto toCertificateInstanceDto(CertificateInstance certificateInstance);

    public abstract List<CertificateInstanceDto> toCertificateInstanceDtoList(List<CertificateInstance> certificateInstances);

    @AfterMapping
    protected void setBrandToCertificateTemplateDto(CertificateTemplate certificateTemplate, @MappingTarget CertificateTemplateDto certificateTemplateDto){
        certificateTemplateDto.setBrandId(certificateTemplate.getBrand().getId());
    }

    @AfterMapping
    protected void setToCertificateInstanceDto(CertificateInstance certificateInstance, @MappingTarget CertificateInstanceDto certificateInstanceDto){
        certificateInstanceDto.setCertificateTemplateId(certificateInstance.getCertificateTemplate().getId());
        certificateInstanceDto.setAccountId(certificateInstance.getAccount().getId());
    }
}
