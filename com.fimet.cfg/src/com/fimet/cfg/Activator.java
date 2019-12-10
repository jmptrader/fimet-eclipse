package com.fimet.cfg;

import org.osgi.framework.BundleContext;

import com.fimet.commons.AbstractActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractActivator {
	// The plug-in ID
	public static final String PLUGIN_ID = "com.fimet.cfg"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public String getPluginId() {
		return PLUGIN_ID;
	}

	public static AbstractActivator getInstance() {
		return plugin;
	}

}
