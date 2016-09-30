/**
 * 
 */
package com.raj.employee.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.employee.serviceImpl.ExportToWordServiceImpl;

/**
 * @author Raj Tomar
 *
 */
@Controller
public class ExportToMsWord {
	
	@Autowired
	private ExportToWordServiceImpl wordService;  
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wordPara", method=RequestMethod.GET)
	public void exportToMsWordPara(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String filePath = session.getServletContext().getRealPath(File.separator);
		System.out.println("File Path\n"+filePath);
		try{
			String fileName = "wordPara.docx";
			wordService.exportMsWordParagraphs(fileName, filePath);
			File downloadFile = new File(filePath + File.separator + fileName);
			if(downloadFile.length() != 0){
				InputStream is = new FileInputStream(downloadFile);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attatchment; filename=\""+ downloadFile.getName()+"\"");
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[(int) downloadFile.length()];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
			if(downloadFile.exists()){
				downloadFile.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wordImage", method=RequestMethod.GET)
	public void exportMsWordImage(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String filePath = session.getServletContext().getRealPath(File.separator);
		System.out.println("File Path\n"+filePath);
		try{
			String fileName = "wordImages.docx";
			wordService.exportImagesInWord(fileName, filePath);
			File downloadFile = new File(filePath + File.separator + fileName);
			if(downloadFile.length() != 0){
				InputStream is = new FileInputStream(downloadFile);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attatchment; filename=\""+ downloadFile.getName()+"\"");
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[(int) downloadFile.length()];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
			if(downloadFile.exists()){
				downloadFile.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wordSimpleTable", method=RequestMethod.GET)
	public void exportMsWordSimpleTable(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String filePath = session.getServletContext().getRealPath(File.separator);
		System.out.println("File Path\n"+filePath);
		try{
			String fileName = "wordSimpleTable.docx";
			wordService.exportMsWordSimpleTable(fileName, filePath);
			File downloadFile = new File(filePath + File.separator + fileName);
			if(downloadFile.length() != 0){
				InputStream is = new FileInputStream(downloadFile);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attatchment; filename=\""+ downloadFile.getName()+"\"");
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[(int) downloadFile.length()];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
			if(downloadFile.exists()){
				downloadFile.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wordStyledTable", method=RequestMethod.GET)
	public void exportMsWordStyledTable(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String filePath = session.getServletContext().getRealPath(File.separator);
		System.out.println("File Path\n"+filePath);
		try{
			String fileName = "wordStyledTable.docx";
			wordService.exportMsWordStyledTable(fileName, filePath);
			File downloadFile = new File(filePath + File.separator + fileName);
			if(downloadFile.length() != 0){
				InputStream is = new FileInputStream(downloadFile);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attatchment; filename=\""+ downloadFile.getName()+"\"");
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[(int) downloadFile.length()];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
			if(downloadFile.exists()){
				downloadFile.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/table", method=RequestMethod.GET)
	public void exportMsWordSample(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String filePath = session.getServletContext().getRealPath(File.separator);
		System.out.println("File Path\n"+filePath);
		try{
			String fileName = "sampleTable.docx";
			wordService.exportMsWordSampleTable(fileName, filePath);
			File downloadFile = new File(filePath + File.separator + fileName);
			if(downloadFile.length() != 0){
				InputStream is = new FileInputStream(downloadFile);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attatchment; filename=\""+ downloadFile.getName()+"\"");
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[(int) downloadFile.length()];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
			if(downloadFile.exists()){
				downloadFile.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
