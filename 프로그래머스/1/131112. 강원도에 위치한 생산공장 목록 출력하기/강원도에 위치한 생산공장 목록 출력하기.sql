-- 코드를 입력하세요
SELECT
    f.FACTORY_ID,
    f.FACTORY_NAME,
    f.ADDRESS
FROM 
    food_factory f
WHERE
    f.address LIKE "강원도%"
ORDER BY
    f.factory_id ASC
;