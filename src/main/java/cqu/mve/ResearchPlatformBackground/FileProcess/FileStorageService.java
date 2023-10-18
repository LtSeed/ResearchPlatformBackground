package cqu.mve.ResearchPlatformBackground.FileProcess;

import cqu.mve.ResearchPlatformBackground.FileProcess.Exception.FileStorageException;
import cqu.mve.ResearchPlatformBackground.FileProcess.Repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Objects;

@Service
public class FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    public FileEntity storeFile(MultipartFile file) throws FileStorageException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Filename contains invalid path sequence " + fileName);
            }

            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(fileName);
            fileEntity.setFileType(file.getContentType());
            fileEntity.setSize(file.getSize());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileEntity.getId().toString())
                    .toUriString();

            fileEntity.setFileDownloadUri(fileDownloadUri);

            return fileRepository.save(fileEntity);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
        }
    }

    public FileEntity getFile(Long fileId) {
        return fileRepository.getReferenceById(fileId);
    }


    // ... other methods for file retrieval, etc.
}
