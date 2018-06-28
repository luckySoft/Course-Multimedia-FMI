package com.cvmanager.backend.services;

import com.cvmanager.backend.exceptions.UserNotFoundException;
import com.cvmanager.backend.models.entity.*;
import com.cvmanager.backend.models.ui.*;
import com.cvmanager.backend.repository.UserRepository;
import com.cvmanager.backend.utils.DozerMapper;
import com.cvmanager.backend.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerMapper dozerMapper;

    public List<User> getUsers() throws IOException {
        Iterable<UserEntity> all = userRepository.findAll();
        List<User> returned = new ArrayList<>();
        all.forEach(eUser -> returned.add(copy(eUser)));
        return UserUtils.getAll();
    }

    public User getUser(String id) throws IOException, UserNotFoundException {
        return UserUtils.getUser(id);
    }

    private User copy(UserEntity eUser) {
        User user = dozerMapper.parseObject(eUser, User.class);
        user.setFavTechnologies(eUser.getFavTechnologies().stream()
                .map(FavTechnologyEntity::getFavTechnology).collect(Collectors.toList()));
        user.setEducation(dozerMapper.parseList(eUser.getEducationEntity(),
                Education.class));
        user.setExperience(dozerMapper.parseList(eUser.getExperienceEntity(),
                Experience.class));
        user.setLanguages(dozerMapper.parseList(eUser.getLanguageEntities(),
                Language.class));
        user.setSocialSkills(dozerMapper.parseList(eUser.getSocialSkillEntities(),
                SocialSkill.class));
        user.setDevSkills(dozerMapper.parseList(eUser.getSkillEntities(),
                Skill.class));
        return user;
    }

    public User addUser(User user) throws IOException {
        return UserUtils.addUser(user);
    }

    public User updateUser(User user) throws IOException, UserNotFoundException {
       return UserUtils.updateUser(user);
    }

    public List<User> getUserByName(String name) throws IOException {
        return UserUtils.findByName(name);
    }
}
