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

import com.laf.dto.NoticeDto;

public class NoticeDao {

	public static final int FAIL 	= 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance() {
		return instance;
	}
	
	private NoticeDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 공지사항 등록
	public int writeNotice(NoticeDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "INSERT INTO NOTICE (NNO, NTITLE, NCONTENT, NFILENAME)"
										+ " VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getnTitle());
			pstmt.setString(2, dto.getnContent());
			pstmt.setString(3, dto.getnFilename());
			
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
	
	// 공지사항 수정
	public int updateNotice(NoticeDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE NOTICE SET NTITLE = ?, NCONTENT = ?, NFILENAME = ?" + 
										" WHERE NNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getnTitle());
			pstmt.setString(2, dto.getnContent());
			pstmt.setString(3, dto.getnFilename());
			pstmt.setInt(4, dto.getnNo());
			
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
	
	// 공지사항 삭제
	public int deleteNotice(int nNo) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "DELETE FROM NOTICE WHERE NNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			
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
	
	// 공지사항 목록
	public ArrayList<NoticeDto> noticeList(int start, int end) {
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet			rs		= null;
		
		String 				sql 	= "SELECT *" + 
										" FROM (SELECT ROWNUM RN, A.*" + 
												" FROM (SELECT * FROM NOTICE ORDER BY NDATE DESC) A)" + 
										" WHERE RN BETWEEN ? AND ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs		=	pstmt.executeQuery();
			
			while (rs.next()) {
				int 	nNo			=	rs.getInt("nno");
				String 	nTitle		=	rs.getString("ntitle");
				String 	nContent	=	rs.getString("ncontent");
				String 	nFilename	=	rs.getString("nfilename");
				int 	nHit		=	rs.getInt("nhit");
				Date	nDate		=	rs.getDate("ndate");
				
				dtos.add(new NoticeDto(nNo, nTitle, nContent, nFilename, nHit, nDate));
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
	
	// 공지사항 보기
	public NoticeDto contentNotice(int nNo) {
		NoticeDto dto = null;
		nHitUp(nNo);
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet			rs		= null;
		
		String 				sql 	= "SELECT * FROM NOTICE WHERE NNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String 	nTitle		=	rs.getString("ntitle");
				String 	nContent	=	rs.getString("ncontent");
				String 	nFilename	=	rs.getString("nfilename");
				int 	nHit		=	rs.getInt("nhit");
				Date	nDate		=	rs.getDate("ndate");
				
				dto = new NoticeDto(nNo, nTitle, nContent, nFilename, nHit, nDate);
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
		return dto;
	}
	
	// 조회수 올리기
	private void nHitUp(int nNo) {
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE NOTICE SET NHIT = NHIT + 1 WHERE NNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			pstmt.executeQuery();
			
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
	}
	
	// dto 가져오기
	public NoticeDto getNotice(int nNo) {
		NoticeDto dto = null;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet			rs		= null;
		
		String 				sql 	= "SELECT * FROM NOTICE WHERE NNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String 	nTitle		=	rs.getString("ntitle");
				String 	nContent	=	rs.getString("ncontent");
				String 	nFilename	=	rs.getString("nfilename");
				int 	nHit		=	rs.getInt("nhit");
				Date	nDate		=	rs.getDate("ndate");
				
				dto = new NoticeDto(nNo, nTitle, nContent, nFilename, nHit, nDate);
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
		return dto;
	}
	
	// 공지사항 수
	public int countNotice() {
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) CNT FROM NOTICE";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cnt;
	}
}
