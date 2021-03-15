/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import businessentitiesapi.CustomerManager;
import persistence.PersistenceAPI;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class BusinessLogicAPIImpl implements BusinessLogicImplementationProvider, BusinessLogicAPI {
    
    final PersistenceAPI persistenceAPI;

    BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public CustomerManager getCustomerManager(){
        CustomerManagerImpl customerManager = new CustomerManagerImpl();
        customerManager.setCustomerStorageService(persistenceAPI.getCustomerStorageService( customerManager ) );
        return customerManager;
    }
    
}