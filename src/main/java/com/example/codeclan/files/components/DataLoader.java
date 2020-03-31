package com.example.codeclan.files.components;

import com.example.codeclan.files.models.File;
import com.example.codeclan.files.models.Folder;
import com.example.codeclan.files.models.User;
import com.example.codeclan.files.repositories.FileRepository;
import com.example.codeclan.files.repositories.FolderRepository;
import com.example.codeclan.files.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {
        User francesca = new User("Francesca");
        userRepository.save(francesca);
        User jay = new User("Jay");
        userRepository.save(jay);
        Folder photos = new Folder("Photos", francesca);
        folderRepository.save(photos);
        Folder videos = new Folder("Videos", francesca);
        folderRepository.save(videos);
        Folder documents = new Folder("Documents", jay);
        folderRepository.save(documents);
        File profilePhoto = new File("ProfilePhoto", "jpg", 100, photos);
        fileRepository.save(profilePhoto);
        File birthdayParty = new File("BirthdayParty","mp4", 5000, videos);
        fileRepository.save(birthdayParty);
        File flowerPic = new File("flower", "png", 300, photos);
        fileRepository.save(flowerPic);
        File drivingLicence = new File("DrivingLicence","jpg", 250, documents);
        fileRepository.save(drivingLicence);
        File resume = new File("cv","doc", 150, documents);
        fileRepository.save(resume);

    }
}
