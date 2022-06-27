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
		
		String sql = "INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAIL, MADDRESS, MTEL, MBIRTH, MQUIZ, MANSWER)" + 
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmAddress());
			pstmt.setString(6, dto.getmTel());
			pstmt.setDate(7, dto.getmBirth());
			pstmt.setString(8, dto.getmQuiz());
			pstmt.setString(9, dto.getmAnswer());
			
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
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MID = ?";
		
		try {
			
			conn 	= ds.getConnection();
			pstmt 	= conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs 		= pstmt.executeQuery();
			
			if (rs.next()) {
				String 	mPw 		= rs.getString("mpw");
				String 	mName 		= rs.getString("mname");
				String 	mEmail 		= rs.getString("memail");
				String 	mAddress 	= rs.getString("maddress");
				String 	mTel 		= rs.getString("mtel");
				Date 	mBirth 		= rs.getDate("mbirth");
				String 	mQuiz 		= rs.getString("mquiz");
				String 	mAnswer 	= rs.getString("manswer");
				Date 	mRdate 		= rs.getDate("mrdate");
				String 	pcCode 		= rs.getString("pccode");
				int 	scCode 		= rs.getInt("sccode");
				
				dto = new MemberDto(mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mQuiz, mAnswer, mRdate, pcCode, scCode);
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
	public String findmId(String mName, String mEmail) {
		String 				mId 	= null;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 			rs 		= null;
		
		String 				sql 	= "SELECT * FROM LAF_MEMBER WHERE MNAME = ? AND MEMAIL = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mEmail);
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
	public int findmPw(String mId, String mName) {
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
		
		String sql = "UPDATE LAF_MEMBER SET MNAME = ?, MEMAIL = ?, MBIRTH = ?," + 
						" MADDRESS = ?, MQUIZ = ?, MANSWER = ? WHERE MID = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmName());
			pstmt.setString(2, dto.getmEmail());
			pstmt.setDate(3, dto.getmBirth());
			pstmt.setString(4, dto.getmAddress());
			pstmt.setString(5, dto.getmQuiz());
			pstmt.setString(6, dto.getmAnswer());
			pstmt.setString(7, dto.getmId());
			
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
		
		String 				sql 	= "UPDATE LAF_MEMBER SET SCCODE = 0 WHERE MID = ? AND MPW = ?";
		
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
		
		String 					sql 	= "SELECT M.*, CODENAME, STATUSNAME FROM LAF_MEMBER M, POWER_CODE PC, STATUS_CODE SC" + 
											" WHERE M.PCCODE = PC.PCCODE AND M.SCCODE = SC.SCCODE AND PC.PCCODE = 'LAF001' ORDER BY MRDATE DESC, MID";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String 	mId 		= rs.getString("mid");
				String 	mPw 		= rs.getString("mpw");
				String 	mName 		= rs.getString("mname");
				String 	mEmail 		= rs.getString("memail");
				String 	mAddress 	= rs.getString("maddress");
				String 	mTel 		= rs.getString("mtel");
				Date 	mBirth 		= rs.getDate("mbirth");
				String 	mQuiz 		= rs.getString("mquiz");
				String 	mAnswer 	= rs.getString("manswer");
				Date 	mRdate 		= rs.getDate("mrdate");
				String 	pcCode 		= rs.getString("pccode");
				int 	scCode		= rs.getInt("sccode");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mQuiz, mAnswer, mRdate, pcCode, scCode));
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
		
		String 				sql 	= "SELECT M.*, CODENAME, STATUSNAME FROM LAF_MEMBER M, POWER_CODE PC, STATUS_CODE SC" + 
										" WHERE M.PCCODE = PC.PCCODE AND M.SCCODE = SC.SCCODE AND PC.PCCODE = 'LAF000' ORDER BY MRDATE DESC, MID";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			rs 		= 	pstmt.executeQuery();
			
			while (rs.next()) {
				String 	mId 		= rs.getString("mid");
				String 	mPw 		= rs.getString("mpw");
				String 	mName 		= rs.getString("mname");
				String	mEmail 		= rs.getString("memail");
				String	mAddress 	= rs.getString("maddress");
				String 	mTel 		= rs.getString("mtel");
				Date 	mBirth 		= rs.getDate("mbirth");
				String 	mQuiz 		= rs.getString("mquiz");
				String 	mAnswer 	= rs.getString("manswer");
				Date 	mRdate 		= rs.getDate("mrdate");
				String 	pcCode 		= rs.getString("pccode");
				int 	scCode		= rs.getInt("sccode");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mQuiz, mAnswer, mRdate, pcCode, scCode));
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
		
		String 				sql		 = "INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAIL, MADDRESS, MTEL, MBIRTH, MQUIZ, MANSWER, PCCODE)" + 
											" VALUES (?, ?, ?, ?, '서울특별시', ?, ?, '관리자입니다', '관리자입니다','LAF000')";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmTel());
			pstmt.setDate(6, dto.getmBirth());
			
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
}
