package ru.itis.yaylunch.controllers.old;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.BrandDto;
import ru.itis.yaylunch.dto.forms.BrandForm;
import ru.itis.yaylunch.services.BrandsService;
import ru.itis.yaylunch.services.CertificatesService;

@RequiredArgsConstructor
@RestController
public class BrandsController {
    private final BrandsService brandsService;
    private final CertificatesService certificatesService;

    @PostMapping("/api/students-giftery/brands/")
    public ResponseEntity<BrandDto> createBrand(BrandForm brandForm) {
        BrandDto brandDto = brandsService.createBrand(brandForm);

        if(brandDto == null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(brandDto);
        }
    }

    @DeleteMapping("/api/students-giftery/brands/")
    public ResponseEntity<BrandDto> deleteBrand(Long brandId) {
        return ResponseEntity.status(HttpStatus.OK).body(brandsService.deleteBrand(brandId));
    }
}
