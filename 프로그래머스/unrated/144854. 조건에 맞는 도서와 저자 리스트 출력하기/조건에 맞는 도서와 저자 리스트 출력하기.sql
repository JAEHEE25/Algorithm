-- 코드를 입력하세요
SELECT book_id, author_name, DATE_FORMAT(published_date, '20%y-%m-%d')
FROM BOOK NATURAL JOIN AUTHOR
WHERE category = '경제'
ORDER BY published_date