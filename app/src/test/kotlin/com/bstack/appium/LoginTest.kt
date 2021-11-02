package com.bstack.appium

import com.bstack.appium.page.MainPage
import com.bstack.appium.util.AppiumTest
import org.junit.Assert.*
import org.junit.Test

class LoginTest : AppiumTest() {

  @Test
  fun login() {
    val mainPage = MainPage(driver!!)
    mainPage.loginWith()
  }
}
