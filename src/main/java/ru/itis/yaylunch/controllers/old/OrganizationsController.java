package ru.itis.yaylunch.controllers.old;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.OrganizationDto;
import ru.itis.yaylunch.dto.OrganizationJoinRequestDto;
import ru.itis.yaylunch.dto.forms.OrganizationForm;
import ru.itis.yaylunch.services.OrganizationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrganizationsController {
    private final OrganizationService organizationService;

    @PostMapping("/api/students-giftery/organizations/join")
    public ResponseEntity<OrganizationJoinRequestDto> addOrganizationJoinRequest(Long organizationId) {
        OrganizationJoinRequestDto organizationJoinRequestDto = organizationService.addOrganizationJoinRequest(organizationId);

        if(organizationJoinRequestDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(organizationJoinRequestDto);
        }
    }

    @PostMapping("/api/students-giftery/organizations/confirmJoin")
    public ResponseEntity<OrganizationJoinRequestDto> confirmOrganizationJoinRequest(Long requestId) {
        OrganizationJoinRequestDto organizationJoinRequestDto = organizationService.confirmOrganizationJoinRequest(requestId);

        if(organizationJoinRequestDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(organizationJoinRequestDto);
        }
    }

    @PostMapping("/api/students-giftery/organizations/")
    public ResponseEntity<OrganizationDto> createOrganization(OrganizationForm organizationForm) {
        OrganizationDto organizationDto = organizationService.createOrganization(organizationForm);

        if(organizationDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(organizationDto);
        }
    }

    @PostMapping("/api/students-giftery/organizations/denyJoin")
    public ResponseEntity<OrganizationJoinRequestDto> denyOrganizationJoinRequest(Long requestId) {
        OrganizationJoinRequestDto organizationJoinRequestDto = organizationService.denyOrganizationJoinRequest(requestId);

        if(organizationJoinRequestDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(organizationJoinRequestDto);
        }
    }

    @GetMapping("/api/students-giftery/organizations/")
    public ResponseEntity<List<OrganizationDto>> getOrganizations() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(organizationService.getOrganizations());
    }

    @PostMapping("/api/students-giftery/organizations/unjoin")
    public ResponseEntity<AccountDto> unjoinFromOrganization() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(organizationService.unjoinFromOrganization());
    }

    @DeleteMapping("/api/students-giftery/organizations/")
    public ResponseEntity<OrganizationDto> deleteOrganization(Long organizationId) {
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.deleteOrganization(organizationId));
    }
}
