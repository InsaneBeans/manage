package com.boot.controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @category 文件上传并解析
 */
@RestController
public class FileUploadController {

	private File file;

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@RequestMapping("/user/upload")
	public String userMultiUpload() {
		return null;
	}

}
