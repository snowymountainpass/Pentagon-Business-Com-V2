package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.repository.ConfirmationTokenRepository;
import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token){
       return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

}
