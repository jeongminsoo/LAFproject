package com.laf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.FindDao;
import com.laf.dto.FindDto;
import com.laf.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FindWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("board/imgcopy");
		int maxSize = 1024*1024;
		String img = "";
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramName = mr.getFileNames();
			String param = paramName.nextElement();
			img = mr.getFilesystemName(param);
			
			HttpSession session = request.getSession();
			
			MemberDto dto = (MemberDto) session.getAttribute("member");
			
			String mId = dto.getmId();
			
			String fOb = mr.getParameter("fOb");
			String fLocal = mr.getParameter("fLocal");
			String fLocation = mr.getParameter("fLocation");
			String fStorage = mr.getParameter("fStorage");
			String mName = mr.getParameter("mName");
			String fTel = mr.getParameter("fTel");
			String fTitle = mr.getParameter("fTitle");
			String fContent = mr.getParameter("fContent");
			String tempDate = mr.getParameter("tempDate");
			Date fDate = null;
			if (!tempDate.equals("")) {
				fDate = Date.valueOf(tempDate);
			}
			String fPhoto = (img == null) ? "noimg.gif" : img;
			String fIp = request.getRemoteAddr();
			
			FindDao dao = FindDao.getInstance();
			FindDto find = new FindDto(null, fTitle, fContent, mId, null, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, 0, fTel, fIp, mName, null, null);
			int result = dao.writeFind(find);
			request.setAttribute("findWriteResult", result);
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		File serverFile = new File(path + "/" + img);
		if (serverFile.exists() && !img.equals("noimg.gif")) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\LAFproject\\source\\project\\WebContent\\board\\imgcopy" + img);
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
