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



SELECT * FROM Books WHERE (id IN (SELECT book_id FROM BorrowingTransactions WHERE user_id = ?)) AND status = 'borrowed';

