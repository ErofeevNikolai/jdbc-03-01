#СКРИПТ SQL
select c.name,
       o.product_name product_name_orders
from netology.orders o
         left join netology.customers c on c.id = o.customer_id
having c.name=:name
order by product_name_orders
;