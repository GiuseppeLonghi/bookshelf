package com.packtpub.felix.bookshelf.service.tui.activator;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.packtpub.felix.bookshelf.service.tui.BookshelfServiceProxyImpl;

public class BookshelfTuiActivator implements BundleActivator 
{
	private ServiceRegistration reg;
	
	public void start(BundleContext context) throws Exception 
	{
		System.out.println("\nStarting Bookshelf TUI Impl");

		Hashtable<String, Object> props = new Hashtable<String, Object>();
		props.put("osgi.command.scope", BookshelfServiceProxyImpl.SCOPE);
		props.put("osgi.command.function", BookshelfServiceProxyImpl.FUNCTIONS);
		
		this.reg = context.registerService(BookshelfServiceProxyImpl.class.getName(), new BookshelfServiceProxyImpl(context), props);
	}

	public void stop(BundleContext context) throws Exception 
	{
		System.out.println("\nStoping Bookshelf Service Gogo commands");
		if(this.reg != null)
		{
			// Releasing the service object referenced by the specified ServiceReference object
			context.ungetService(reg.getReference());
			this.reg = null;
		}	
	}

}
