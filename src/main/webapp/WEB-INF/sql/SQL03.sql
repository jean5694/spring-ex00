USE spr1;
-- 전체 게시물
SELECT * FROM tbl_board
ORDER BY bno DESC;

-- 제목 검색
SELECT * FROM tbl_board
WHERE title LIKE '%자바%' -- '자바'라는 키워드를 찾고 싶을 때
ORDER BY bno DESC
LIMIT 0, 10; -- 페이징 처리

-- 제목 본문 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%자바%'
OR content LIKE '%자바%' -- 본문에도 이어지는 경우 
ORDER BY bno DESC;

-- 제목 본문 작성자 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%자바%'
OR content LIKE '%자바%'
OR writer LIKE '%자바%'
ORDER BY bno DESC
LIMIT 0, 10;

-- CONCAT 함수
SELECT CONCAT('a', 'b');
SELECT CONCAT('a', 'java', 'b');
SELECT 'a' + 'java';
SELECT 'a' || 'java'; -- oracle








