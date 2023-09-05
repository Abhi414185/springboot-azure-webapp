
CREATE OR ALTER TRIGGER [Production].UpdateTrigger
ON Production.Product
INSTEAD OF UPDATE
AS
SET NOCOUNT ON
BEGIN
	IF UPDATE(ListPrice)
	DECLARE @OldListPrice money
	DECLARE @InsteadListPrice money
	DECLARE @ID int
	SELECT @OldListPrice=p.ListPrice,
		   @InsteadListPrice=inserted.ListPrice,
		   @ID=inserted.ProductID
	FROM Production.Product p,inserted
	WHERE p.ProductID=inserted.ProductID;

	IF(@InsteadListPrice >(@OldListPrice +(0.15*@OldListPrice)))
	BEGIN
		RAISERROR('PRICE MORE THAN 15 PERCENT,TRANSACTION Error',16,0)
		ROLLBACK TRANSACTION
	END
	ELSE
	BEGIN
		Update Production.Product SET ListPrice=@InsteadListPrice
		Where Production.Product.ProductID=@ID;
	END
END;

SELECT Production.Product.ProductID,
	   Production.Product.ListPrice
FROM PRODUCTION.Product;

UPDATE PRODUCTION.Product
SET ListPrice=8
Where Product.ProductID=4;

