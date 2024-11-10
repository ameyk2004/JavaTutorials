DELIMITER //

CREATE TRIGGER afterInsertInBorrowingTransactions
AFTER INSERT ON BorrowingTransactions
FOR EACH ROW
BEGIN
    DECLARE available_qty INT;

    SELECT available_quantity INTO available_qty
    FROM Books
    WHERE id = NEW.book_id;

    IF available_qty > 0 THEN
        UPDATE Books 
        SET available_quantity = available_quantity - 1
        WHERE id = NEW.book_id;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Not enough available copies of the book to borrow.';
    END IF;

END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER afterInBorrowingTransactions
AFTER UPDATE ON BorrowingTransactions
FOR EACH ROW
BEGIN
    DECLARE available_qty INT;

    IF NEW.status == "returned"

        SELECT available_quantity INTO available_qty, 
        FROM Books
        WHERE id = NEW.book_id;

        UPDATE Books SET available_qty = available_qty + 1
        WHERE id = NEW.book_id;

    END IF;

END //

DELIMITER ;
