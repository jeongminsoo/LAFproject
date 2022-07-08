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

import com.laf.dto.MemberDto;

public class MemberDao {

	public static final int FAIL 			= 	0;
	public static final int SUCCESS 		= 	1;
	public static final int ID_EXISTENT 	= 	0;
	public static final int ID_NONEXISTENT 	= 	1;
	
	private DataSource ds;
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 회원가입
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String sql = "INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)" + 
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmailId());
			pstmt.setString(5, dto.getmEmailDomain());
			pstmt.setString(6, dto.getmAddress());
			pstmt.setString(7, dto.getmTel1());
			pstmt.setString(8, dto.getmTel2());
			pstmt.setString(9, dto.getmTel3());
			pstmt.setDate(10, dto.getmBirth());
			pstmt.setString(11, dto.getmQuiz());
			pstmt.setString(12, dto.getmAnswer());
			
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
	
	// 아이디 중복체크
	public int idChk(String mId) {
		int result = ID_EXISTENT;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MID = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs 		= 	pstmt.executeQuery();
			
			if (rs.next()) {
				result = ID_EXISTENT;
			} else {
				result = ID_NONEXISTENT;
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
		return result;
	}
	
	// 로그인 체크
	public int loginChk(String mId, String mPw) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MID = ? AND MPW = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs 		= 	pstmt.executeQuery();
			
			if (rs.next()) {
				result = SUCCESS;
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
		return result;
	}
	
	// 회원정보 보기, dto 가져오기
	public MemberDto getMember(String mId) {
		MemberDto 			dto 	= null;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC" + 
										" WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE AND MID = ?";
		
		try {
			
			conn 	= ds.getConnection();
			pstmt 	= conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs 		= pstmt.executeQuery();
			
			if (rs.next()) {
				String 	mPw 			= rs.getString("mpw");
				String 	mName 			= rs.getString("mname");
				String 	mEmailId 		= rs.getString("memailid");
				String 	mEmailDomain 	= rs.getString("memaildomain");
				String 	mAddress 		= rs.getString("maddress");
				String 	mTel1 			= rs.getString("mtel1");
				String 	mTel2 			= rs.getString("mtel2");
				String 	mTel3 			= rs.getString("mtel3");
				Date 	mBirth 			= rs.getDate("mbirth");
				String 	mQuiz 			= rs.getString("mquiz");
				String 	mAnswer 		= rs.getString("manswer");
				Date 	mRdate 			= rs.getDate("mrdate");
				String 	pwCode 			= rs.getString("pwcode");
				String	pcc				= rs.getString("pcc");
				String 	mstCode 		= rs.getString("mstcode");
				String	mcc				= rs.getString("mcc");
				
				dto = new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, mRdate, pwCode, pcc, mstCode, mcc);
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
	
	//비밀번호 변경
	public int changemPw(String mId, String mPw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE LAF_MEMBER SET MPW = ? WHERE MID = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mPw);
			pstmt.setString(2, mId);
			
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
	
	// 아이디 찾기
	public String searchId(String mName, String mEmailId, String mEmailDomain) {
		String 				mId 	= null;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MNAME = ? AND MEMAILID = ? AND MEMAILDOMAIN = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			pstmt.setString(2, mEmailId);
			pstmt.setString(3, mEmailDomain);
			rs 		= 	pstmt.executeQuery();
			
			if (rs.next()) {
				mId = rs.getString("mid");
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
		return mId;
	}
	
	// 비밀번호 찾기
	public int searchPw(String mId, String mName) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM LAF_MEMBER WHERE MID = ? AND MNAME = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mName);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = SUCCESS;
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
		return result;
	}
	
	// 비밀번호 퀴즈 체크
	public int quizChk(String mAnswer) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MANSWER = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mAnswer);
			rs 		= 	pstmt.executeQuery();
			
			if (rs.next()) {
				result = SUCCESS;
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
		return result;
	}
	
	//정보수정
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE LAF_MEMBER SET MNAME = ?, MEMAILID = ?, MEMAILDOMAIN = ?, MBIRTH = ?," + 
						" MADDRESS = ?, MTEL1 = ?, MTEL2 = ?, MTEL3 = ?, MQUIZ = ?, MANSWER = ? WHERE MID = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmName());
			pstmt.setString(2, dto.getmEmailId());
			pstmt.setString(3, dto.getmEmailDomain());
			pstmt.setDate(4, dto.getmBirth());
			pstmt.setString(5, dto.getmAddress());
			pstmt.setString(6, dto.getmTel1());
			pstmt.setString(7, dto.getmTel2());
			pstmt.setString(8, dto.getmTel3());
			pstmt.setString(9, dto.getmQuiz());
			pstmt.setString(10, dto.getmAnswer());
			pstmt.setString(11, dto.getmId());
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
	
	// 회원탈퇴
	public int leaveMember(String mId, String mPw) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE LAF_MEMBER SET MSTCODE = 'MST10' WHERE MID = ? AND MPW = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
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
	
	// 사용자 목록
	public ArrayList<MemberDto> memberList() {
		ArrayList<MemberDto> 	dtos 	= new ArrayList<MemberDto>();
		
		Connection 				conn 	= null;
		PreparedStatement 		pstmt 	= null;
		ResultSet 				rs 		= null;
		
		String 					sql 	= "SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC" + 
											" WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE AND M.PWCODE = 'PW00' ORDER BY M.MSTCODE, MRDATE DESC, MID";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String 	mId 			= rs.getString("mid");
				String 	mPw 			= rs.getString("mpw");
				String 	mName 			= rs.getString("mname");
				String 	mEmailId 		= rs.getString("memailid");
				String 	mEmailDomain 	= rs.getString("memaildomain");
				String 	mAddress 		= rs.getString("maddress");
				String 	mTel1			= rs.getString("mtel1");
				String 	mTel2 			= rs.getString("mtel2");
				String 	mTel3 			= rs.getString("mtel3");
				Date 	mBirth 			= rs.getDate("mbirth");
				String 	mQuiz 			= rs.getString("mquiz");
				String 	mAnswer 		= rs.getString("manswer");
				Date 	mRdate 			= rs.getDate("mrdate");
				String 	pwCode 			= rs.getString("pwcode");
				String	pcc				= rs.getString("pcc");
				String 	mstCode			= rs.getString("mstcode");
				String  mcc				= rs.getString("mcc");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, mRdate, pwCode, pcc, mstCode, mcc));
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
	
	// 관리자 리스트
	public ArrayList<MemberDto> adminList() {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT A.*, PC.CODENAME PCC, MC.CODENAME MCC" +
										" FROM (SELECT * FROM LAF_MEMBER WHERE PWCODE = 'PW10' OR PWCODE = 'PW01') A, PW_CODE PC, MST_CODE MC" + 
										" WHERE A.PWCODE = PC.PWCODE AND A.MSTCODE = MC.MSTCODE ORDER BY A.MSTCODE, MRDATE DESC, MID";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			rs 		= 	pstmt.executeQuery();
			
			while (rs.next()) {
				String 	mId 		= rs.getString("mid");
				String 	mPw 		= rs.getString("mpw");
				String 	mName 		= rs.getString("mname");
				String 	mEmailId 		= rs.getString("memailid");
				String 	mEmailDomain 	= rs.getString("memaildomain");
				String 	mAddress 		= rs.getString("maddress");
				String 	mTel1			= rs.getString("mtel1");
				String 	mTel2 			= rs.getString("mtel2");
				String 	mTel3 			= rs.getString("mtel3");
				Date 	mBirth 		= rs.getDate("mbirth");
				String 	mQuiz 		= rs.getString("mquiz");
				String 	mAnswer 	= rs.getString("manswer");
				Date 	mRdate 		= rs.getDate("mrdate");
				String 	pwCode 		= rs.getString("pwcode");
				String	pcc			= rs.getString("pcc");
				String 	mstCode		= rs.getString("mstcode");
				String	mcc			= rs.getString("mcc");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, mRdate, pwCode, pcc, mstCode, mcc));
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
	
	// 관리자 추가
	public int addAdmin(MemberDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql		 = "INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER, PWCODE)" + 
										" VALUES (?, ?, ?, ?, ?, '서울특별시', ?, ?, ?, ?, '관리자입니다', '관리자입니다','PW01')";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmailId());
			pstmt.setString(5, dto.getmEmailDomain());
			pstmt.setString(6, dto.getmTel1());
			pstmt.setString(7, dto.getmTel2());
			pstmt.setString(8, dto.getmTel3());
			pstmt.setDate(9, dto.getmBirth());
			
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
	
	// 사용자 수
	public int countMember() {
		int cnt = 0;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT COUNT(*) CNT FROM LAF_MEMBER WHERE PWCODE = 'PW00'";
		
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
	public int countAdmin() {
		int cnt = 0;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT COUNT(*) CNT FROM LAF_MEMBER WHERE PWCODE = 'PW01'";
		
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
	
	// 회원 상세검색
	public ArrayList<MemberDto> memberDetailSearch(String mId, String mName, String mAddress, String mstCode, String pwCode, Date mRdate1, Date mRdate2) {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection 				conn 	= null;
		PreparedStatement 		pstmt 	= null;
		ResultSet 				rs 		= null;
		
		String 					sql 	= "SELECT * FROM (SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC" + 
															" WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE ORDER BY M.MSTCODE, MRDATE DESC, MID)" + 
											" WHERE MID LIKE '%'||?||'%' AND MNAME LIKE '%'||?||'%' AND MADDRESS LIKE '%'||?||'%'" + 
												" AND MSTCODE LIKE '%'||?||'%' AND PWCODE LIKE '%'||?||'%' AND MRDATE > ? AND MRDATE <= ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mName);
			pstmt.setString(3, mAddress);
			pstmt.setString(4, mstCode);
			pstmt.setString(5, pwCode);
			pstmt.setDate(6, mRdate1);
			pstmt.setDate(7, mRdate2);
			rs 		= 	pstmt.executeQuery();
			
			while (rs.next()) {
				mId						=	rs.getString("mid");
				String	mPw				=	rs.getString("mpw");
				mName					=	rs.getString("mname");
				String 	mEmailId		=	rs.getString("memailId");
				String  mEmailDomain	=	rs.getString("memaildomain");
				mAddress				=	rs.getString("maddress");
				String 	mTel1			=	rs.getString("mtel1");
				String 	mTel2			=	rs.getString("mtel2");
				String 	mTel3			=	rs.getString("mtel3");
				Date 	mBirth			=	rs.getDate("mbirth");
				Date 	mRdate			=	rs.getDate("mrdate");
				String	mQuiz			=	rs.getString("mquiz");
				String	mAnswer			=	rs.getString("manswer");
				pwCode					=	rs.getString("pwcode");
				String  pcc				=	rs.getString("pcc");
				mstCode					=	rs.getString("mstcode");
				String	mcc				=	rs.getString("mcc");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, mRdate, pwCode, pcc, mstCode, mcc));
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
	
	// 권한변경
	public int powerChange(String mId, String pwCode) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE LAF_MEMBER SET PWCODE = ? WHERE MID = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, pwCode);
			pstmt.setString(2, mId);
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
	
	// 사용중단 처리
	public int stopMember(String mId, String mstCode) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE LAF_MEMBER SET MSTCODE = ? WHERE MID = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mstCode);
			pstmt.setString(2, mId);
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
}
