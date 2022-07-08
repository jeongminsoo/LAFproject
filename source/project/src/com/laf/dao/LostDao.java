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
													" FROM (SELECT L.*, MNAME, PWCODE, CODENAME LCC FROM LOST L, LAF_MEMBER M, LST_CODE LC" + 
															" WHERE L.MID = M.MID AND L.LSTCODE = LC.LSTCODE AND L.LSTCODE = 'LST00' ORDER BY LRDATE DESC) A)" + 
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
				String	pwCode		=	rs.getString("pwcode");
				String 	lstCode		=	rs.getString("lstcode");
				String 	lcc			=	rs.getString("lcc");
			
				dtos.add(new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, mName, pwCode, lstCode, lcc));
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
	// 분실물 접수 취소
	public int cancelLost(String lNo) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE LOST SET LSTCODE = 'LST02' WHERE LNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, lNo);
			
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
	
	// 분실물 처리완료
		public int complete(String lNo) {
			int result = FAIL;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "UPDATE LOST SET LSTCODE = 'LST01' WHERE LNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, lNo);
				
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
	
	// 분실물 게시글 삭제
	public int deleteLost(String lNo) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "DELETE FROM LOST WHERE LNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, lNo);
			
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
	
	// 분실물관리
	public ArrayList<LostDto> myLostList(String mId, int start, int end) {
		ArrayList<LostDto> dtos = new ArrayList<LostDto>();
		
		Connection 				conn 	= null;
		PreparedStatement 		pstmt 	= null;
		ResultSet 				rs 		= null;
		
		String 					sql 	= "SELECT *" + 
											" FROM (SELECT ROWNUM RN,  A.*" + 
													" FROM (SELECT L.*, CODENAME LCC FROM LOST L, LST_CODE LC" + 
															" WHERE L.LSTCODE = LC.LSTCODE AND MID = ? ORDER BY L.LSTCODE, LRDATE DESC) A)" + 
											" WHERE RN BETWEEN ? AND ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs 		= 	pstmt.executeQuery();
			
			while (rs.next()) {
				String 	lNo			=	rs.getString("lno");
				String 	lTitle		=	rs.getString("ltitle");
				String 	lContent	=	rs.getString("lcontent");
				Date 	lRdate		=	rs.getDate("lrdate");
				String 	lOb			=	rs.getString("lob");
				String 	lLocal		=	rs.getString("llocal");
				String 	lLocation	=	rs.getString("llocation");
				Date 	lDate		=	rs.getDate("ldate");
				String 	lPhoto		=	rs.getString("lphoto");
				int 	lHit		=	rs.getInt("lhit");
				String 	lTel		=	rs.getString("ltel");
				String 	lIp			=	rs.getString("lip");
				String 	lstCode		=	rs.getString("lstcode");
				String 	lcc			=	rs.getString("lcc");
			
				dtos.add(new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, null, null, lstCode, lcc));
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
	
	// 분실물 보기
		public LostDto contentLost(String lNo) {
			LostDto dto = null;
			lHitUp(lNo);
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet			rs		= null;
			
			String 				sql 	= "SELECT L.*, MNAME, PWCODE, CODENAME LCC FROM LOST L, LAF_MEMBER M, LST_CODE LC WHERE L.MID = M.MID AND L.LSTCODE = LC.LSTCODE AND LNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, lNo);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
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
					String	pwCode		=	rs.getString("pwcode");
					String 	lstCode		=	rs.getString("lstcode");
					String 	lcc			=	rs.getString("lcc");
					
					dto = new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, mName, pwCode, lstCode, lcc);
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
		private void lHitUp(String lNo) {
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "UPDATE LOST SET LHIT = LHIT + 1 WHERE LNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, lNo);
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
		public LostDto getLost(String lNo) {
			LostDto dto = null;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet			rs		= null;
			
			String 				sql 	= "SELECT L.*, MNAME, PWCODE, CODENAME LCC FROM LOST L, LAF_MEMBER M, LST_CODE LC"
											+ " WHERE L.MID = M.MID AND L.LSTCODE = LC.LSTCODE AND LNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, lNo);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
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
					String	pwCode		=	rs.getString("pwcode");
					String 	lstCode		=	rs.getString("lstcode");
					String 	lcc			=	rs.getString("lcc");
					
					dto = new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, mName, pwCode, lstCode, lcc);
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
		
		// 분실물 수
		public int countLost() {
			int cnt = 0;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet 			rs 		= null;
			
			String 				sql 	= "SELECT COUNT(*) CNT FROM LOST WHERE LSTCODE = 'LST00'";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				rs 		= 	pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt("cnt");

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
			return cnt;
		}
		
		// 분실물 상세검색
		public ArrayList<LostDto> detailSearch(String lOb, String lTitle, Date lDate1, Date lDate2, String lLocal, int start, int end) {
			ArrayList<LostDto> dtos = new ArrayList<LostDto>();
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT *" + 
												" FROM (SELECT ROWNUM RN, A.*" + 
														" FROM (SELECT L.*, MNAME, CODENAME LCC" + 
																" FROM LOST L, LAF_MEMBER M, LST_CODE LC" + 
																" WHERE L.LOB LIKE '%'||?||'%' AND L.LTITLE LIKE '%'||?||'%'" + 
																	" AND L.LDATE BETWEEN ? AND ?" + 
																	" AND L.LLOCAL = ? AND NOT L.LSTCODE = 'LST02'" + 
																	" AND L.MID = L.MID AND L.LSTCODE = LC.LSTCODE ORDER BY LDATE DESC) A)" + 
												" WHERE RN BETWEEN ? AND ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, lOb);
				pstmt.setString(2, lTitle);
				pstmt.setDate(3, lDate1);
				pstmt.setDate(4, lDate2);
				pstmt.setString(5, lLocal);
				pstmt.setInt(6, start);
				pstmt.setInt(7, end);
				rs 		= 	pstmt.executeQuery();
				
				while (rs.next()) {
					String  mId			=	rs.getString("mid");
					String 	lNo			=	rs.getString("lno");
					lTitle				=	rs.getString("ltitle");
					String 	lContent	=	rs.getString("lcontent");
					Date 	lRdate		=	rs.getDate("lrdate");
					lOb					=	rs.getString("lob");
					lLocal				=	rs.getString("llocal");
					String	lLocation	=	rs.getString("llocation");
					Date 	lDate		=	rs.getDate("ldate");
					String 	lPhoto		=	rs.getString("lphoto");
					int 	lHit		=	rs.getInt("lhit");
					String 	lTel		=	rs.getString("ltel");
					String 	lIp			=	rs.getString("lip");
					String 	mName		=	rs.getString("mname");
					String	pwCode		=	rs.getString("pwcode");
					String 	lstCode		=	rs.getString("lstcode");
					String 	lcc			=	rs.getString("lcc");
				
					dtos.add(new LostDto(lNo, lTitle, lContent, mId, lRdate, lOb, lLocal, lLocation, lDate, lPhoto, lHit, lTel, lIp, mName, pwCode, lstCode, lcc));
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
