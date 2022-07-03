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

public class NoticeWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("board/imgcopy");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();
			String param = paramName.nextElement();
			filename = mr.getFilesystemName(param);

			String nTitle = mr.getParameter("nTitle");
			String nContent = mr.getParameter("nContent");

			String nFilename = (filename == null) ? "" : filename;
			
			NoticeDao dao = NoticeDao.getInstance();
			NoticeDto notice = new NoticeDto(0, nTitle, nContent, nFilename, 0, null);
			int result = dao.writeNotice(notice);
			request.setAttribute("noticeWriteResult", result);
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		File serverFile = new File(path + "/" + filename);
		if (serverFile.exists() && !filename.equals(null)) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\LAFproject\\source\\project\\WebContent\\board\\imgcopy" + filename);
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
