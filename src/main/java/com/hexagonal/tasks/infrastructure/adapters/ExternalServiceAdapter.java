package com.hexagonal.tasks.infrastructure.adapters;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.infrastructure.adapters.models.JsonPlaceHolderTodo;
import com.hexagonal.tasks.infrastructure.adapters.models.JsonPlaceHolderUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if(todo == null){
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();

        if(user == null){
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());


    }

}