package rsfost.process_priority;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Windows Process Priority"
)
public class ProcessPriorityPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ProcessPriorityConfig config;

    @Override
    protected void startUp() throws Exception
    {

    }

    @Override
    protected void shutDown() throws Exception
    {

    }

    @Provides
    ProcessPriorityConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ProcessPriorityConfig.class);
    }
}
