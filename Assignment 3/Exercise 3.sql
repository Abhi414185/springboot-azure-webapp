select top 5 s.AccountNumber,s.OrderDate 
from (select so.*,TotalPerAccount = sum(ss.LineTotal) over (PARTITION BY so.AccountNumber),
	  rn=ROW_NUMBER() over(PARTITION BY so.AccountNumber ORDER BY so.OrderDate DESC)
	  from Sales.SalesOrderHeader so
	  join Sales.SalesOrderDetail ss on so.SalesOrderID=ss.SalesOrderID
	  )s
where s.TotalPerAccount>70000
		