package com.example.email.test;

import com.example.email.entity.Staff;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaffUtills {
    public static String getPassword(String cardNo){
        String substring = cardNo.substring(cardNo.length() - 6, cardNo.length());
        return substring;
    };
    public static  String getUserName(String nameAll,String cardNo){
        String substring = cardNo.substring(cardNo.length() - 6, cardNo.length());
        Map<String, String> stringStringMap = changeChinese2Pinyin(nameAll);
        String simplePinyin = stringStringMap.get("simplePinyin");
        return simplePinyin+substring;
    }
    public static Map<String, String> changeChinese2Pinyin(String chinese) {
        Map<String, String> pinyin = new HashMap<String, String>();

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        StringBuffer fullPinyin = new StringBuffer();
        StringBuffer simplePinyin = new StringBuffer();
        char[] chineseChar = chinese.toCharArray();
        for (int i = 0; i < chineseChar.length; i++) {
            String[] str = null;
            try {
                str = PinyinHelper.toHanyuPinyinStringArray(chineseChar[i],
                        format);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (str != null) {
                fullPinyin = fullPinyin.append(str[0].toString());
                simplePinyin = simplePinyin.append(str[0].charAt(0));
            }
            if (str == null) {
                String regex = "^[0-9]*[a-zA-Z]*+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(String.valueOf(chineseChar[i]));
                if (m.find()) {
                    fullPinyin = fullPinyin.append(chineseChar[i]);
                    simplePinyin = simplePinyin.append(chineseChar[i]);
                }
            }
        }
        pinyin.put("fullPinyin", fullPinyin.toString());
        pinyin.put("simplePinyin", simplePinyin.toString().toLowerCase());

        return pinyin;
    }

    public static String getEmail(String username) {
        return username+"@"+"test.com";
    }
}
