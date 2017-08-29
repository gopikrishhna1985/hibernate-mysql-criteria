# hibernate-mysql-criteria
A Simple Hibernate MySQL example explaining the Criteria API

Criteria - helps to build nested and structured query in java (not possible with HQL or SQL)… compile time syntax checking… performance issue coz generated query is slow… maintanence issue - queries scattered through java code and code becomes very difficult to understand 

Criteria criteriaObj = sessionObj.createCriteria(Employee.class); 

Restrictions - allows user to add restrictions like eq, ne, like, illike(case sensitive), MatchMode(ANYWHERE, END, EXACT, START) on the string, isNull, isNotNull, ge, get, it, le 

Criterion - is actually a restriction defined in a criteria object 

Criteria criteriaObj = sessionObj.createCriteria(Employee.class); 

criteriaObj.add(Restrictions.eq("employeeId", 220L)); 

criteriaObj.addOrder(Order.desc("employeeId")); 

List<Employee> empDetail = criteriaObj.list(); 
 
LogiCalExpression - used to combine two same criterion (like OR) 

DisJunction - used to combine more than two different criterion (like OR) 

Conjunction - used to combine more than two different criterion (but like AND) 

SqlRestriction - used to specific directly in the sql statement (crit.add(Restrictions.sqlRestriction("{alias}.description like 'Mou%'"));) 

Pagination - getFirstResult() - integer represents the first row of the result set, getMaxResult() - integer until which you want the records to be fetched 

UniqueResult - if you want to obtain a single Object entity instead of list…. If more than one result comes up throws hibernateException… works like Map result in JDBC 

Distinct Result - DISTINCT like queries 

Sorting - Order.desc() or Order.asc() 

Projection - provides aggregate functions like avg(), max(), min(), sum(), count() countDistinct() 

QueryByObject - instead of build query with criterion object, you can create criteria by using entity object by partial filtering 
