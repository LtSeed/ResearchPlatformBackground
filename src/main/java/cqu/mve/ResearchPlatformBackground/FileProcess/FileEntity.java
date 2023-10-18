package cqu.mve.ResearchPlatformBackground.FileProcess;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    @Lob
    private byte[] data;  // 字段用于保存文件的二进制数据

    // Getters and setters...
}
