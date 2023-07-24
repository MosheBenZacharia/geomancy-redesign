package com.runelite.geomancy;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GeomancyPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GeomancyPlugin.class);
		RuneLite.main(args);
	}
}