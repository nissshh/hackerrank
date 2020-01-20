USE test;
SELECT CITY,LENGTH(CITY) FROM STATION ORDER BY CITY LIMIT 1;
SELECT CITY,LENGTH(CITY) FROM STATION ORDER BY CITY DESC LIMIT 1;

SELECT CITY,LENGTH(CITY) FROM STATION WHERE SUBSTRING(NAME,1,1) IN (a,e,i,o,u);

select distinct city from station 
where substring(lower(city),1,1) not in ('a','e','i','o','u') or 
substring(lower(CITY),-1) not in ('a','e','i','o','u');

select name,substring(name,-1,3) from students
order by right(name,3);
select round(median(lat_n), 4) from station;

select months*salary, count(months*salary) from employee group by (months*salary) order by (months*salary) desc limit 1;
select round(sum(lat_n),2) lat ,round(sum(long_w),2) lon from station;
select name, row_count() as r from employee order by name ;
select round(sum(lat_n),4) lat from station where lat_n>38.7880 and lat_n<137.2345;
select long_w from station where lat_n=(select max(lat_n) from station) and lat_n<137.2345;
select round(long_w,4) from station where id = (
select id from station where lat_n<137.2345 order by lat_n desc limit 1);
select round(min(lat_n),4) from station group by lat_n having lat_n>38.7780 limit 1;
select round(long_w,4) from station where id = (
select id from station where lat_n>38.7780 order by lat_n asc limit 1);
select round(long_w,4) from station where lat_n = (
select min(lat_n) from station group by lat_n having lat_n>38.7780 limit 1);

-- select (max(lat_n) - min(lat_n)) + (max(long_w) - min(long_w)) from station order by lat_n , long_w limit 1;
select round((max(lat_n) - min(lat_n) -min(long_w)) + (max(long_w) - min(long_w)),4) from station;

select round(
			sqrt(
				pow(
					(min(lat)-min(lng))
                    ,2) 
				+ 
                pow(
					(max(lat)-max(lng))
                    ,2)
				)
			,4) from station;

select s.name,g.grade gr,s.marks from students s,grades g where g.grade > 7 and s.marks between g.min_mark and g.max_mark union 
select 'NULL',g.grade gr,s.marks from students s,grades g where g.grade <= 7 and s.marks between g.min_mark and g.max_mark order by gr desc;            
            
select ci.name from city ci join country co on ci.countrycode=co.code where co.continent='Africa';
select co.continent,floor(avg(ci.population)) from city ci join country co on ci.countrycode=co.code group by co.continent; 
select sum(ci.population) from city ci join country co on ci.countrycode=co.code where co.continent='Asia';

select s.hacker_id,h.name from submissions s 
join challenges c on s.challenge_id=c.challenge_id
join difficulty d on c.difficulty_level=d.difficulty_level
join hackers h on s.hacker_id=h.hacker_id 
where s.score=d.score
group by s.hacker_id, name
having count(s.hacker_id) > 1
order by count(s.hacker_id) desc, s.hacker_id;

select id,age,min(coins_needed),power 
from wands w join wands_property p on w.code=p.code 
where p.is_evil=0 and coins_needed= (select min(coins_needed) from wands group by power,age,coins_needed)
group by coins_needed,id,age,power
order by w.power desc,p.age desc;


select id,age,min(coins_needed),power 
from wands w join wands_property p on w.code=p.code 
where p.is_evil=0 
order by w.power desc,p.age desc;


select hacker_id,challenge_id,max(score) as mscore,count(score) from submissions s 
group by hacker_id,challenge_id
having max(score)<>0
order by hacker_id asc;

SELECT A,B,C,
CASE
	WHEN A+B<C or A+C<B or B+C<A THEN "Not A Triangle"
    WHEN A=B AND B=C AND C=A THEN "Equilateral"
    WHEN (A=B AND B<>C) OR (A<>B AND B=C)  OR (A=C AND B<>C) THEN "Isosceles"
    WHEN A<>B AND B<>C AND C<>A  THEN "Scalene"
    ELSE "Not A Triangle"
END AS result
FROM TRIANGLES
;

SELECT  concat(name,'(',substring(occupation,1,1),')') FROM occupations;
SELECT  concat('There are a total of ',count(name),' ',occupation,'s.') FROM occupations
GROUP BY occupation order by count(name),occupation ;

SELECT N,
CASE
	WHEN P IS NULL THEN "Root"
    WHEN N IN (SELECT P FROM tree I) THEN "Inner"
    ELSE "Leaf"
END AS result
FROM Tree O;


select c.company_code,c.founder,
count(distinct lm.lead_manager_code) LMS,
count(distinct sm.senior_manager_code) SMS, 
count(distinct mn.manager_code) MNS,
count(distinct employee_code) EMPS
from company c 
join lead_manager lm on c.company_code=lm.company_code 
join senior_manager sm on lm.lead_manager_code=sm.lead_manager_code
join manager mn on sm.senior_manager_code=mn.senior_manager_code
join employee emp on mn.manager_code=emp.manager_code
group by c.company_code,c.founder
order by c.company_code ;

select s.name from students s 
join friends f on s.ID=f.id
join packages p on s.ID=p.Id
join packages p1 on f.friend_ID=p1.Id
where p.salary < p1.salary
order by p1.salary;


select f1.x,f1.y form functions f1,functions f2
where f1.x=f2.y and f1.y=f2.x and f1.x<>f2.x and f1.y<>f2.y
order by f1.x;
