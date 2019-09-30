package it.gangemi.hellotemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloTemplateApplication

fun main(args: Array<String>) {
    runApplication<HelloTemplateApplication>(*args)
}
