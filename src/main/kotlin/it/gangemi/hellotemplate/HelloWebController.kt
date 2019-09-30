package it.gangemi.hellotemplate

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloWebController {

    companion object : Log()

    @Autowired
    lateinit var userService: UserService

    @RequestMapping("/user/{id}")
    fun hello(@PathVariable id: Int, model: Model): String {
        try {
            return greetingUser(model, id)
        } catch (e: RuntimeException) {
            log.error("invalid param: id=$id")
            throw e
        }
    }

    private fun greetingUser(model: Model, num: Int): String {
        model.addAttribute("user", userService.findUserByPosition(num))
        log.info("Ok")
        return "hello"
    }

}