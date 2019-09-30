package it.gangemi.hellotemplate

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody



@RestController
class HelloRestController {

    @Autowired
    lateinit var userService: UserService

    @RequestMapping("/api/user/{id}")
    fun userFineder(@PathVariable id:Int) : UserData {
        return UserData(id,userService.findUserByPosition(id))
    }

    @ExceptionHandler(Exception::class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleException(e: Exception): String {
        return "Unknown user"
    }
}