package ru.itis.yaylunch.services;

import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.OrganizationDto;
import ru.itis.yaylunch.dto.OrganizationJoinRequestDto;
import ru.itis.yaylunch.dto.forms.OrganizationForm;

import java.util.List;

public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationForm organizationForm);

    List<OrganizationDto> getOrganizations();

    OrganizationJoinRequestDto addOrganizationJoinRequest(Long organizationId);

    OrganizationJoinRequestDto confirmOrganizationJoinRequest(Long requestId);

    OrganizationJoinRequestDto denyOrganizationJoinRequest(Long requestId);

    AccountDto unjoinFromOrganization();

    OrganizationDto deleteOrganization(Long organizationId);
}
