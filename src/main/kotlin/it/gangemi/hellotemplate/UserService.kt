package it.gangemi.hellotemplate

import org.springframework.stereotype.Service

@Service
class UserService {

    companion object : Log()

    val useridArray = arrayOf("cg08331", "cg07464", "cg07483", "cg11583")

    fun findUserByPosition(num:Int) : String {

        if (num<0 || num>=useridArray.size) {
            throw RuntimeException("unknown")
        }

        val username = useridArray[num]
        log.info("found username:$username in position:$num")
        return username
    }

}