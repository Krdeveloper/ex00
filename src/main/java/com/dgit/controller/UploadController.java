package com.dgit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.util.MediaUtils;
import com.dgit.util.UploadFileUtils;

@Controller
public class UploadController {
	private static String innerUploadPath = "resources/upload";
	
	@Resource(name="uploadPath") //id로 주입(DI)받을 때 사용
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@RequestMapping(value="innerUpload", method=RequestMethod.GET)
	public String uploadForm(){
		logger.info("---------------innerUpload GET ------------");
		return "innerUploadForm";
	}
	
	@RequestMapping(value="innerUpload", method=RequestMethod.POST)
	public String innerUploadResult(String writer, MultipartFile file, 
			HttpServletRequest request, Model model) throws IOException{
		logger.info("writer : " + writer);
		logger.info("file.size : " +file.getSize());
		logger.info("file.originalName : "+ file.getOriginalFilename());
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		logger.info("root_path : " + root_path);
		
		File dirPath = new File(root_path + "/" +innerUploadPath);
		if(dirPath.exists()==false){
			dirPath.mkdirs();
		}
		
		UUID uid = UUID.randomUUID();//중복되지 않는 고유한 키값을 설정할 때 사용
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		File target = new File(root_path + "/" + innerUploadPath + "/" + savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		model.addAttribute("writer",writer);
		model.addAttribute("filename",innerUploadPath + "/" + savedName);
		return "innerUploadResult";
	}
	
	@RequestMapping(value="innerMultiUpload", method=RequestMethod.GET)
	public String innerMultiUploadForm(){
		return "innerMultiUploadForm";
	}
	
	@RequestMapping(value="innerMultiUpload", method=RequestMethod.POST)
	public String innerMultiUploadResult(String writer, List<MultipartFile> files,
							HttpServletRequest request, Model model) throws IOException{
		logger.info("---------innerMultiUpload POST---------");
		logger.info("writer : " + writer);
		
		for(MultipartFile file : files){
			logger.info("file.size : " +file.getSize());
			logger.info("file.originalName : "+ file.getOriginalFilename());
		}
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		
		File dir = new File(root_path + "/" + innerUploadPath);
		if(dir.exists()==false){
			dir.mkdirs();
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(MultipartFile file : files){
			UUID uid = UUID.randomUUID();
			String savedName = uid.toString() + "_" + file.getOriginalFilename();
			File target = new File(root_path + "/" + innerUploadPath + "/" + savedName);
			FileCopyUtils.copy(file.getBytes(), target);
			list.add(innerUploadPath + "/" + savedName);
		}
		
		model.addAttribute("writer", writer);
		model.addAttribute("files", list);
		
		return "innerMultiUploadResult";
	}
	
	@RequestMapping(value="outUpload" , method=RequestMethod.GET)
	public String outUploadForm(){
		return "outerUploadForm";
	}
	
	@RequestMapping(value="outUpload", method=RequestMethod.POST)
	public String outUploadResult(String writer, MultipartFile file, Model model) throws IOException{
		logger.info("-------------outUpload POST------------");
		logger.info("writer:" + writer);
		logger.info("file.size" + file.getSize());
		logger.info("filename : " + file.getOriginalFilename());
		
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		File target = new File(uploadPath , savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		model.addAttribute("writer", writer);
		model.addAttribute("filename", savedName);
		
		return "outerUploadResult";
	}
	
	@ResponseBody
	@RequestMapping(value="displayFile") //displayFile?filename=boxing.jpg
	public ResponseEntity<byte[]> displayFile(String filename) throws IOException{
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		logger.info("--------displayFile : " + filename);
		
		try{
			String formatName = filename.substring(filename.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(mType);
			
			in = new FileInputStream(uploadPath + "/" + filename);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), header, HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			in.close();
		}
		
		return entity;
	}
	
	@RequestMapping(value="dragUpload" , method=RequestMethod.GET)
	public String drapUploadForm(){
		return "DragandDropForm";
	}
	
	@ResponseBody
	@RequestMapping(value="dragUpload" , method=RequestMethod.POST)
	public ResponseEntity<List<String>> drapUploadResult(String writer, List<MultipartFile> files){
		ResponseEntity<List<String>> entity = null;
		logger.info("-------------dragUpload POST------------");
		logger.info("writer:" + writer);
		
		for(MultipartFile file : files){
			logger.info("file.size" + file.getSize());
			logger.info("filename : " + file.getOriginalFilename());
		}		
		
		try {
			//c:/zzz/upload 폴더에 file을 upload 한다.
			ArrayList<String> list = new ArrayList<>();
			for(MultipartFile file : files){
				String thumb = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				list.add(thumb);
			}	
			
			
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String filename){
		ResponseEntity<String> entity = null;
		logger.info("-----------------deleteFile POST");
		logger.info("filename : " + filename);
		
		try {
			//thumbnail
			File file = new File(uploadPath + filename);
			System.out.println("========" + uploadPath + filename);
			file.delete();
			//원본
			String front = filename.substring(0, 12); //0~11
			String end = filename.substring(14); // 14~끝까지
			String originalName = front + end;
			File file2 = new File(uploadPath + originalName);
			file2.delete();
			
			
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}






