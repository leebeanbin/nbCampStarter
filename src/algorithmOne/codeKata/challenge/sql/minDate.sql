-- 코드를 입력하세요
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (
    SELECT MIN(DATETIME)
    FROM ANIMAL_INS
)

-- https://syoung-journey.tistory.com/59