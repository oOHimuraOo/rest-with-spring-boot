package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding All people")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0 .. 7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id:Int): Person {
        logger.info("finding one person!")

        val person = mockPerson(id)

        return person
    }

    fun createPerson(person: Person): Person{
        //deveria acessar o banco e criar uma nova pessoa no banco
        return person
    }

    fun updatePerson(person: Person): Person{
        //deveria acessar o banco e modificar uma pessoa
        return person
    }

    fun deletePerson(id: Int): String{
        //deveria acessar o banco e apagar uma pessoa usando o id
        return "Ok $id"
    }

    private fun mockPerson(i: Int):Person {
        val person = Person()
        person.id = i
        person.firstName = "first name $i"
        person.lastName = "last name $i"
        person.address = "addres $i"
        person.gender = "gender"

        return person
    }
}