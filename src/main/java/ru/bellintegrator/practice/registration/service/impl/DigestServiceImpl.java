package ru.bellintegrator.practice.registration.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bellintegrator.practice.registration.service.DigestService;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DigestServiceImpl implements DigestService {
    private static final Logger log = LoggerFactory.getLogger(DigestServiceImpl.class);

    @Override
    public String hash(String source) {
        try {
            MessageDigest encoder = MessageDigest.getInstance("SHA-256");
            byte[] digest = encoder.digest(source.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(digest));
        } catch (NoSuchAlgorithmException e) {
            log.error("Unsupported hashing algorithm:" + "SHA-256", e);
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported encoding:" + "UTF-8", e);
            throw new RuntimeException(e);
        }
    }
}
