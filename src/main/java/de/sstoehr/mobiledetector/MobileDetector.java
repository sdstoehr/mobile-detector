package de.sstoehr.mobiledetector;

import java.util.Arrays;
import java.util.List;

import de.sstoehr.mobiledetector.model.Device;
import de.sstoehr.mobiledetector.model.DevicePlatform;
import de.sstoehr.mobiledetector.model.DeviceType;

public class MobileDetector {

    private static final List<String> MOBILE_USER_AGENT_PREFIXES = Arrays.asList(
      "w3c ", "w3c-", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq",
      "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco",
      "eric", "hipt", "htc_", "inno", "ipaq", "ipod", "jigs", "kddi", "keji",
      "leno", "lg-c", "lg-d", "lg-g", "lge-", "lg/u", "maui", "maxo", "midp",
      "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-", "newt", "noki",
      "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage",
      "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-",
      "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-",
      "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi",
      "wapp", "wapr", "webc", "winw", "winw", "xda ", "xda-");

    private static final List<String> MOBILE_USER_AGENT_KEYWORDS = Arrays.asList(
      "blackberry", "webos", "ipod", "lge vx", "midp", "maemo", "mmp", "mobile",
      "netfront", "hiptop", "nintendo DS", "novarra", "openweb", "opera mobi",
      "opera mini", "palm", "psp", "phone", "smartphone", "symbian", "up.browser",
      "up.link", "wap", "windows ce", "fennec");

    private static final List<String> TABLET_USER_AGENT_KEYWORDS = Arrays.asList(
      "ipad", "playbook", "hp-tablet", "kindle");


    public Device detectBy(String userAgent) {

        if (userAgent == null) {
            return Device.UNKNOWN;
        }

        userAgent = userAgent.toLowerCase();

        Device tablet = detectTabletDeviceBy(userAgent);
        if (tablet != null) {
            return tablet;
        }

        Device mobile = detectMobileDeviceBy(userAgent);
        if (mobile != null) {
            return mobile;
        }

        return new Device(DeviceType.DESKTOP, DevicePlatform.UNKNOWN);
    }

    /**
     * Detects tablets by user agent.
     * @param userAgent User Agent to check
     * @return Device information or null, when device is no tablet.
     */
    private Device detectTabletDeviceBy(String userAgent) {
        if (userAgent.contains("android") && !userAgent.contains("mobile")) {
            return new Device(DeviceType.TABLET, DevicePlatform.ANDROID);
        }

        if (userAgent.contains("ipad")) {
            return new Device(DeviceType.TABLET, DevicePlatform.IOS);
        }

        for (String keyword : TABLET_USER_AGENT_KEYWORDS) {
            if (userAgent.contains(keyword)) {
                return new Device(DeviceType.TABLET, DevicePlatform.UNKNOWN);
            }
        }

        return null;
    }

    /**
     * Detects mobile devices by user agent.
     * @param userAgent User Agent to check
     * @return Device information or null, when device is no mobile.
     */
    private Device detectMobileDeviceBy(String userAgent) {
        if (userAgent.length() > 3) {
            String prefix = userAgent.substring(0, 4).toLowerCase();
            if (MOBILE_USER_AGENT_PREFIXES.contains(prefix)) {
                return new Device(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
            }
        }

        if (userAgent.contains("android")) {
            return new Device(DeviceType.MOBILE, DevicePlatform.ANDROID);
        }

        if (userAgent.contains("iphone") || userAgent.contains("ipod") || userAgent.contains("ipad")) {
            return new Device(DeviceType.MOBILE, DevicePlatform.IOS);
        }
        for (String keyword : MOBILE_USER_AGENT_KEYWORDS) {
            if (userAgent.contains(keyword)) {
                return new Device(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
            }
        }

        return null;
    }
}
