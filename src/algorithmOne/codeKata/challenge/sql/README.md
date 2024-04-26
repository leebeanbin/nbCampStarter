# SQL WRAP-UP NOTE

---


## BASIC SEARCH
```sql
-- 코드를 입력하세요
SELECT Field_Name, Field_Name
FROM Table
```

## BASIC CONDITION
```sql
-- 코드를 입력하세요
SELECT col1, col2
FROM table
WHERE conditions
ORDER BY field

-- SELECT ANIMAL_ID, NAME
-- FROM ANIMAL_INS
-- WHERE INTAKE_CONDITION = 'Sick'
-- ORDER BY ANIMAL_ID
```
- Basic Multi Criteria for the Search
```sql
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME , DATETIME DESC
```
- Including condition
```sql
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' && NAME LIKE '%el%'
ORDER BY NAME
```

## COUNTING
```sql
-- 코드를 입력하세요
SELECT Field,COUNT(Field) as NICKNAME
FROM TABLE
GROUP BY Field HAVING NICKNAME > 1

-- SELECT NAME,COUNT(NAME) as CNT
-- FROM ANIMAL_INS
-- GROUP BY NAME HAVING CNT > 1
```

## SUB SELECTING
```sql
-- 코드를 입력하세요
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (
    SELECT MIN(DATETIME)
    FROM ANIMAL_INS
)

-- https://syoung-journey.tistory.com/59
```