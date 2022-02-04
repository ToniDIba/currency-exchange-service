package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>
{

    ExchangeValue findByFromAndTo(String from, String to);

    /*
    Hibernate lo traduce por esto en runtime

       select
        exchangeva0_.id ,
        exchangeva0_.conversion_multiple ,
        exchangeva0_.currency_from ,
        exchangeva0_.port a,
        exchangeva0_.currency_to
    from
        exchange_value exchangeva0_
    where
        exchangeva0_.currency_from= 'USD'
        and exchangeva0_.currency_to= 'INR'

     */











}
