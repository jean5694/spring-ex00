CREATE DATABASE spr1;
USE spr1;

-- 173 page
CREATE TABLE tbl_board (
	bno INT PRIMARY KEY AUTO_INCREMENT, -- 자동으로 증가
    title VARCHAR(255) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    writer VARCHAR(50) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    updatedate TIMESTAMP DEFAULT NOW()
);

 -- 내용 입력
INSERT INTO tbl_board (title, content, writer)
VALUES ('test title', 'test content', '






user00');

-- 조회
SELECT * FROM tbl_board; 


-- 연습
CREATE TABLE tbl_test1 (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

INSERT INTO tbl_test1 (name, age) VALUES ('Chacha', 24);
INSERT INTO tbl_test1 (name, age) VALUES ('Nana', 20);
INSERT INTO tbl_test1 (name, age) VALUES ('Ann', 26);

SELECT * FROM tbl_test1;

-- org.zerock.domain.Test1VO (bean)
-- org.zerock.mapper.Test1Mapper (interface)
-- org.zerock.mapper.Test1Mapper.xml (xml)
-- Test1Tests