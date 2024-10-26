package com.user.User.MicroService.service;

import com.user.User.MicroService.exception.ResourceNotFoundException;
import com.user.User.MicroService.model.Hotel;
import com.user.User.MicroService.model.Ratings;
import com.user.User.MicroService.model.User;
import com.user.User.MicroService.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        if(user.getUserId()==null)
        {
            String randomUserId = UUID.randomUUID().toString();
            user.setUserId(randomUserId);
        }
        //generate  unique userid

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        Ratings []ratingsArr =  restTemplate.getForObject("http://RATING-MICROSERVICE/ratings/users/" + user.getUserId(), Ratings[].class);
        List<Ratings> ratingsList = Arrays.stream(ratingsArr).collect(Collectors.toList());
        System.out.println("The ratings list is "+ratingsList);
        ratingsList = ratingsList.stream().map(r->
                {

                    Hotel h = restTemplate.getForObject("http://HOTEL-MICROSERVICE/hotels/"+r.getHotelId(), Hotel.class);
                    r.setHotel(h);
                    return r;
                }

                ).collect(Collectors.toList());
        user.setRatingsList(ratingsList);
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad


        return user;
    }

    @Override
    public User deleteUserByUserId(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
userRepository.deleteById(user.getUserId());

        return user;
    }
}
