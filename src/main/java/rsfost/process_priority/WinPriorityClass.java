package rsfost.process_priority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WinPriorityClass
{
    HIGH("High", 0x00000080),
    ABOVE_NORMAL("Above normal", 0x00008000),
    NORMAL("Normal", 0x00000020),
    BELOW_NORMAL("Below normal", 0x00004000),
    IDLE("Low", 0x00000040);

    private final String name;
    private final int dwPriorityClass;

    @Override
    public String toString()
    {
        return name;
    }
}
