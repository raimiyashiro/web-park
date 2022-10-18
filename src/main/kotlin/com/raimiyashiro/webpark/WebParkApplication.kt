package com.raimiyashiro.webpark

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebParkApplication

fun main(args: Array<String>) {
	runApplication<WebParkApplication>(*args)
}
