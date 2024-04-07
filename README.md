# Задание 7
 
Выбрать базу данных на свой вкус (рекомендуется реляционная Postgres).

Решение сделать на уровне Java. Рекомендуется sql-запрос на чистом JDBC. Но, безусловно, есть и другие варианты.

**Дана таблица employeesAge**

```
id employeeName age
0 Кирилл 18
1 Саша 20
2 Катя 25
```

Вывести всех сотрудников, чей возраст больше 20.


**Дана таблица departmentSalary**

```
id employeeName departmentName salary
0 Кирилл IT 30000
1 Иван IT 20000
2 Маша HR 40000
```

Вывести среднюю зарплату по каждому отделу
departmentName averageSalary
IT 25000
HR 40000


**Даны таблицы departmentEmployee и departmentLocation**

```
id employeeName departmentId
0 Кирилл 1
1 Иван 1
2 Маша 2
```

```
departmentId departmentName location
1 IT Саратов
2 HR Москва
```

Для каждого сотрудника вывести имя его департамента и локацию работы

```
employeeName departmentName location
Кирилл IT Саратов
Иван IT Калифорния
Маша HR Москва
```

