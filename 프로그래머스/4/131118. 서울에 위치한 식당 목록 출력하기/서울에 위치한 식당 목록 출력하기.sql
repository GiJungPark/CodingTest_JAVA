-- 코드를 입력하세요
SELECT
    i.REST_ID,
    i.REST_NAME,
    i.FOOD_TYPE,
    i.FAVORITES,
    i.ADDRESS,
    ROUND(AVG(r.REVIEW_SCORE), 2) AS SCORE
FROM 
    rest_info i
    INNER JOIN rest_review r
    ON i.rest_id = r.rest_id
WHERE
    i.address LIKE ('서울%')
GROUP BY
    i.REST_ID
ORDER BY
    SCORE DESC,
    i.FAVORITES DESC
;