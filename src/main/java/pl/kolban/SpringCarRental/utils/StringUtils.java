package pl.kolban.SpringCarRental.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Scope("singleton")
public class StringUtils {

    static final String CAR_PLATE_REGEX = "^[a-zA-Z0-9_]*$";

    public String checkSring(String verb) {
        if (!carPlateReg(verb)) {
            return "String contains illegar characters : " + verb;
        } else {
            verb = verb.toUpperCase();
        }
        return verb;
    }

    private boolean carPlateReg(String verb) {
        Pattern pattern = Pattern.compile(CAR_PLATE_REGEX);
        Matcher matcher = pattern.matcher(verb);
        boolean matches = matcher.matches();
        return matches;
    }
}
