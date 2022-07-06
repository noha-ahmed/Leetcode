# Write your MySQL query statement below
SELECT name AS customers
FROM customers
WHERE id NOT IN 
( 
    SELECT customerId                
    FROM orders
);