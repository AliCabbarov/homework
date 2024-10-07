create procedure calculate_total_amount(in_total_amount double precision, company_id bigint) as
$$
begin
    update company set total_amount = total_amount + in_total_amount where company.id = company_id;
end;
$$ language plpgsql;