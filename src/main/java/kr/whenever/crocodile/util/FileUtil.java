package kr.whenever.crocodile.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
		File file = new File(multipartFile.getOriginalFilename());
		multipartFile.transferTo(file);
		return file;
	}
	
}
