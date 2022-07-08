-- MEMBER 추가
-- 사용자
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa01', '111', '홍길동', 'hong', 'naver.com', '서울특별시', '010', '1111', '1111', '1999-01-01', '으', '악');
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa02', '111', '김철수', 'kim', 'gmail.com', '경기도', '010', '2222', '2222', '1999-02-01', '졸업한 대학교 이름은?', '건국대학교');
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa03', '111', '신짱구', 'shin', 'hanmail.net', '인천광역시', '010', '3333', '3333', '2000-01-01', '아버지의 이름은?', '신영만');
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa04', '111', '조태호', 'joh', 'hotmail.com', '강원도', '010', '4444', '4444', '1993-01-01', '어이가', '없네');
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa05', '111', '수양대군', 'soo', 'naver.com', '충청북도', '010', '5555', '5555', '1970-01-01', '내가', '왕이될상인가');
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER)
    VALUES ('aaa06', '111', '윤도현', 'yun', 'nate.com', '충청남도', '010', '6666', '6666', '1980-01-01', '나는', '나비');
    
-- 관리자
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER, PWCODE)
    VALUES ('admin01', '111', '관리자', 'admin01', 'naver.com', '서울특별시',
                '010', '1234', '5678', SYSDATE, '관리자입니다', '관리자입니다','PW01');

-- 최고관리자
INSERT INTO LAF_MEMBER (MID, MPW, MNAME, MEMAILID, MEMAILDOMAIN, MADDRESS, MTEL1, MTEL2, MTEL3, MBIRTH, MQUIZ, MANSWER, PWCODE)
    VALUES ('admin02', '111', '최고관리자', 'admin02', 'naver.com', '서울특별시',
                '010', '1234', '5678', SYSDATE, '관리자입니다', '관리자입니다','PW10');
COMMIT;

-- 분실물 게시글 등록