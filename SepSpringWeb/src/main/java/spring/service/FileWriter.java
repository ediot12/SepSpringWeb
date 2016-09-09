package spring.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileWriter {

	private FileOutputStream fos;

	private static FileWriter instance = new FileWriter();

	public static FileWriter getInstance() {
		return instance;
	}

	public void upload(MultipartFile file, String fileName) throws IOException {
		String path = "e:\\upload";
		byte fileData[] = file.getBytes();
		fos = new FileOutputStream(path + "\\" + fileName);
		fos.write(fileData);
		fos.close();
	}
}
