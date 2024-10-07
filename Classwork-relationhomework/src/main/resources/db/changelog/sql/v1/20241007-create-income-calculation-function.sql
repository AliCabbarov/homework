CREATE OR REPLACE FUNCTION calculate_and_get_income()
    RETURNS TABLE (income numeric,id bigint)
    LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY SELECT sum(op.quantity * op.price) as total_income,
                        _order.id as id
                 from _order
                          left join order_product op on _order.id = op.order_id
                 group by  _order.id order by total_income desc;
END;
$$;