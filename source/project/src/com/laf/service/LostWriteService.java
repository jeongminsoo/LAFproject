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

import com.laf.dao.LostDao;
import com.laf.dto.LostDto;
import com.laf.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class LostWriteService implements Service {

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
			
			String lOb = mr.getParameter("lOb");
			String lLocal = mr.getParameter("lLocal");
			String lLocation = mr.getParameter("lLocation");
			String lTel = mr.getParameter("lTel");
			String lTitle = mr.getParameter("lTitle");
			String lContent = mr.getParameter("lContent");
			String tempDate = mr.getParameter("tempDate");
			Date lDate = null;
			if (!tempDate.equals("")) {
				lDate = Date.valueOf(tempDate);
			}
			String lPhoto = (img == null) ? "noimg.gif" : img;
			String lIp = request.getRemoteAddr();
			
			LostDao dao = LostDao.getInstance();
			LostDto lost = new LostDto(null, lTitle, lContent, mId, null, lOb, lLocal, lLocation, lDate, lPhoto, 0, lTel, lIp, null, null, null);
			int result = dao.writeLost(lost);
			request.setAttribute("lostWriteResult", result);
			
			
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
