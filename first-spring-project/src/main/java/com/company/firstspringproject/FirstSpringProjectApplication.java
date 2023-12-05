package com.company.firstspringproject;

import com.company.firstspringproject.model.constant.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class FirstSpringProjectApplication{

    private final AppConstant appConstant;


    public static void main(String[] args) {
        SpringApplication.run(FirstSpringProjectApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        try (FileChannel fileChannel = FileChannel.open(getFilePath())) {
//            String data = "testData";
//
//            ByteBuffer byteBuffer = ByteBuffer.wrap(data.getBytes());
//
//            int writeElementCount = fileChannel.write(byteBuffer);
//
//            System.out.println(writeElementCount + " written byte");
//        }
//    }

    private Path getFilePath() throws IOException {
        Path path = Path.of("logs", LocalDate.now().toString(), "app.txt");

        if (Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        if (Files.exists(path)) {
            Files.createFile(path);
        }
        return path;
    }


}
