--EXERCISE 1

--1)
select * from Sales.SalesPerson

--2
select * from Person.person
where FirstName like 'b%'

--3
select FirstName,LastName from [Person].[Person]
join HumanResources.Employee on HumanResources.Employee.BusinessEntityID = Person.Person.BusinessEntityID
where HumanResources.Employee.JobTitle in ('Design Engineer','Tool Designer','Marketing Assistant')

--4
select name,Color,Weight from Production.Product
where Weight=(select max(weight) from Production.Product)

--5
select coalesce(MaxQty,0.00)as MaxQty,Description from Sales.SpecialOffer

--6
select AVG(AverageRate) from Sales.CurrencyRate
where FromCurrencyCode='USD' AND ToCurrencyCode='GBP'

--7
select ROW_NUMBER() over(order by FirstName,LastName asc)as S_No,FirstName,LastName from Person.Person
where FirstName like '%ss%'

--8
select BusinessEntityID as SalesPersonID,
case when  commissionPct =0.00 then 'BAND 0'
when  commissionPct > 0.00 and commissionPct <=0.01 then 'BAND 1'
when  commissionPct > 0.01 and commissionPct <=0.015  then 'BAND 2'
when  commissionPct > 0.015 then 'BAND 3'
end as CommissionBand from Sales.SalesPerson;

--10
select Top 1 ProductID,MAX(SafetyStockLevel) as MaxStock FROM Production.Product Group By ProductID


