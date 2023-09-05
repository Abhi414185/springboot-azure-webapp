GO
CREATE FUNCTION sales.D_NewFunction(@SalesOrderId int,@CurrencyCode nvarchar(3),@Date datetime)
RETURNS TABLE
AS
RETURN
	select sod.ProductID as 'Product ID',
		   sod.OrderQty as 'Order Quantity',
		   sod.UnitPrice as 'Unit Price',
		   sod.UnitPrice*scr.EndOfDayRate as 'Target Price'

	from Sales.SalesOrderDetail as sod,
			Sales.CurrencyRate as scr
	where scr.ToCurrencyCode=@CurrencyCode and
		  scr.ModifiedDate=@Date and
		  sod.SalesOrderID=@SalesOrderId
GO
select * from Sales.B_NewFunction(43709,'EUR','2006-09-05')