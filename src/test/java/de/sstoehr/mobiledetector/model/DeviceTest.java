package de.sstoehr.mobiledetector.model;

import org.junit.Assert;
import org.junit.Test;
public class DeviceTest {

    @Test
    public void test() {
        Device d1 = new Device();
        Device d2 = new Device(null, null);

        Assert.assertEquals(DeviceType.UNKNOWN, d1.type());
        Assert.assertEquals(DevicePlatform.UNKNOWN, d1.platform());

        Assert.assertEquals(DeviceType.UNKNOWN, d2.type());
        Assert.assertEquals(DevicePlatform.UNKNOWN, d2.platform());

        Assert.assertTrue(d1.equals(d1));
        Assert.assertTrue(d1.equals(d2));
        Assert.assertFalse(d1.equals(null));
        Assert.assertEquals(d1.hashCode(), d2.hashCode());

        Device d3 = d2.platform(DevicePlatform.IOS);
        Assert.assertEquals(DevicePlatform.IOS, d3.platform());
        Assert.assertFalse(d3 == d2);
        Assert.assertFalse(d2.equals(d3));

        Device d4 = d3.type(DeviceType.MOBILE);
        Assert.assertEquals(DeviceType.MOBILE, d4.type());
        Assert.assertEquals(DevicePlatform.IOS, d4.platform());
        Assert.assertFalse(d4 == d3);
        Assert.assertFalse(d3.equals(d4));
        Assert.assertEquals("MOBILE (IOS)", d4.toString());
    }
}