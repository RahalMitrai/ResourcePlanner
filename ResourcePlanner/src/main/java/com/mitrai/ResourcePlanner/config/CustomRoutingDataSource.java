package com.mitrai.ResourcePlanner.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource{

    public final static String DEFAULT_TENANT_ID = "tenantId1";


    @Override
	protected Object determineCurrentLookupKey() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        if(attr!=null) {
            String tenantId = attr.getRequest().getHeader("tenantId"); // find parameter from request
            if(tenantId==null){
                return DEFAULT_TENANT_ID;
            }
            return  tenantId;
        }
        return DEFAULT_TENANT_ID;

	}

}
