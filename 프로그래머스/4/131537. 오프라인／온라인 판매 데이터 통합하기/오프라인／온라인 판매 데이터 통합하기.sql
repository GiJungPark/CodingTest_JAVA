-- 코드를 입력하세요
# OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 로 표시해주세요.
SELECT
    DATE_FORMAT(sales_date, '%Y-%m-%d') AS SALES_DATE,
    product_id AS PRODUCT_ID,
    user_id AS USER_ID,
    sales_amount AS SALES_AMOUNT
FROM
    online_sale
WHERE
    sales_date LIKE '2022-03%'
    
UNION ALL

SELECT
    DATE_FORMAT(sales_date, '%Y-%m-%d') AS SALES_DATE,
    product_id AS PRODUCT_ID,
    NULL AS USER_ID,
    sales_amount AS SALES_AMOUNT
FROM
    offline_sale
WHERE
    sales_date LIKE '2022-03%'
    
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC
;