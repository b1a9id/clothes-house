package com.b1a9idps.clotheshouse.controller.support

import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Component
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@Component
@RestControllerAdvice(annotations = [RestController::class])
class ControllerCommonAdvice {

    @InitBinder
    fun initBinder(binder: WebDataBinder) {
        binder.registerCustomEditor(String::class.java, StringTrimmerEditor(true))
    }
}
