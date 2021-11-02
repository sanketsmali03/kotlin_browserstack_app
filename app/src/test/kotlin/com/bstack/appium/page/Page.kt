package com.bstack.appium.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import com.bstack.appium.util.OS
import org.openqa.selenium.support.PageFactory

abstract class Page(val driver: AppiumDriver<*>) {

  val os = if (driver is AndroidDriver) OS.ANDROID else OS.IOS

  init {
    PageFactory.initElements(AppiumFieldDecorator(driver), this)
  }
}
