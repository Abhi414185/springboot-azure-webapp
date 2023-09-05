Go
CREATE PROCEDURE Person.D_InfoDisplay
	@FirstName nvarchar(10)='Ken'
AS
BEGIN
	SELECT BusinessEntityId as 'ID',
		FirstName + LastName as 'NAME',
		personType
	from Person.Person
	WHERE FirstName=@FirstName
END
Go

Execute Person.D_InfoDisplay
Execute Person.D_InfoDisplay @FIrstName = 'Terry'
