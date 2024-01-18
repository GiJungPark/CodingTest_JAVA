-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(date_of_birth, '%Y-%m-%d') AS DATE_OF_BRITH
FROM MEMBER_PROFILE
WHERE 
    date_of_birth LIKE '%-03-%'
    AND tlno IS NOT NULL
    AND GENDER = 'W'
ORDER BY
    member_id;