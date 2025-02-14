package rsfost.process_priority;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ProcessPriorityPluginTest
{
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(ProcessPriorityPlugin.class);
        RuneLite.main(args);
    }
}
