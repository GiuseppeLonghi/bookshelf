package com.packtpub.felix.bookshelf.service.tui.activator;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.packtpub.felix.bookshelf.service.tui.BookshelfServiceProxy;

public class BookshelfTuiActivator implements BundleActivator 
{

	public void start(BundleContext context) throws Exception 
	{
		Hashtable<String, Object> props = new Hashtable<String, Object>();
		props.put("osgi.command.scope", BookshelfServiceProxy.SCOPE);
		props.put("osgi.command.function", BookshelfServiceProxy.FUNCTIONS);
		
		context.registerService(BookshelfServiceProxy.class.getName(), new BookshelfServiceProxy(context), props);
	}

	public void stop(BundleContext context) throws Exception 
	{
		// TODO Auto-generated method stub	
	}

}
