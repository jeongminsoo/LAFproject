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

import com.laf.dto.QnaDto;

public class QnaDao {

	public static final int FAIL 	= 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	private static QnaDao instance = new QnaDao();
	
	public static QnaDao getInstance() {
		return instance;
	}
	
	private QnaDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Q&A 작성
	public int writeQna(QnaDto dto) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "INSERT INTO QNA (QNO, QTITLE, QCONTENT, MID, QFILENAME, QGROUP, QSTEP, QINDENT, QIP)" + 
										" VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?, ?, QNA_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getqTitle());
			pstmt.setString(2, dto.getqContent());
			pstmt.setString(3, dto.getmId());
			pstmt.setString(4, dto.getqFilename());
			pstmt.setString(5, dto.getqIp());
			
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
	
	// Q&A 수정
	public int updateQna(QnaDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE QNA SET QTITLE = ?, QCONTENT = ?, QFILENAME = ? WHERE QNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, dto.getqTitle());
			pstmt.setString(2, dto.getqContent());
			pstmt.setString(3, dto.getqFilename());
			pstmt.setInt(4, dto.getqNo());

			
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
	
	// Q&A 목록
	public ArrayList<QnaDto> qnaList(int start, int end) {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		
		Connection 				conn 	= null;
		PreparedStatement 		pstmt 	= null;
		ResultSet 				rs 		= null;
		
		String 					sql 	= "SELECT *" + 
											" FROM (SELECT ROWNUM RN, A.*" + 
													" FROM (SELECT Q.*, MNAME FROM QNA Q, LAF_MEMBER M WHERE Q.MID = M.MID ORDER BY QGROUP DESC, QSTEP) A)" + 
											" WHERE RN BETWEEN ? AND ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int 	qNo			=	rs.getInt("qno");
				String 	qTitle		=	rs.getString("qtitle");
				String 	qContent	=	rs.getString("qcontent");
				String 	mId			=	rs.getString("mid");
				Date 	qRdate		=	rs.getDate("qrdate");
				String 	qFilename	=	rs.getString("qfilename");
				int 	qHit		=	rs.getInt("qhit");
				int 	qGroup		=	rs.getInt("qgroup");
				int 	qStep		=	rs.getInt("qstep");
				int		qIndent		=	rs.getInt("qindent");
				String 	qIp			=	rs.getString("qip");
				String 	mName		=	rs.getString("mname");
			
				dtos.add(new QnaDto(qNo, qTitle, qContent, mId, qRdate, qFilename, qHit, qGroup, qStep, qIndent, qIp, mName));
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
	// Q&A 삭제
	public int deleteLost(int qNo) {
		int result = FAIL;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "DELETE FROM QNA WHERE QNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			
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
	
	// step A
	private void stepA(int qGroup, int qStep) {
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE QNA SET QSTEP = QSTEP + 1 WHERE QGROUP = ? AND QSTEP > ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, qGroup);
			pstmt.setInt(2, qStep);
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
	
	// QNA답변
	public int replyQna(String qTitle, String qContent, String mId, String qFilename, int qGroup, int qStep, int qIndent, String qIp) {
		int result = FAIL;
		
		stepA(qGroup, qStep);
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "INSERT INTO QNA (QNO, QTITLE, QCONTENT, MID, QFILENAME, QGROUP, QSTEP, QINDENT, QIP)" + 
										" VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setString(1, qTitle);
			pstmt.setString(2, qContent);
			pstmt.setString(3, mId);
			pstmt.setString(4, qFilename);
			pstmt.setInt(5, qGroup);
			pstmt.setInt(6, qStep);
			pstmt.setInt(7, qIndent);
			pstmt.setString(8, qIp);
			
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
	
	// Q&A 보기
	public QnaDto contentQna(int qNo) {
		QnaDto dto = null;
		qHitUp(qNo);
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet			rs		= null;
		
		String 				sql 	= "SELECT Q.*, MNAME FROM QNA Q, LAF_MEMBER M WHERE Q.MID = M.MID AND QNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String 	qTitle		=	rs.getString("qtitle");
				String 	qContent	=	rs.getString("qcontent");
				String 	mId			=	rs.getString("mid");
				Date 	qRdate		=	rs.getDate("qrdate");
				String 	qFilename	=	rs.getString("qfilename");
				int 	qHit		=	rs.getInt("qhit");
				int 	qGroup		=	rs.getInt("qgroup");
				int 	qStep		=	rs.getInt("qstep");
				int		qIndent		=	rs.getInt("qindent");
				String 	qIp			=	rs.getString("qip");
				String 	mName		=	rs.getString("mname");
				
				dto = new QnaDto(qNo, qTitle, qContent, mId, qRdate, qFilename, qHit, qGroup, qStep, qIndent, qIp, mName);
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
	private void qHitUp(int qNo) {
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		
		String 				sql 	= "UPDATE QNA SET QHIT = QHIT + 1 WHERE QNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
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
	public QnaDto getQna(int qNo) {
		QnaDto dto = null;
		
		Connection 			conn 	= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet			rs		= null;
		
		String 				sql 	= "SELECT Q.*, MNAME FROM QNA Q, LAF_MEMBER M WHERE Q.MID = M.MID AND QNO = ?";
		
		try {
			
			conn 	= 	ds.getConnection();
			pstmt 	= 	conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String 	qTitle		=	rs.getString("qtitle");
				String 	qContent	=	rs.getString("qcontent");
				String 	mId			=	rs.getString("mid");
				Date 	qRdate		=	rs.getDate("qrdate");
				String 	qFilename	=	rs.getString("qfilename");
				int 	qHit		=	rs.getInt("qhit");
				int 	qGroup		=	rs.getInt("qgroup");
				int 	qStep		=	rs.getInt("qstep");
				int		qIndent		=	rs.getInt("qindent");
				String 	qIp			=	rs.getString("qip");
				String 	mName		=	rs.getString("mname");
				
				dto = new QnaDto(qNo, qTitle, qContent, mId, qRdate, qFilename, qHit, qGroup, qStep, qIndent, qIp, mName);
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
}
