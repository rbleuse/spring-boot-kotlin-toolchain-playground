package io.github.rbleuse

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ToolchainDemoApplication

fun main(args: Array<String>) {
    runApplication<ToolchainDemoApplication>(*args)
}

@Entity
class Todo(
    @Column(nullable = false)
    var title: String,

    var done: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)

interface TodoRepository : JpaRepository<Todo, Long>

data class CreateTodoRequest(
    @NotBlank val title: String,
)

@RestController
@RequestMapping("/todos")
class TodoController(
    private val repository: TodoRepository,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateTodoRequest): Todo =
        repository.save(Todo(title = request.title))

    @GetMapping
    fun list(): List<Todo> = repository.findAll()
}
