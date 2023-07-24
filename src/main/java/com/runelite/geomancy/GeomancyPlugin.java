package com.runelite.geomancy;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Geomancy"
)
public class GeomancyPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private GeomancyConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Geomancy started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Geomancy stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Geomancy says " + config.greeting(), null);
		}
	}

	@Provides
	GeomancyConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GeomancyConfig.class);
	}
}
