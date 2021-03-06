package com.epam.lab.spring.khokhliatskii.evernote.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Temporary class, doesn't encode anything.
 * Just passes the value.
 */
@Component
public class FakePasswordEncoder implements PasswordEncoder {
    /**
     * Encode the raw password.
     * This implementation is temporary.
     * Just returns the value of the source password.
     *
     * @param rawPassword - not encoded password.
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
