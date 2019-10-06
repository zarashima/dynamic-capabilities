package devices;

public class DeviceInformation {
    private String deviceName;
    private String platformName;
    private String systemPort;
    private String deviceId;
    private String deviceVersion;

    public DeviceInformation(String platformName, String deviceName, String systemPort, String deviceId, String deviceVersion) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.systemPort = systemPort;
        this.deviceId = deviceId;
        this.deviceVersion = deviceVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getSystemPort() {
        return systemPort;
    }

    public void setSystemPort(String systemPort) {
        this.systemPort = systemPort;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

}
