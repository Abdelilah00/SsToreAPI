////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.configuration;

import com.springBootLibrary.services.IBaseCrudService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;


@Aspect
@Component
public class BaseServiceAspect {
    @PersistenceContext
    EntityManager entityManager;


    @Before("execution(* com.SsTore.services.*.*.*(..)) && target(service)")
    public void beforeExecution(IBaseCrudService service) throws Throwable {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("tenantFilter").setParameter("tenantId", TenantContext.getCurrentTenant());
        session.enableFilter("deleteFilter");
    }

    @Before("execution(* com.springBootLibrary.services.*.*(..)) && target(service)")
    public void aroundExecution(IBaseCrudService service) throws Throwable {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("tenantFilter").setParameter("tenantId", TenantContext.getCurrentTenant());
        session.enableFilter("deleteFilter");
    }
}
