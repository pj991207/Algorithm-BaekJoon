SELECT A.YEAR AS YEAR, A.MONTH AS MONTH, COUNT(*) AS PUCHASED_USERS, ROUND((COUNT(*)/B.NUM),1) AS PUCHASED_RATIO
FROM
(SELECT YEAR(A.SALES_DATE) AS YEAR, MONTH(A.SALES_DATE) AS MONTH, A.USER_ID FROM
(SELECT A.ONLINE_SALE_ID AS ONLINE_SALE_ID, A.USER_ID AS USER_ID, A.PRODUCT_ID AS PRODUCT_ID, A.SALES_AMOUNT AS SALES_AMOUNT, A.SALES_DATE AS SALES_DATE
FROM ONLINE_SALE AS A, USER_INFO AS B WHERE A.USER_ID = B.USER_ID AND YEAR(B.JOINED) = "2021") AS A
GROUP BY YEAR,MONTH,USER_ID) AS A,
(SELECT COUNT(*) AS NUM FROM USER_INFO WHERE YEAR(JOINED)="2021") AS B
GROUP BY A.YEAR, A.MONTH
ORDER BY YEAR, MONTH
