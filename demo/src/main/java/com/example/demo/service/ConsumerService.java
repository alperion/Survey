package com.example.demo.service;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.BaseTokenResponse;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Student;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.EmailAlreadyExistsException;
import com.example.demo.exception.custom.EmailNotValidException;
import com.example.demo.exception.custom.PasswordLoginException;
import com.example.demo.repository.ConsumerRepository;
import com.example.demo.utility.HashPassword;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    private final ConsumerRepository consumerRepository;
    private final JwtManager jwtManager;

    public ConsumerService(ConsumerRepository consumerRepository, JwtManager jwtManager) {
        this.consumerRepository = consumerRepository;
        this.jwtManager = jwtManager;
    }

    public BaseResponse register(RegisterRequest registerRequest){

        Optional<Consumer> consumer=consumerRepository.findOptionalByEmail(registerRequest.getEmail());

        if(consumer.isPresent()){
            throw new EmailAlreadyExistsException(); // EMAIL_ALREADY_EXIST EXCEPTION
        }
        if (!registerRequest.getEmail().contains("@")) {
            throw new EmailNotValidException(); // EMAIL_NOT_VALID
        }

        Consumer consumer1=new Consumer();
        consumer1.setEmail(registerRequest.getEmail());
        consumer1.setName(registerRequest.getName());
        consumer1.setLastName(registerRequest.getLastName());
        consumer1.setPassword(HashPassword.encrypt(registerRequest.getPassword()));
        consumer1.setPhoneNumber(registerRequest.getPhoneNumber());
        consumer1.setPhoneNumber(registerRequest.getPhoneNumber());
        consumer1.setRole(registerRequest.getRole());

        consumerRepository.save(consumer1);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("Kayıt Yapıldı");
        baseResponse.setStatusCode(200);

        return baseResponse;

    }

    public BaseTokenResponse login(LoginRequest loginRequest){
        if(!consumerRepository.existsByEmail(loginRequest.getEmail())){
            throw new EmailNotValidException();
        }
        Optional<Consumer> consumer=consumerRepository.findOptionalByEmail(loginRequest.getEmail());

        if(!HashPassword.encrypt(loginRequest.getPassword()).equals(consumer.get().getPassword())){
            throw new PasswordLoginException();
        }
        Optional<String> token=jwtManager.createToken(consumer.get().getId(),consumer.get().getEmail());

        BaseTokenResponse baseTokenResponse=new BaseTokenResponse();
        baseTokenResponse.setToken(token.get());
        baseTokenResponse.setMessage("Giriş yapıldı");
        baseTokenResponse.setStatusCode(200);


        return baseTokenResponse;
    }

    public Optional<Consumer> findById(String id){
            return consumerRepository.findById(id);
    }

    public Optional<Consumer> findOptionalByEmail(String email){
            return consumerRepository.findOptionalByEmail(email);
    }

    public void saveConsumer(Consumer consumer){
            consumerRepository.save(consumer);
    }


    public List<Consumer> getAllStudent(){
        return consumerRepository.getAllStudents();
    }


    public boolean isExistById(String id) {
        return consumerRepository.existsById(id);
    }

    public void changeConsumerInfo(Consumer consumer) {
            consumerRepository.save(consumer);
    }

    public List<Consumer> getAllTeacher() {
        return consumerRepository.getAllTeacher();
    }
}
