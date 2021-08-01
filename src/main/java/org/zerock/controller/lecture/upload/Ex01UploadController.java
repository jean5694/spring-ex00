package org.zerock.controller.lecture.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/upload")
@Log4j
public class Ex01UploadController {
	/*
	 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html
	 */
	
	@RequestMapping("/sub01") // @RequestParam 값에 jsp에서 지정한 파일명으로 넣어줄 것 (생략 가능함)
	public void method1(String fname, @RequestParam("ufile") MultipartFile ufile) {
		log.info(fname);
		log.info(ufile.getOriginalFilename());
		
		// 임시 로컬폴더로 경로 지정 + 파일을 가져오라는 명령어 
		String name = "C:/myworkspace/tempFile/" + ufile.getOriginalFilename();
		
		try (
			// 프로그램 기준으로 들어오는 거라 InputStream
			InputStream is = ufile.getInputStream();
			// InputStream만 사용하면 느리기 때문에 BufferedInputStream 추가
			BufferedInputStream bis = new BufferedInputStream(is);
			
			// 프로그램 기준으로 나가는 거라 OutputStream
			FileOutputStream fos = new FileOutputStream(name);
			// FileOutputStream만 사용하면 느리기 때문에 BufferedOutputStream 추가
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			// 읽어낼 바이트 단위 수 지정 
			int len = 1024;
			byte[] b = new byte[len];
			
			int cnt = 0;
			while ((cnt = bis.read(b, 0, len)) != -1) {
				bos.write(b, 0, cnt);
			// cnt는 bis에서 바이트가 0일 때부터 1024번까지 읽어내는데,
			// 읽어내는 동안은 bos로 출력을 반복
			// 마지막 값까지 읽게 되면 -1을 리턴하면서 반복 종료
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@PostMapping("/sub02") // @RequestParam을 생략한 방법
	public void method02(MultipartFile file) {
		log.info(file.getOriginalFilename());
		String localFilePath = "C:/myworkspace/tempFile/" + file.getOriginalFilename();
		
		File localFile = new File(localFilePath);
		
		try {
			file.transferTo(localFile);
			// is, os로 해줬던 작업을 transferTo 메소드로 간략화할 수 있음
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}























