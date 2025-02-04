package com.defold.extender;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class WhitelistConfig {
    public Map<String, Object> context = new HashMap<>();

    // Used to verify C++ defines before adding them on the command line
    // DEFINE
    // DEFINE=
    // DEFINE=123value
    public String defineRe = "^([A-Za-z_][A-Za-z0-9_]+)(|=|=[A-Za-z0-9_]+)$";
    public String libraryRe = "(\\w[\\w\\.+-]*)";

    public WhitelistConfig() {
        context.put("arg", "[a-zA-Z][a-zA-Z0-9-_]+");
        context.put("comma_separated_arg", "[a-zA-Z][a-zA-Z0-9-_]+");
        context.put("number", "[0-9]+");
        context.put("warning", "[a-zA-Z][a-zA-Z0-9-_+]+");
    }

    static Pattern compile(String re) {
        return Pattern.compile(String.format("^(%s)$", re));
    }
}
