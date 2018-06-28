package com.cvmanager.backend;

import com.cvmanager.backend.models.entity.*;
import com.cvmanager.backend.models.ui.User;
import com.cvmanager.backend.repository.UserRepository;
import com.cvmanager.backend.utils.DozerMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerMapper dozerMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static String read(String name) throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile("classpath:" + name).toPath()));
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = read("users.json");
        List<User> users = objectMapper.readValue(usersJson, new TypeReference<List<User>>() {
        });
        List<UserEntity> userEntities = dozerMapper.parseList(users, UserEntity.class);

        for (int i = 0; i < userEntities.size(); i++) {
            UserEntity userEntity = userEntities.get(i);
            User user = users.get(i);
            userEntity.getMainProfiles().forEach(mp -> mp.setUser(userEntity));
            userEntity.setFavTechnologies(user.getFavTechnologies().stream()
                    .map(tech -> {
                        FavTechnologyEntity favTechnologyEntity = new FavTechnologyEntity();
                        favTechnologyEntity.setFavTechnology(tech);
                        favTechnologyEntity.setUser(userEntity);
                        return favTechnologyEntity;
                    }).collect(Collectors.toList()));
            userEntity.setEducationEntity(dozerMapper.parseList(user.getEducation(),
                    EducationEntity.class));
            for (int j = 0; j < userEntity.getEducationEntity().size(); j++) {
                userEntity.getEducationEntity().get(j).setUser(userEntity);
                userEntity.getEducationEntity().get(j)
                        .setPeriodEntity(dozerMapper.parseObject(user.getEducation().get(j).getPeriod(),
                                PeriodEntity.class));
            }
            userEntity.setExperienceEntity(dozerMapper.parseList(user.getExperience(),
                    ExperienceEntity.class));
            for (int j = 0; j < userEntity.getExperienceEntity().size(); j++) {
                ExperienceEntity experienceEntity = userEntity.getExperienceEntity().get(j);
                experienceEntity.setUser(userEntity);
                experienceEntity.setPeriodEntity(dozerMapper.parseObject(user.getExperience().get(j).getPeriod(),
                                PeriodEntity.class));
                experienceEntity.setProjectIds(user.getExperience().get(j).getProjectIds().stream()
                                .map(projectId -> {
                                    ProjectIdEntity projectIdEntity = new ProjectIdEntity();
                                    projectIdEntity.setProjectId(projectId);
                                    projectIdEntity.setExperience(experienceEntity);
                                    return projectIdEntity;
                                }).collect(Collectors.toList()));
                experienceEntity
                        .setResponsibilities(user.getExperience().get(j).getResponsibilities().stream()
                                .map(responsibility -> {
                                    ResponsibilityEntity resp = new ResponsibilityEntity();
                                    resp.setResponsibility(responsibility);
                                    resp.setExperience(experienceEntity);
                                    return resp;
                                }).collect(Collectors.toList()));
                experienceEntity
                        .setTechnologies(user.getExperience().get(j).getTechnologies().stream()
                                .map(tech -> {
                                    TechnologyEntity techEntity = new TechnologyEntity();
                                    techEntity.setTechnology(tech);
                                    techEntity.setExperience(experienceEntity);
                                    return techEntity;
                                }).collect(Collectors.toList()));
            }
            userEntity.setLanguageEntities(dozerMapper.parseList(user.getLanguages(),
                    LanguageEntity.class));
            userEntity.getLanguageEntities().forEach(lang -> lang.setUser(userEntity));
            userEntity.setSocialSkillEntities(dozerMapper.parseList(user.getSocialSkills(),
                    SocialSkillEntity.class));
            userEntity.getSocialSkillEntities().forEach(ss -> ss.setUser(userEntity));
            userEntity.setSkillEntities(dozerMapper.parseList(user.getDevSkills(),
                    SkillEntity.class));
            userEntity.getSkillEntities().forEach(s -> s.setUser(userEntity));
        }
//        userRepository.save(userEntities);
    }
}
