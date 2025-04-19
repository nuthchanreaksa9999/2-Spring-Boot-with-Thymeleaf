package co.istad.thymeleaf.webapp.model;

import org.springframework.web.multipart.MultipartFile;

public record FileUpload(String fileName, boolean isSucceed) {

}
