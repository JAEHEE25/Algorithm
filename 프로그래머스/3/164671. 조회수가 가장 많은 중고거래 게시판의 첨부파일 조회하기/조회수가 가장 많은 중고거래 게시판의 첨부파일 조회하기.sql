SELECT CONCAT("/home/grep/src/", board_id, "/", file_id, file_name, file_ext) AS url
FROM used_goods_board JOIN used_goods_file USING(board_id)
WHERE views = (SELECT MAX(VIEWS) FROM used_goods_board)
ORDER BY file_id DESC