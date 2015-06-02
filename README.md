HAR reader
==========

Java library to detect mobile devices and tablets

```
<dependency>
  <groupId>de.sstoehr</groupId>
  <artifactId>mobile-detector</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

[![Build Status](https://travis-ci.org/sdstoehr/mobile-detector.png?branch=master)](https://travis-ci.org/sdstoehr/mobile-detector)
[![Coverage Status](https://coveralls.io/repos/sdstoehr/mobile-detector/badge.png?branch=master)](https://coveralls.io/r/sdstoehr/mobile-detector?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/de.sstoehr/mobile-detector.svg)](http://mvnrepository.com/artifact/de.sstoehr/mobile-detector)

## Usage

Detecting device by user agent:

```
MobileDetector mobileDetector = new MobileDetector();
Device device = mobileDetector.detectBy("userAgent string");

// device.type() - UNKNOWN, DESKTOP, MOBILE, TABLET
// device.platform() - UNKNOWN, IOS, ANDROID
```

