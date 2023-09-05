
with s as(select * from sales.SalesOrderHeader)
select * from  sales.Customer c
left outer join s on c.CustomerID = s.CustomerID
where s.SalesOrderID is NULL;
