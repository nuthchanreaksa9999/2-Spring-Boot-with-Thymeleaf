package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf.webapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file.server-path}")
    private String fileServerPath;

    @Override
    public FileUpload uploadSingle(MultipartFile file) {

//        .jpg
        int dotLastIndex = Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf(".");
        String ext = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
                String newFileName = String.format("%s%s%s", uuid, ".", ext);
        System.out.println(newFileName);

//        1.  Create file path
        Path paths = Paths.get(fileServerPath + newFileName);
        try {
//            2. Copy file with path object
            Files.copy(file.getInputStream(), paths);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileUpload(newFileName, true);
    }
}

//package co.istad.thymeleaf.webapp.service.impl;
//
//import co.istad.thymeleaf.webapp.service.FileUploadService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Objects;
//import java.util.UUID;
//
//@Service
//public class FileUploadServiceImpl implements FileUploadService {
//
//    @Value("${file.server-path}")
//    private String fileServerPath;
//
//    @Override
//    public void uploadSingle(MultipartFile file) {
//        // Ensure the file has a name
//        String originalFileName = Objects.requireNonNull(file.getOriginalFilename(), "File name must not be null");
//
//        // Extract file extension
//        int dotIndex = originalFileName.lastIndexOf(".");
//        if (dotIndex == -1 || dotIndex == originalFileName.length() - 1) {
//            throw new RuntimeException("File must have an extension");
//        }
//        String extension = originalFileName.substring(dotIndex); // includes the dot
//
//        // Generate new file name
//        String newFileName = UUID.randomUUID() + extension;
//        System.out.println("Generated file name: " + newFileName);
//
//        // Create full path safely
//        Path path = Paths.get(fileServerPath, newFileName);
//
//        try {
//            Files.copy(file.getInputStream(), path);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to save file", e);
//        }
//    }
//}
