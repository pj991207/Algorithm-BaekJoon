SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS AS A JOIN ANIMAL_OUTS AS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE !=  B.SEX_UPON_OUTCOME AND A.SEX_UPON_INTAKE LIKE ('%Intact%')
ORDER BY A.ANIMAL_ID;