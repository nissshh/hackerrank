select u.name,sum(r.distance) d from users u join rides r on u.id=r.user_id group by r.user_id,u.name order by d DESC,u.name limit 100;	