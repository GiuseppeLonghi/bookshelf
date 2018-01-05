/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.impl.mock.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.packtpub.felix.bookshelf.inventory.api.BookInventory;
import com.packtpub.felix.bookshelf.inventory.impl.mock.BookInventoryMockImpl;

/**
 * @author glonghitano
 *
 */
public class BookInventoryMockImplActivator implements BundleActivator 
{
	private ServiceRegistration reg = null;
	
	/**{@inheritDoc}*/
	public void start(BundleContext context) throws Exception 
	{
		System.out.println("\nStarting Book Inventory Mock Impl");
		
		// Registering the specified service object with the specified properties under the specified class name with the Framework.
		this.reg = context.registerService(BookInventory.class.getName(), new BookInventoryMockImpl(), null);

	}

	/**{@inheritDoc}*/
	public void stop(BundleContext context) throws Exception 
	{	
		System.out.println("\nStoping Book Inventory Mock Impl");
		if(this.reg != null)
		{
			// Releasing the service object referenced by the specified ServiceReference object
			context.ungetService(reg.getReference());
			this.reg = null;
		}
	}

}
