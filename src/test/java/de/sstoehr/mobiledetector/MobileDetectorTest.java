package de.sstoehr.mobiledetector;

import org.junit.Assert;
import org.junit.Test;

import de.sstoehr.mobiledetector.model.Device;
import de.sstoehr.mobiledetector.model.DevicePlatform;
import de.sstoehr.mobiledetector.model.DeviceType;
public class MobileDetectorTest {

    @Test
    public void test() {

        MobileDetector m = new MobileDetector();

        Assert.assertEquals(
          Device.UNKNOWN,
          m.detectBy(null)
        );

        Assert.assertEquals(
          new Device(DeviceType.DESKTOP, DevicePlatform.UNKNOWN),
          m.detectBy("abc")
        );

        // iOS
        Assert.assertEquals(
          new Device(DeviceType.MOBILE, DevicePlatform.IOS),
          m.detectBy("Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko)"
            + " Version/6.0 Mobile/10A5376e Safari/8536.25")
        );

        Assert.assertEquals(
          new Device(DeviceType.TABLET, DevicePlatform.IOS),
          m.detectBy("Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko)"
            + " Version/6.0 Mobile/10A5376e Safari/8536.25")
        );

        // Android
        Assert.assertEquals(
          new Device(DeviceType.MOBILE, DevicePlatform.ANDROID),
          m.detectBy("Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev>"
            + "(KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>")
        );

        Assert.assertEquals(
          new Device(DeviceType.TABLET, DevicePlatform.ANDROID),
          m.detectBy("Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev>"
            + "(KHTML, like Gecko) Chrome/<Chrome Rev> Safari/<WebKit Rev>")
        );

        // Blackberry
        Assert.assertEquals(
          new Device(DeviceType.MOBILE, DevicePlatform.UNKNOWN),
          m.detectBy("Mozilla/5.0 (BlackBerry; U; BlackBerry AAAA; en-US) AppleWebKit/534.11+"
            + " (KHTML, like Gecko) Version/X.X.X.X Mobile Safari/534.11+")
        );

        Assert.assertEquals(
          new Device(DeviceType.TABLET, DevicePlatform.UNKNOWN),
          m.detectBy("Mozilla/5.0 (PlayBook; U; RIM Tablet OS 1.0.0; en-US) AppleWebKit/534.8+"
            + " (KHTML, like Gecko) Version/0.0.1 Safari/534.8+")
        );

        // Windows Phone
        Assert.assertEquals(
          new Device(DeviceType.MOBILE, DevicePlatform.UNKNOWN),
          m.detectBy("Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0;"
            + " IEMobile/9.0; <manufacturer>; <model> [;<operator])")
        );

        // Other mobile browsers
        Assert.assertEquals(
          new Device(DeviceType.MOBILE, DevicePlatform.UNKNOWN),
          m.detectBy("SamsungI8910/SymbianOS/9.1 Series60/3.0")
        );

        // Desktop
        Assert.assertEquals(
          new Device(DeviceType.DESKTOP, DevicePlatform.UNKNOWN),
          m.detectBy("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko)"
            + " Chrome/41.0.2228.0 Safari/537.36")
        );

    }

}