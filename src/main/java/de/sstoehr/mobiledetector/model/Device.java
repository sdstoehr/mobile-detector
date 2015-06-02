package de.sstoehr.mobiledetector.model;

public class Device {

    public static final Device UNKNOWN = new Device();

    private final DeviceType type;
    private final DevicePlatform platform;

    public Device(final DeviceType type, final DevicePlatform platform) {
        if (type == null) {
            this.type = DeviceType.UNKNOWN;
        } else {
            this.type = type;
        }
        if (platform == null) {
            this.platform = DevicePlatform.UNKNOWN;
        } else {
            this.platform = platform;
        }
    }

    public Device() {
        this(DeviceType.UNKNOWN, DevicePlatform.UNKNOWN);
    }

    public Device type(DeviceType deviceType) {
        return new Device(deviceType, platform);
    }

    public Device platform(DevicePlatform devicePlatform) {
        return new Device(type, devicePlatform);
    }

    public DeviceType type() {
        return type;
    }

    public DevicePlatform platform() {
        return platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Device device = (Device) o;

        if (type != device.type) {
            return false;
        }
        return platform == device.platform;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + platform.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return type + " (" + platform + ")";
    }
}
