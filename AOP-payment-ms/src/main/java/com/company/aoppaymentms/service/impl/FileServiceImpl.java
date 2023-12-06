package com.company.aoppaymentms.service.impl;

import com.company.aoppaymentms.model.dto.request.PaymentTransferProcessRequestDto;
import com.company.aoppaymentms.model.dto.response.PaymentTransferProcessResponseDto;
import com.company.aoppaymentms.service.FileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    private static final Path path = Path.of("payments/payment.txt");

    @Override
    @SneakyThrows
    public void writeFile(PaymentTransferProcessResponseDto requestDto) {
        createPathAndFile();

        try {
            FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.APPEND);
            byte[] bytes = requestDto.toString().getBytes();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            int write = fileChannel.write(byteBuffer);
            log.info("written byte: {}",write);
            fileChannel.close();
        }catch (IOException e){
            log.error("Exception message: {}",e.getMessage());
        }


    }

    @SneakyThrows
    private void createPathAndFile() {
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            if (!Files.exists(path)){
                Files.createFile(path);
            }

    }
}
