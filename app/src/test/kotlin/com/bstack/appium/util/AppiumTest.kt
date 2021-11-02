package com.bstack.appium.util

import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver
import java.net.URL
import java.nio.file.Paths
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import java.util.concurrent.TimeUnit


/**
 * Created by zoonooz on 2017/11/17.
 * Base test class for Appium
 */
open class AppiumTest {

  var os: OS = OS.ANDROID
  var driver: AppiumDriver<MobileElement>? = null

  @Before
  fun setup() {
    os = OS.valueOf(System.getProperty("platform", OS.ANDROID.name))
    val capabilities = DesiredCapabilities()
    val userDir = System.getProperty("user.dir")
    val serverAddress = URL("https://<BROWSERSTACK-USERNAME>:<ACCESSKEY>@hub-cloud.browserstack.com/wd/hub")
    capabilities.setCapability("device", "Samsung Galaxy S8 Plus")
    capabilities.setCapability("os_version", "7.0")
    capabilities.setCapability("project", "My First Project")
    capabilities.setCapability("build", "My First Build")
    capabilities.setCapability("name", "Bstack-[Java] Sample Test")
    capabilities.setCapability("app", "bs://<APP ID>")

    driver = AndroidDriver(serverAddress, capabilities)

    driver?.let {
      it.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
    }
  }

  @After
  fun tearDown() {
    driver?.quit()
  }
}
