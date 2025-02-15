package rsfost.process_priority;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(ProcessPriorityConfig.CONFIG_GROUP)
public interface ProcessPriorityConfig extends Config
{
    String CONFIG_GROUP = "process-priority";

    @ConfigItem(
            keyName = "windowsPriority",
            name = "Priority",
            description = "Priority level for the RuneLite process"
    )
    default WinPriorityClass windowsPriority()
    {
        return WinPriorityClass.NORMAL;
    }
}
