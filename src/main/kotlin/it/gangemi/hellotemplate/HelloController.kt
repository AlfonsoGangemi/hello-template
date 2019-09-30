package it.gangemi.hellotemplate

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {

    companion object : Log()

    @Autowired
    lateinit var userService: UserService

    @RequestMapping("/")
    fun hello(@RequestParam num: Int, model: Model): String {
        return try {
            greetingUser(model, num)
        } catch (e: RuntimeException) {
            log.error("invalid param: num=$num")
            "unknown"
        }
    }

    private fun greetingUser(model: Model, num: Int): String {
        model.addAttribute("user", userService.findUserByPosition(num))
        log.info("Ok")
        return "hello"
    }

}