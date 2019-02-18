package com.mitrai.ResourcePlanner.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        if(attr!=null) {
            String tenantId = attr.getRequest().getParameter("tenantId");       // find parameter from request
            if(tenantId==null){
                return "tenantId1";
            }
            return  tenantId;
        }else{
            return "tenantId1";             // default data source
        }

	}

}
