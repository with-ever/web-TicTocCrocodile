package kr.whenever.crocodile.controller.image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.whenever.crocodile.util.AWSS3Util;
import kr.whenever.crocodile.util.FileUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value = "/api/v1/images")
public class WSImageController {
	
	/**
	 * 매칭 등록.
	 * @param matching
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerMatching (
			HttpServletRequest request
			) throws IllegalStateException, IOException{
		Map<String, String> result = new HashMap<String, String>();
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("image");
		String id = (String) multipartHttpServletRequest.getParameter("id");
		String type = (String) multipartHttpServletRequest.getParameter("type");
		
		AWSS3Util s3Util = new AWSS3Util();
		String bucketName = s3Util.createBuckectName(type);
		String fileName = s3Util.createFileName(id, multipartFile.getOriginalFilename());
		s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(multipartFile));
		
		String url = s3Util.getFileURL(bucketName, fileName);
		result.put("results", url.split("\\?")[0]);
		return result;
	}
	
}
