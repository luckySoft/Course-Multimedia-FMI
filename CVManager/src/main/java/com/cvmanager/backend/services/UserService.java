package com.cvmanager.backend.services;

import com.cvmanager.backend.exceptions.UserNotFoundException;
import com.cvmanager.backend.models.entity.*;
import com.cvmanager.backend.models.ui.*;
import com.cvmanager.backend.repository.*;
import com.cvmanager.backend.utils.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private FavTechnologyRepository favTechnologyRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SocialSkillRepository socialSkillRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private ResponsibilitiesRepository responsibilitiesRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private DozerMapper dozerMapper;

    public List<User> getUsers() {
        Iterable<UserEntity> all = userRepository.findAll();
        List<User> returned = new ArrayList<>();
        all.forEach(eUser -> returned.add(copy(eUser)));
        return returned;
    }

    public User getUser(String id) {
        return copy(userRepository.findOne(Long.parseLong(id)));
    }

    public User addUser(User user) {
        userRepository.save(copy(user));
        return user;
    }

    public User updateUser(User user) throws UserNotFoundException {
        UserEntity one = userRepository.findOne(Long.valueOf(user.getId()));
        if (one == null) {
            throw new UserNotFoundException("User not Found");
        }
        userRepository.save(copy(user));
        return user;
    }

    public List<User> getUserByName(String name) {
        List<UserEntity> userEntities = userRepository.findByNameContaining(name);
        return userEntities.stream().map(this::copy).collect(Collectors.toList());
    }

    private User copy(UserEntity eUser) {
        User user = dozerMapper.parseObject(eUser, User.class);
        user.setFavTechnologies(eUser.getFavTechnologies().stream()
                .map(FavTechnologyEntity::getFavTechnology).collect(Collectors.toList()));
        user.setEducation(dozerMapper.parseList(eUser.getEducationEntity(),
                Education.class));
        for (int i = 0; i < eUser.getEducationEntity().size(); i++) {
            EducationEntity educationEntity = eUser.getEducationEntity().get(i);
            Education education = user.getEducation().get(i);
            education.setPeriod(new Period(educationEntity.getFromDate(), educationEntity.getToDate()));
        }

        user.setExperience(dozerMapper.parseList(eUser.getExperienceEntity(),
                Experience.class));
        for (int i = 0; i < eUser.getExperienceEntity().size(); i++) {
            ExperienceEntity experienceEntity = eUser.getExperienceEntity().get(i);
            Experience experience = user.getExperience().get(i);
            experience.setPeriod(new Period(experienceEntity.getFromDate(), experienceEntity.getToDate()));
            experience.setTechnologies(experienceEntity.getTechnologies().stream()
                    .map(TechnologyEntity::getTechnology)
                    .collect(Collectors.toList()));
            experience.setResponsibilities(experienceEntity.getResponsibilities().stream()
                    .map(ResponsibilityEntity::getResponsibility)
                    .collect(Collectors.toList()));
            experience.setProjectIds(experienceEntity.getProjectIds().stream()
                    .map(ProjectIdEntity::getProjectId)
                    .collect(Collectors.toList()));
        }

        user.setLanguages(dozerMapper.parseList(eUser.getLanguageEntities(),
                Language.class));
        user.setSocialSkills(dozerMapper.parseList(eUser.getSocialSkillEntities(),
                SocialSkill.class));
        user.setDevSkills(dozerMapper.parseList(eUser.getSkillEntities(),
                Skill.class));
        return user;
    }

    public UserEntity copy(User user) {
        UserEntity userEntity = dozerMapper.parseObject(user, UserEntity.class);
        List<AvatarEntity> mainProfiles = user.getMainProfiles().stream().map(avatar -> {
            AvatarEntity avatarEntity = new AvatarEntity();
            avatarEntity.setImg(avatar.getImg());
            avatarEntity.setMain(avatar.getMain().toString());
            avatarEntity.setUser(userEntity);
            return avatarEntity;
        }).collect(Collectors.toList());
        userEntity.setMainProfiles(mainProfiles);
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
            userEntity.getEducationEntity().get(j).setFromDate(user.getEducation().get(j).getPeriod().getFrom());
            userEntity.getEducationEntity().get(j).setToDate(user.getEducation().get(j).getPeriod().getTo());
            userEntity.getEducationEntity().get(j).setEduUrl(user.getEducation().get(j).getUrl());
        }
        userEntity.setExperienceEntity(dozerMapper.parseList(user.getExperience(),
                ExperienceEntity.class));

        for (int j = 0; j < userEntity.getExperienceEntity().size(); j++) {
            ExperienceEntity experienceEntity = userEntity.getExperienceEntity().get(j);
            experienceEntity.setUser(userEntity);
            experienceEntity.setFromDate(user.getExperience().get(j).getPeriod().getFrom());
            experienceEntity.setToDate(user.getExperience().get(j).getPeriod().getTo());
            experienceEntity.setExpUrl(user.getExperience().get(j).getUrl());
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

        userRepository.save(userEntity);
        avatarRepository.save(userEntity.getMainProfiles().stream()
                .collect(Collectors.toList()));
        experienceRepository.save(userEntity.getExperienceEntity().stream()
                .collect(Collectors.toList()));
        technologyRepository.save(userEntity.getExperienceEntity().stream()
                .flatMap(experienceEntity -> experienceEntity.getTechnologies().stream())
                .collect(Collectors.toList()));
        responsibilitiesRepository.save(userEntity.getExperienceEntity().stream()
                .flatMap(experienceEntity -> experienceEntity.getResponsibilities().stream())
                .collect(Collectors.toList()));
        projectsRepository.save(userEntity.getExperienceEntity().stream()
                .flatMap(experienceEntity -> experienceEntity.getProjectIds().stream())
                .collect(Collectors.toList()));
        educationRepository.save(userEntity.getEducationEntity().stream()
                .collect(Collectors.toList()));
        languageRepository.save(userEntity.getLanguageEntities().stream()
                .collect(Collectors.toList()));
        favTechnologyRepository.save(userEntity.getFavTechnologies().stream()
                .collect(Collectors.toList()));
        skillRepository.save(userEntity.getSkillEntities().stream()
                .collect(Collectors.toList()));
        socialSkillRepository.save(userEntity.getSocialSkillEntities().stream()
                .collect(Collectors.toList()));
        return userEntity;
    }
}
