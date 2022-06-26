package app.spring.third.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	//파일명을 
	String fileUpload(MultipartFile file) throws Exception;
	
	//파일 삭제
		void fileDelete(String filename) throws Exception;
}
