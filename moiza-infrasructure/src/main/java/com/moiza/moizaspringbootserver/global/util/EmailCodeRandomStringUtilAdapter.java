package com.moiza.moizaspringbootserver.global.util;

import com.moiza.moizaspringbootserver.auth.spi.EmailCodeRandomStringSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Adapter
public class EmailCodeRandomStringUtilAdapter implements EmailCodeRandomStringSpi {

    @Override
    public String getEmailAuthCode() {
        List<Character> codeList = new ArrayList<>();
        List<String> authCodeList = new ArrayList<>();
        SecureRandom random = new SecureRandom();

        codeList.add('1');
        codeList.add('2');
        codeList.add('3');
        codeList.add('4');
        codeList.add('5');
        codeList.add('6');
        codeList.add('7');
        codeList.add('8');
        codeList.add('9');
        codeList.add('0');

        for (int i = 0; i < 6; i++) {
            authCodeList.add(i, codeList.get(random.nextInt(10)).toString());
        }

        return authCodeList.toString().replaceAll("[^0-9]","");
    }
}
