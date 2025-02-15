package rsfost.process_priority;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Windows Process Priority",
        description = "Set the priority level of the RuneLite process (Windows only)"
)
public class ProcessPriorityPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ProcessPriorityConfig config;

    private WinKernel32 winKernel32;

    @Override
    protected void startUp() throws Exception
    {
        final String os = System.getProperty("os.name");
        if (os == null || !os.toLowerCase().contains("win"))
        {
            log.error("This plugin only supports Windows");
            return;
        }

        winKernel32 = WinKernel32.getInstance();
        setPriority();
    }

    @Override
    protected void shutDown() throws Exception
    {
        winKernel32 = null;
    }

    @Provides
    ProcessPriorityConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ProcessPriorityConfig.class);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (ProcessPriorityConfig.CONFIG_GROUP.equals(event.getGroup()))
        {
            setPriority();
        }
    }

    private void setPriority()
    {
        if (winKernel32 == null)
        {
            log.error("kernel32 library failed to load");
            return;
        }
        winKernel32.SetPriorityClass(winKernel32.GetCurrentProcess(), config.windowsPriority().getDwPriorityClass());
    }
}
