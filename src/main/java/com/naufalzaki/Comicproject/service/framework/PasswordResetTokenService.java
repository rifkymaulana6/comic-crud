package com.naufalzaki.Comicproject.service.framework;

import com.naufalzaki.Comicproject.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}

