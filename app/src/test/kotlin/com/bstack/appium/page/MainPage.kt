package com.bstack.appium.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.*

class MainPage(driver: AppiumDriver<*>) : Page(driver) {

  @AndroidFindBy(id = "Search Wikipedia")
  private var userTextField: MobileElement? = null

  @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
  private var passwordTextField: MobileElement? = null

  @AndroidFindBy(class = "android.widget.TextView")
  private var loginButton: MobileElement? = null


  fun loginWith(): MainPage {
    userTextField?.click()
    passwordTextField?.setValue("BrowserStack")
    return this
  }

  fun isLoginSuccess(): Boolean {
    return statusTextView?.text == "Login Successfully"
  }
}
