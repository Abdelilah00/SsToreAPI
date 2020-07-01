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


@Aspect
@Component
public class BaseServiceAspect {
    @PersistenceContext
    EntityManager entityManager;


    @Before("execution(* com.springBootLibrary.services.BaseCrudServiceImpl.*(..)) && target(service)")
    public void aroundExecution(IBaseCrudService service) throws Throwable {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("tenantFilter").setParameter("tenantId", TenantContext.getCurrentTenant());

    }
}
