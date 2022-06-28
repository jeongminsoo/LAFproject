-- 회원가입
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa01', 'a123456789!', '홍길동', 'hong', 'naver.com', '서울특별시', '010', '3333', '3333', '1999-01-01', '으', '악');

-- 관리자 추가
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER, PWCODE)
    VALUES ('admin01', 'a123456789!', '관리자', 'admin', 'naver.com', '서울특별시',
                '010', '1234', '5678', SYSDATE, '관리자입니다', '관리자입니다','PW01');

-- 로그인 체크
SELECT * FROM LAF_MEMBER WHERE MID = 'aaa01' AND MPW = 'a123456789!';

-- 아이디 중복 확인
SELECT * FROM LAF_MEMBER WHERE MID = 'aaa01';

-- 아이디 찾기
SELECT * FROM LAF_MEMBER WHERE MNAME = '홍길동' AND MEMAIL = 'hong@naver.com';

-- 비밀번호 찾기
SELECT * FROM LAF_MEMBER WHERE MID = 'aaa01' AND MNAME = '홍길동';

-- 퀴즈 답변 체크
SELECT * FROM LAF_MEMBER WHERE MANSWER = '악';

-- 사용자 정보보기
SELECT * FROM LAF_MEMBER WHERE MID = 'aaa01';

-- 비밀번호 변경
UPDATE LAF_MEMBER SET MPW = 'b123456789!' WHERE MID = 'aaa01';

-- 회원정보 수정
UPDATE LAF_MEMBER SET MNAME = '김길동', MEMAILID = 'kim', MEMAILDOMAIN = 'daum.net', MBIRTH = '1988-08-08',
    MADDRESS = '경기도', MTEL1 = '011', MTEL2 = '123', MTEL3 = '4567', MQUIZ = '어', MANSWER = '라' WHERE MID = 'aaa01';

-- 회원탈퇴
UPDATE LAF_MEMBER SET MSTCODE = 'MST10' WHERE MID = 'aaa05' AND MPW = 'a123456789!';

-- 사용자 리스트
SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC
    WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE AND M.PWCODE = 'PW00' ORDER BY M.MSTCODE, MRDATE DESC, MID;

-- 관리자 리스트
SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC
    WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE AND M.PWCODE = 'PW01' ORDER BY M.MSTCODE, MRDATE DESC, MID;

-- dto가져오기
SELECT M.*, PC.CODENAME PCC, MC.CODENAME MCC FROM LAF_MEMBER M, PW_CODE PC, MST_CODE MC
    WHERE M.PWCODE = PC.PWCODE AND M.MSTCODE = MC.MSTCODE AND MID = 'aaa01';

-- 분실물 게시글 등록
INSERT INTO LOST (LNO, LTITLE, LCONTENT, MID, LOB, LLOCAL, LLOCATION, LDATE, LPHOTO, LTEL, LIP)
    VALUES (LOST_SEQ.NEXTVAL, '갤럭시 노트10 휴대폰 찾습니다', '습득하신분은 연락주세요', 'aaa01', '휴대폰', '서울특별시 강남구',
                '강남역 맥도날드', '2022-06-26', null, '010-1111-1111', '127.0.0.1');

INSERT INTO LOST (LNO, LTITLE, LCONTENT, MID, LOB, LLOCAL, LLOCATION, LDATE, LPHOTO, LTEL, LIP)
    VALUES ('L'||TRIM(TO_CHAR(SYSDATE,'YYYYMMDD'))||TRIM(TO_CHAR(LOST_SEQ.NEXTVAL, '000000')), '갤럭시 노트10 휴대폰 찾습니다', '습득하신분은 연락주세요', 'aaa01', '휴대폰', '서울특별시 강남구',
                '강남역 맥도날드', '2022-06-26', null, '010-1111-1111', '127.0.0.1');

-- 분실물 게시글 수정
UPDATE LOST SET LTITLE = '아이폰 11 찾습니다', LCONTENT = '습득하신분 연락 꼭 주세요', LLOCAL = '서울특별시 서초구', LLOCATION = '서초역 1번출구',
    LDATE = '2022-06-25', LPHOTO = 'NOIMG.JPG', LTEL = '010-2222-3333', LIP = '127.0.0.2' WHERE LNO = 'L20220627000001';


-- 분실물 목록
SELECT *
    FROM (SELECT ROWNUM RN,  A.*
            FROM (SELECT L.*, MNAME, CODENAME LCC FROM LOST L, LAF_MEMBER M, LST_CODE LC
                    WHERE L.MID = M.MID AND L.LSTCODE = LC.LSTCODE AND L.LSTCODE = 'LST00' ORDER BY LRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 10;

-- 여기까지 함

-- 분실물 게시글 삭제
DELETE FROM LOST WHERE LNO = 1 AND MID = 'aaa01';

-- 분실물 관리
SELECT * FROM LOST WHERE MID = 'aaa01' ORDER BY LRDATE DESC;
SELECT *
    FROM (SELECT ROWNUM RN,  A.*
            FROM (SELECT L.*, CODENAME LCC FROM LOST L, LST_CODE LC
                    WHERE L.LSTCODE = LC.LSTCODE AND MID = 'aaa01' ORDER BY L.LSTCODE, LRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 10;

-- 분실물 접수취소
UPDATE LOST SET LSTCODE = 'LST02' WHERE LNO = 'L20220628000005';

-- 분실물 처리완료
UPDATE LOST SET LSTCODE = 'LST01' WHERE LNO = 'L20220628000006';

-- 습득물 게시글 등록
INSERT INTO FIND (FNO, FTITLE, FCONTENT, MID, FOB, FLOCAL, FLOCATION, FDATE, FSTORAGE, FPHOTO, FTEL, FIP)
    VALUES ('F'||TRIM(TO_CHAR(SYSDATE,'YYYYMMDD'))||TRIM(TO_CHAR(FIND_SEQ.NEXTVAL, '000000')), '구찌 지갑', '현금은 없으며 카드지갑입니다', 'aaa01', '지갑', '경기도 안양시',
                '평촌 이마트', '2022-06-27', '평촌 이마트 고객센터', NULL, '031-123-1234', '127.0.0.1');
    
-- 습득물 목록
SELECT *
    FROM (SELECT ROWNUM RN,  A.*
            FROM (SELECT F.*, MNAME, CODENAME FCC FROM FIND F, LAF_MEMBER M, FST_CODE FC
                    WHERE F.MID = M.MID AND F.FSTCODE = FC.FSTCODE AND F.FSTCODE = 'FST00' ORDER BY F.FSTCODE DESC, FRDATE DESC) A)
            WHERE RN BETWEEN 1 AND 3;


-- 습득물 게시글 수정
UPDATE FIND SET FTITLE = '루이비통 지갑', FCONTENT = '장지갑이고 신한카드, 현금 1만원 등 있습니다', FLOCAL = '경기도 안양시', FLOCATION = '평촌 이마트',
    FSTORAGE = '이마트 분실물센터', FDATE = '2022-06-25', FPHOTO = 'NOIMG.JPG', FTEL = '031-123-1111', FIP = '127.0.0.2' WHERE FNO = 'F20220627000003';

-- 습득물 게시글 삭제
DELETE FROM FIND WHERE FNO = 'F20220627000002' AND MID = 'aaa01';

-- 습득물 관리
SELECT * FROM FIND WHERE MID = 'aaa01' ORDER BY FRDATE DESC;
SELECT *
    FROM (SELECT ROWNUM RN,  A.*
            FROM (SELECT F.*, CODENAME FCC FROM FIND F, FST_CODE FC
                    WHERE F.FSTCODE = FC.FSTCODE AND MID = 'aaa01' ORDER BY F.FSTCODE, FRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 10;

-- 습득물 보기 / dto 가져오기
SELECT F.*, MNAME FROM FIND F, LAF_MEMBER M WHERE F.MID = M.MID AND FNO = 'F20220628000001';

-- QNA 게시글 등록
INSERT INTO QNA (QNO, QTITLE, QCONTENT, MID, QFILENAME, QGROUP, QSTEP, QINDENT, QIP)
    VALUES (QNA_SEQ.NEXTVAL, '문의드립니다', '답변부탁드립니다', 'aaa01', NULL, QNA_SEQ.CURRVAL, 0, 0, '127.0.0.1');

-- QNA 게시글 수정
UPDATE QNA SET QTITLE = '수정)문의드립니다', QCONTENT = '다시 문의드리며 답변부탁드립니다', QFILENAME = 'NOIMG.JPG' WHERE QNO = '1';

UPDATE QNA SET QSTEP = 1, QINDENT = 1 WHERE QNO = 2;

-- QNA 리스트
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT Q.*, MNAME FROM QNA Q, LAF_MEMBER M WHERE Q.MID = M.MID ORDER BY QGROUP DESC, QSTEP) A)
    WHERE RN BETWEEN 1 AND 5;

-- QNA 게시글 삭제
DELETE FROM QNA WHERE QNO = 7;

-- QNA 게시글 답변 등록
INSERT INTO QNA (QNO, QTITLE, QCONTENT, MID, QFILENAME, QGROUP, QSTEP, QINDENT, QIP)
    VALUES (QNA_SEQ.NEXTVAL, '답변드립니다', '아시겠죠?', 'admin01', NULL, 8, 1, 1, '127.0.0.1');

-- 답변글 전 STEP A
UPDATE QNA SET QSTEP = QSTEP + 1 WHERE QGROUP = 2 AND QSTEP > 0;

-- QNA 글보기 / dto가져오기
SELECT Q.*, MNAME FROM QNA Q, LAF_MEMBER M WHERE Q.MID = M.MID AND QNO = 9;

-- 공지사항 등록
INSERT INTO NOTICE (NNO, NTITLE, NCONTENT, NFILENAME) VALUES (NOTICE_SEQ.NEXTVAL, '공지사항입니다', '아시겠죠?', NULL);

-- 공지사항 수정
UPDATE NOTICE SET NTITLE = '수정된 공지사항', NCONTENT = '수정된내용 알겠죠?', NFILENAME = 'NOIMG.JPG'
    WHERE NNO = 1;

-- 공지사항 삭제
DELETE FROM NOTICE WHERE NNO = 1;

-- 공지사항 목록
SELECT * FROM NOTICE ORDER BY NDATE DESC;


-- 조회수 올리기
UPDATE LOST SET LHIT = LHIT + 1 WHERE LNO = 1;
UPDATE FIND SET FHIT = FHIT + 1 WHERE FNO = 1;
UPDATE QNA SET QHIT = QHIT + 1 WHERE QNO = 2;
UPDATE NOTICE SET NHIT = NHIT + 1 WHERE NNO = 1;




ROLLBACK;
COMMIT;
