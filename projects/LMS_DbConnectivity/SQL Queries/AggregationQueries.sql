-- SEE AVAILABLE BOOKS NOT ISSUED BY ME

SELECT * FROM Books 
WHERE available_quantity > 0
AND id NOT IN (SELECT book_id FROM BorrowingTransactions WHERE user_id = 2);


-- SEE BOOKS ISSUED BY ME

SELECT * FROM Books 
WHERE
id IN (SELECT book_id FROM BorrowingTransactions WHERE user_id = 2);

-- SEE Names of Users Books Issued By them and its number

SELECT 
u.name AS user_name,
b.title AS book_title,COUNT(bt.book_id) AS books_issued
FROM Users u
JOIN BorrowingTransactions bt ON u.id = bt.user_id
JOIN Books b ON bt.book_id = b.id
WHERE bt.status = 'borrowed'
GROUP BY u.name, b.title
ORDER BY u.name, b.title;


-- Borrowed Books

SELECT 
b.book_id AS b.author,
b.title AS book_title,COUNT(bt.book_id) AS books_issued
FROM Users u
JOIN BorrowingTransactions bt ON u.id = bt.user_id
JOIN Books b ON bt.book_id = b.id
WHERE bt.status = 'borrowed'
GROUP BY u.name, b.title
ORDER BY u.name, b.title;


-- 

SELECT * FROM Books
WHERE 
(id IN (SELECT book_id FROM BorrowingTransactions WHERE user_id = ?)) 
AND status = 'borrowed';

-- CHECK TOTAL FINE OF EACH USER 

SELECT u.name, SUM(bt.fine) AS total_fine
FROM BorrowingTransactions AS bt
JOIN Users AS u ON bt.user_id = u.id
GROUP BY u.name;




-- Fine for one user

SELECT u.name, SUM(bt.fine) as total_fine 
FROM BorrowingTransactions as bt
JOIN Users as u
ON u.id = bt.user_id
GROUP BY u.id
HAVING u.id = 3;

-- Fine Calculation Log

SELECT 
    b.title, 
    COALESCE(bt.fine, 0) as fine, 
    COALESCE(DATEDIFF(bt.return_date, bt.due_date), 0) as overdue_days
FROM BorrowingTransactions as bt
JOIN Users as u ON u.id = bt.user_id
JOIN Books as b ON bt.book_id = b.id
WHERE u.id = 3;



