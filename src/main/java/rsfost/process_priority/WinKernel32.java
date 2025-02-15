package rsfost.process_priority;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.W32APIOptions;

public interface WinKernel32 extends Library
{
    Pointer GetCurrentProcess();
    boolean SetPriorityClass(Pointer hProcess, int dwPriorityClass);

    static WinKernel32 getInstance()
    {
        return Native.load("kernel32", WinKernel32.class, W32APIOptions.DEFAULT_OPTIONS);
    }
}
