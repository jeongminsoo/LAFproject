package com.laf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.NoticeDao;
import com.laf.dto.NoticeDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeUpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("board/imgcopy");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mr = null;
		NoticeDao dao = NoticeDao.getInstance();
		int nNo;
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();
			String param = paramName.nextElement();
			filename = mr.getFilesystemName(param);

			nNo = Integer.parseInt(mr.getParameter("nNo"));
			NoticeDto bfnotice = dao.getNotice(nNo);
			
			String nFilename = (filename == null) ? bfnotice.getnFilename() : filename;
			String nTitle = mr.getParameter("nTitle");
			String nContent = mr.getParameter("nContent");
			
			
			NoticeDto notice = new NoticeDto(nNo, nTitle, nContent, nFilename, 0, null);

			int result = dao.updateNotice(notice);
			request.setAttribute("noticeUpdateResult", result);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		File serverFile = new File(path + "/" + filename);
		if (serverFile.exists() && !filename.equals(dao.getNotice(Integer.parseInt(mr.getParameter("nNo"))).getnFilename())) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\LAFproject\\source\\project\\WebContent\\board\\imgcopy/" + filename);
				byte[] bs = new byte[(int)serverFile.length()];
				while (true) {
					int readCnt = is.read(bs);
					if (readCnt == -1) {
						break;
					}
					os.write(bs, 0, readCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null) {
						os.close();
					}
					if (is != null) {
						is.close();
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		

	}

}
