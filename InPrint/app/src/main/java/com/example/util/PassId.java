package com.example.util;

public class PassId {

    String website, email, password;

    public static void main(String[] args) {
        System.out.println(
                PassId.buildJson(
                    PassId.buildFragment("facebook", "a@gmail.com", "hunter2"),
                        PassId.buildFragment("github", "b@hotmail.com", "******"),
                        PassId.buildFragment("facebook", "c@gmail.com", "hunter213r24hutye65trgefc2"),
                        PassId.buildFragment("facebook", "ddddddddddd@gmail.com", "hunter2222")
                )
        );
    }

    public PassId(String site, String mail, String pass) {
        website = site;
        email = mail;
        password = pass;
    }

    @Override
    public String toString() {
        return String.format(
                "\"%s\" :{\n" +
                        "\t\"email\" : \"%s\",\n" +
                        "\t\"password\" : \"%s\"\n" +
                        "}",
                website, email, password
        );
    }

    public static String buildFragment(String site, String mail, String pass) {
        return String.format("\"%s\" :{\n" +
                "\t\"email\" : \"%s\",\n" +
                "\t\"password\" : \"%s\"\n" +
                "}",
        site, mail, pass);
    }

    public static String buildJson(String ... jsonSet) {
        String o = "{\n";
        for (int i = 0; i < jsonSet.length; ++i) {
            if (i != jsonSet.length - 1) {
                o += jsonSet[i] + ",\n";
            } else {
                o += jsonSet[i] + "\n";
            }
        }
        o += "}";
        return o;
    }
}
