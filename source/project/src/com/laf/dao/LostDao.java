package com.laf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.laf.dto.LostDto;

public class LostDao {

	public static final int FAIL 	= 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	private static LostDao instance = new LostDao();
	
	public static LostDao getInstance() {
		return instance;
	}
	
	private LostDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 분실물 게시글 등록
	public int writeLost(LostDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "INSERT INTO LOST (LNO, LTITLE, LCONTENT, MID, LOB, LLOCAL, LLOCATION, LDATE, LPHOTO, LTEL, LIP)" + 
										" VALUES ('L'||TRIM(TO_CHAR(SYSDATE,'YYYYMMDD'))||TRIM(TO_CHAR(LOST_SEQ.NEXTVAL, '000000')), ?, ?, ?, ?, ?," + 
													" ?, ?, ?, ?, ?)";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getlTitle());
			pstmt.setString(2, dto.getlContent());
			pstmt.setString(3, dto.getmId());
			pstmt.setString(4, dto.getlOb());
			pstmt.setString(5, dto.getlLocal());
			pstmt.setString(6, dto.getlLocation());
			pstmt.setDate(7, dto.getlDate());
			pstmt.setString(8, dto.getlPhoto());
			pstmt.setString(9, dto.getlTel());
			pstmt.setString(10, dto.getlIp());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 분실물 게시글 수정
	public int updateLost(LostDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE LOST SET LTITLE = ?, LCONTENT = ?, LLOCAL = ?, LLOCATION = ?," + 
				" LDATE = ?, LPHOTO = ?, LTEL = ?, LIP = ? WHERE LNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getlTitle());
			pstmt.setString(2, dto.getlContent());
			pstmt.setString(3, dto.getlLocal());
			pstmt.setString(4, dto.getlLocation());
			pstmt.setDate(5, dto.getlDate());
			pstmt.setString(6, dto.getlPhoto());
			pstmt.setString(7, dto.getlTel());
			pstmt.setString(8, dto.getlIp());
			pstmt.setString(9, dto.getlNo());
			
			result 	= 	pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 분실물 목록
	public ArrayList<LostDto> lostList(int start, int end) {
		ArrayList<LostDto> dtos = new ArrayList<LostDto>();
		
		Connection 				conn 	= null;
		PreparedStatement 		pstmt 	= null;
		ResultSet 				rs 		= null;
		
		String 					sql 	= "SELECT *" + 
											" FROM (SELECT ROWNUM RN,  A.*" + 
													" FROM (SELECT L.*, MNAME FROM LOST L, LAF_MEMBER M WHERE L.MID = M.MID ORDER BY LRDATE DESC) A)" + 
											" WHERE RN BETWEEN ? AND ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String 	lNo			=	rs.getString("lno");
				String 	lTitle		=	rs.getString("ltitle");
				String 	lContent	=	rs.getString("lcontent");
				String 	mId			=	rs.getString("mid");
				Date 	lRdate		=	rs.getDate("lrdate");
				String 	lOb			=	rs.getString("lob");
				String 	lLocal		=	rs.getString("llocal");
				String 	lLocation	=	rs.getString("llocation");
				Date 	lDate		=	rs.getDate("ldate");
				String 	lPhoto		=	rs.getString("lphoto");
				int 	lHit		=	rs.getInt("lhit");
				String 	lTel		=	rs.getString("ltel");
				String 	lIp			=	rs.getString("lip");
				String	mName		=	rs.getString("mname");
			
				dtos.add(new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, mName));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
	}
}
