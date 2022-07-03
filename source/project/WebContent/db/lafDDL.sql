
DROP TABLE LOST;
DROP SEQUENCE LOST_SEQ;
DROP TABLE LST_CODE;

DROP TABLE FIND;
DROP SEQUENCE FIND_SEQ;
DROP TABLE FST_CODE;

DROP TABLE QNA;
DROP SEQUENCE QNA_SEQ;

DROP TABLE LAF_MEMBER;
DROP TABLE PW_CODE;
DROP TABLE MST_CODE;

DROP TABLE NOTICE;
DROP SEQUENCE NOTICE_SEQ;

-- PW CODE
CREATE TABLE PW_CODE(
    PWCODE     VARCHAR2(10)    PRIMARY KEY,
    CODENAME   VARCHAR2(20)    NOT NULL
);

INSERT INTO PW_CODE VALUES ('PW00', '사용자');
INSERT INTO PW_CODE VALUES ('PW01', '관리자');

-- MST CODE
CREATE TABLE MST_CODE(
    MSTCODE     VARCHAR2(10)      PRIMARY KEY,
    CODENAME    VARCHAR2(20)      NOT NULL
);

INSERT INTO MST_CODE VALUES ('MST00', '사용중');
INSERT INTO MST_CODE VALUES ('MST10', '사용중단');


-- 회원/관리자 
CREATE TABLE LAF_MEMBER(
    MID         VARCHAR2(30)    PRIMARY KEY,
    MPW         VARCHAR2(30)    NOT NULL,
    MNAME       VARCHAR2(30)    NOT NULL,
    MEMAILID    VARCHAR2(30)    NOT NULL,
    MEMAILDOMAIN VARCHAR2(30)   NOT NULL,
    MADDRESS    VARCHAR2(200)   NOT NULL,
    MTEL1       VARCHAR2(3)     NOT NULL,
    MTEL2       VARCHAR2(4)     NOT NULL,
    MTEL3       VARCHAR2(4)     NOT NULL,
    MBIRTH      DATE            NOT NULL,
    MQUIZ       VARCHAR2(100)   NOT NULL,
    MANSWER     VARCHAR2(50)    NOT NULL,
    MRDATE      DATE            DEFAULT SYSDATE,
    PWCODE      VARCHAR2(10)    DEFAULT 'PW00'     REFERENCES PW_CODE (PWCODE),
    MSTCODE     VARCHAR2(10)    DEFAULT 'MST00'    REFERENCES MST_CODE (MSTCODE)
);

-- LST CODE
CREATE TABLE LST_CODE(
    LSTCODE     VARCHAR2(10)      PRIMARY KEY,
    CODENAME    VARCHAR2(20)      NOT NULL
);

INSERT INTO LST_CODE VALUES ('LST00', '접수');
INSERT INTO LST_CODE VALUES ('LST01', '처리완료');
INSERT INTO LST_CODE VALUES ('LST02', '접수취소');

-- 분실물 게시판
CREATE TABLE LOST(
    LNO         VARCHAR2(20)    PRIMARY KEY,
    LTITLE      VARCHAR2(90)    NOT NULL,
    LCONTENT    VARCHAR2(3000)  NOT NULL,
    MID         VARCHAR2(30)    REFERENCES LAF_MEMBER (MID),
    LRDATE      DATE            DEFAULT SYSDATE,
    LOB         VARCHAR2(30)    NOT NULL,
    LLOCAL      VARCHAR2(100)   NOT NULL,
    LLOCATION   VARCHAR2(100)   NOT NULL,
    LDATE       DATE            NOT NULL,
    LPHOTO      VARCHAR2(30),
    LHIT        NUMBER(6)       DEFAULT 0,
    LTEL        VARCHAR2(13)    NOT NULL,
    LIP         VARCHAR2(20)    NOT NULL,
    LSTCODE     VARCHAR2(10)    DEFAULT 'LST00' REFERENCES LST_CODE (LSTCODE)
);

CREATE SEQUENCE LOST_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

-- FST CODE
CREATE TABLE FST_CODE(
    FSTCODE     VARCHAR2(10)      PRIMARY KEY,
    CODENAME    VARCHAR2(20)      NOT NULL
);
INSERT INTO FST_CODE VALUES ('FST00', '보관중');
INSERT INTO FST_CODE VALUES ('FST01', '수령완료');
INSERT INTO FST_CODE VALUES ('FST02', '등록취소');


-- 습득물 게시판
CREATE TABLE FIND(
    FNO         VARCHAR2(20)       PRIMARY KEY,
    FTITLE      VARCHAR2(90)    NOT NULL,
    FCONTENT    VARCHAR2(3000)  NOT NULL,
    MID         VARCHAR2(30)    REFERENCES LAF_MEMBER (MID),
    FRDATE      DATE            DEFAULT SYSDATE,
    FOB         VARCHAR2(30)    NOT NULL,
    FLOCAL      VARCHAR2(100)   NOT NULL,
    FLOCATION   VARCHAR2(100)   NOT NULL,
    FDATE       DATE            NOT NULL,
    FSTORAGE    VARCHAR2(100)   NOT NULL,
    FPHOTO      VARCHAR2(30),
    FHIT        NUMBER(6)       DEFAULT 0,
    FTEL        VARCHAR2(13)    NOT NULL,
    FIP         VARCHAR2(20)    NOT NULL,
    FSTCODE     VARCHAR2(10)    DEFAULT 'FST00' REFERENCES FST_CODE (FSTCODE)
);

CREATE SEQUENCE FIND_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

-- QNA
CREATE TABLE QNA(
    QNO         NUMBER(6)       PRIMARY KEY,
    QTITLE      VARCHAR2(90)    NOT NULL,
    QCONTENT    VARCHAR2(3000)  NOT NULL,
    MID         VARCHAR2(30)    REFERENCES LAF_MEMBER (MID),
    QRDATE       DATE            DEFAULT SYSDATE,
    QHIT        NUMBER(6)       DEFAULT 0,
    QGROUP      NUMBER(6)       NOT NULL,
    QSTEP       NUMBER(6)       NOT NULL,
    QINDENT     NUMBER(6)       NOT NULL,
    QIP         VARCHAR2(20)    NOT NULL
);

CREATE SEQUENCE QNA_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
    
-- 공지사항 게시판
CREATE TABLE NOTICE(
    NNO         NUMBER(6)       PRIMARY KEY,
    NTITLE      VARCHAR2(90)    NOT NULL,
    NCONTENT    VARCHAR2(3000)  NOT NULL,
    NFILENAME   VARCHAR2(30),
    NHIT        NUMBER(6)       DEFAULT 0,
    NDATE       DATE            DEFAULT SYSDATE
);

CREATE SEQUENCE NOTICE_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

COMMIT;