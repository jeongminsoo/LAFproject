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
import com.laf.dto.FindDto;

public class FindDao {

	public static final int FAIL 	= 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	private static FindDao instance = new FindDao();
	
	public static FindDao getInstance() {
		return instance;
	}
	
	private FindDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 습득물 게시글 등록
		public int writeFind(FindDto dto) {
			int result = FAIL;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "INSERT INTO FIND (FNO, FTITLE, FCONTENT, MID, FOB, FLOCAL, FLOCATION, FDATE, FSTORAGE, FPHOTO, FTEL, FIP)" + 
											" VALUES ('F'||TRIM(TO_CHAR(SYSDATE,'YYYYMMDD'))||TRIM(TO_CHAR(FIND_SEQ.NEXTVAL, '000000')), ?, ?, ?, ?, ?," + 
														" ?, ?, ?, ?, ?, ?)";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, dto.getfTitle());
				pstmt.setString(2, dto.getfContent());
				pstmt.setString(3, dto.getmId());
				pstmt.setString(4, dto.getfOb());
				pstmt.setString(5, dto.getfLocal());
				pstmt.setString(6, dto.getfLocation());
				pstmt.setDate(7, dto.getfDate());
				pstmt.setString(8, dto.getfStorage());
				pstmt.setString(9, dto.getfPhoto());
				pstmt.setString(10, dto.getfTel());
				pstmt.setString(11, dto.getfIp());
				
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
		
		// 습득물 게시글 수정
		public int updateFind(FindDto dto) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "UPDATE FIND SET FTITLE = ?, FCONTENT = ?, FLOCAL = ?, FLOCATION = ?," + 
							" FSTORAGE = ?, FDATE = ?, FPHOTO = ?, FTEL = ?, FIP = ? WHERE FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, dto.getfTitle());
				pstmt.setString(2, dto.getfContent());
				pstmt.setString(3, dto.getfLocal());
				pstmt.setString(4, dto.getfLocation());
				pstmt.setString(5, dto.getfStorage());
				pstmt.setDate(6, dto.getfDate());
				pstmt.setString(7, dto.getfPhoto());
				pstmt.setString(8, dto.getfTel());
				pstmt.setString(9, dto.getfIp());
				pstmt.setString(10, dto.getfNo());
				
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
		
		// 습득물 목록
		public ArrayList<FindDto> findList(int start, int end) {
			ArrayList<FindDto> dtos = new ArrayList<FindDto>();
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT *" + 
												" FROM (SELECT ROWNUM RN,  A.*" + 
														" FROM (SELECT F.*, MNAME, CODENAME FCC FROM FIND F, LAF_MEMBER M, FST_CODE FC" + 
																" WHERE F.MID = M.MID AND F.FSTCODE = FC.FSTCODE AND F.FSTCODE = 'FST00' ORDER BY FRDATE DESC) A)" + 
												" WHERE RN BETWEEN ? AND ?";
			
			try {
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					String 	fNo			=	rs.getString("fno");
					String 	fTitle		=	rs.getString("ftitle");
					String 	fContent	=	rs.getString("fcontent");
					String 	mId			=	rs.getString("mid");
					Date 	fRdate		=	rs.getDate("frdate");
					String 	fOb			=	rs.getString("fob");
					String 	fLocal		=	rs.getString("flocal");
					String 	fLocation	=	rs.getString("flocation");
					Date 	fDate		=	rs.getDate("fdate");
					String	fStorage	=	rs.getString("fstorage");
					String 	fPhoto		=	rs.getString("fphoto");
					int 	fHit		=	rs.getInt("fhit");
					String 	fTel		=	rs.getString("ftel");
					String 	fIp			=	rs.getString("fip");
					String	mName		=	rs.getString("mname");
					String 	fstCode		=	rs.getString("fstcode");
					String 	fcc			=	rs.getString("fcc");
				
					dtos.add(new FindDto(fNo, fTitle, fContent, mId, fRdate, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, fHit, fTel, fIp, mName, fstCode, fcc));
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
		// 습득물 등록 취소
		public int cancelFind(String fNo) {
			int result = FAIL;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "UPDATE FIND SET FSTCODE = 'FST02' WHERE FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fNo);
				
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
			public int complete(String fNo) {
				int result = FAIL;
				
				Connection 			conn 	= null;
				PreparedStatement 	pstmt 	= null;
				
				String 				sql 	= "UPDATE LOST SET LSTCODE = 'LST01' WHERE LNO = ?";
				
				try {
					
					conn 	= 	ds.getConnection();
					pstmt 	= 	conn.prepareStatement(sql);
					pstmt.setString(1, fNo);
					
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
		public int deleteLost(String fNo) {
			int result = FAIL;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "DELETE FROM FIND WHERE FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fNo);
				
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
		
		// 습득물 관리
		public ArrayList<FindDto> myFindList(String mId, int start, int end) {
			ArrayList<FindDto> dtos = new ArrayList<FindDto>();
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT *" + 
												" FROM (SELECT ROWNUM RN,  A.*" + 
														" FROM (SELECT F.*, CODENAME FCC FROM FIND F, FST_CODE FC" + 
																" WHERE F.FSTCODE = FC.FSTCODE AND MID = ? ORDER BY F.FSTCODE DESC, FRDATE DESC) A)" + 
												" WHERE RN BETWEEN ? AND ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, mId);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs 		= 	pstmt.executeQuery();
				
				while (rs.next()) {
					String 	fNo			=	rs.getString("fno");
					String 	fTitle		=	rs.getString("ftitle");
					String 	fContent	=	rs.getString("fcontent");
					Date 	fRdate		=	rs.getDate("frdate");
					String 	fOb			=	rs.getString("fob");
					String 	fLocal		=	rs.getString("flocal");
					String 	fLocation	=	rs.getString("flocation");
					Date 	fDate		=	rs.getDate("fdate");
					String	fStorage	= 	rs.getString("fstorage");
					String 	fPhoto		=	rs.getString("fphoto");
					int 	fHit		=	rs.getInt("fhit");
					String 	fTel		=	rs.getString("ftel");
					String 	fIp			=	rs.getString("fip");
					String 	fstCode		=	rs.getString("fstcode");
					String 	fcc			=	rs.getString("fcc");
				
					dtos.add(new FindDto(fNo, fTitle, fContent, mId, fRdate, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, fHit, fTel, fIp, null, fstCode, fcc));
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
		
		// 조회수 올리기
		private void fHitUp(String fNo) {
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			
			String 				sql 	= "UPDATE FIND SET FHIT = FHIT + 1 WHERE FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fNo);
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
		
		// 습득물 보기
		public FindDto contentFind(String fNo) {
			FindDto dto = null;
			fHitUp(fNo);
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet			rs		= null;
			
			String 				sql 	= "SELECT F.*, MNAME, CODENAME FCC FROM FIND F, LAF_MEMBER M, FST_CODE FC WHERE F.MID = M.MID AND F.FSTCODE = FC.FSTCODE AND FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fNo);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					String 	fTitle		=	rs.getString("ftitle");
					String 	fContent	=	rs.getString("fcontent");
					String 	mId			=	rs.getString("mid");
					Date 	fRdate		=	rs.getDate("frdate");
					String  fOb			=	rs.getString("fob");
					String	fLocal		=	rs.getString("flocal");
					String	fLocation	=	rs.getString("flocation");
					Date	fDate		=	rs.getDate("fdate");
					String	fStorage	=	rs.getString("fstorage");
					String	fPhoto		=	rs.getString("fphoto");
					int 	fHit		=	rs.getInt("fhit");
					String	fTel		=	rs.getString("ftel");
					String	fIp			=	rs.getString("fip");
					String 	mName		=	rs.getString("mname");
					String	fstCode		=	rs.getString("fstcode");
					String	fcc			=	rs.getString("fcc");
					
					dto = new FindDto(fNo, fTitle, fContent, mId, fRdate, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, fHit, fTel, fIp, mName, fstCode, fcc);
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
		
		// dto 가져오기
		public FindDto getFind(String fNo) {
			FindDto dto = null;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet			rs		= null;
			
			String 				sql 	= "SELECT F.*, MNAME, CODENAME FCC FROM FIND F, LAF_MEMBER M, FST_CODE FC"
					+ 						" WHERE F.MID = M.MID AND F.FSTCODE = FC.FSTCODE AND FNO = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fNo);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					String 	fTitle		=	rs.getString("ftitle");
					String 	fContent	=	rs.getString("fcontent");
					String 	mId			=	rs.getString("mid");
					Date 	fRdate		=	rs.getDate("frdate");
					String  fOb			=	rs.getString("fob");
					String	fLocal		=	rs.getString("flocal");
					String	fLocation	=	rs.getString("flocation");
					Date	fDate		=	rs.getDate("fdate");
					String	fStorage	=	rs.getString("fstorage");
					String	fPhoto		=	rs.getString("fphoto");
					int 	fHit		=	rs.getInt("fhit");
					String	fTel		=	rs.getString("ftel");
					String	fIp			=	rs.getString("fip");
					String 	mName		=	rs.getString("mname");
					String	fstCode		=	rs.getString("fstcode");
					String	fcc			=	rs.getString("fcc");
					
					dto = new FindDto(fNo, fTitle, fContent, mId, fRdate, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, fHit, fTel, fIp, mName, fstCode, fcc);
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
		// 습득물 수
		public int countFind() {
			int cnt = 0;
			
			Connection 			conn 	= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet 			rs 		= null;
			
			String 				sql 	= "SELECT COUNT(*) CNT FROM FIND WHERE FSTCODE = 'FST00'";
			
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
		
		// 습득물 상세검색
		public ArrayList<FindDto> detailSearch(String fOb, String fTitle, Date fDate1, Date fDate2, String fLocal, int start, int end) {
			ArrayList<FindDto> dtos = new ArrayList<FindDto>();
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT *" + 
												" FROM (SELECT ROWNUM RN, A.*" + 
														" FROM (SELECT F.*, MNAME, CODENAME FCC" + 
																" FROM FIND F, LAF_MEMBER M, FST_CODE FC" + 
																" WHERE F.FOB LIKE '%'||?||'%' AND F.FTITLE LIKE '%'||?||'%'" + 
																	" AND F.FDATE BETWEEN ? AND ?" + 
																	" AND F.FLOCAL = ? AND NOT F.FSTCODE = 'FST02'" + 
																	" AND F.MID = M.MID AND F.FSTCODE = FC.FSTCODE ORDER BY FDATE DESC) A)" + 
												" WHERE RN BETWEEN ? AND ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fOb);
				pstmt.setString(2, fTitle);
				pstmt.setDate(3, fDate1);
				pstmt.setDate(4, fDate2);
				pstmt.setString(5, fLocal);
				pstmt.setInt(6, start);
				pstmt.setInt(7, end);
				rs 		= 	pstmt.executeQuery();
				
				while (rs.next()) {
					String  mId			=	rs.getString("mid");
					String 	fNo			=	rs.getString("fno");
					fTitle				=	rs.getString("ftitle");
					String 	fContent	=	rs.getString("fcontent");
					Date 	fRdate		=	rs.getDate("frdate");
					fOb					=	rs.getString("fob");
					fLocal				=	rs.getString("flocal");
					String 	fLocation	=	rs.getString("flocation");
					Date 	fDate		=	rs.getDate("fdate");
					String	fStorage	= 	rs.getString("fstorage");
					String 	fPhoto		=	rs.getString("fphoto");
					int 	fHit		=	rs.getInt("fhit");
					String 	fTel		=	rs.getString("ftel");
					String 	fIp			=	rs.getString("fip");
					String 	mName		=	rs.getNString("mname");
					String 	fstCode		=	rs.getString("fstcode");
					String 	fcc			=	rs.getString("fcc");
				
					dtos.add(new FindDto(fNo, fTitle, fContent, mId, fRdate, fOb, fLocal, fLocation, fDate, fStorage, fPhoto, fHit, fTel, fIp, mName, fstCode, fcc));
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
		
		public int countDetailSearch(String fOb, String fTitle, Date fDate1, Date fDate2, String fLocal) {
			int cnt = 0;
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT COUNT(*) CNT FROM (SELECT *" + 
																			" FROM (SELECT ROWNUM RN, A.*" + 
																					" FROM (SELECT F.*, MNAME, CODENAME FCC" + 
																							" FROM FIND F, LAF_MEMBER M, FST_CODE FC" + 
																							" WHERE F.FOB LIKE '%'||?||'%' AND F.FTITLE LIKE '%'||?||'%'" + 
																								" AND F.FDATE BETWEEN ? AND ?" + 
																								" AND F.FLOCAL = ? AND NOT F.FSTCODE = 'FST02'" + 
																								" AND F.MID = M.MID AND F.FSTCODE = FC.FSTCODE ORDER BY FDATE) A))";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, fOb);
				pstmt.setString(2, fTitle);
				pstmt.setDate(3, fDate1);
				pstmt.setDate(4, fDate2);
				pstmt.setString(5, fLocal);
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
		
		// 내가 쓴글 수
		public int countMyFind(String mId) {
			int cnt = 0;
			
			Connection 				conn 	= null;
			PreparedStatement 		pstmt 	= null;
			ResultSet 				rs 		= null;
			
			String 					sql 	= "SELECT COUNT(*) CNT FROM FIND WHERE MID = ?";
			
			try {
				
				conn 	= 	ds.getConnection();
				pstmt 	= 	conn.prepareStatement(sql);
				pstmt.setString(1, mId);
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
}
