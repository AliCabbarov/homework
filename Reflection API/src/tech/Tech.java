package tech;

public class Tech {
    @OperatingSystem("android")
    @Portable(value = true)
    private String samsung;
    @OperatingSystem("IOS")
    @Portable(value = true)
    private String iphone;
    @OperatingSystem("android")
    @Portable
    private String tv;
    @OperatingSystem("windows")
    @Portable
    private String pc;
    @OperatingSystem("IOS")
    @Portable(value = true)
    private String iPad;
}
