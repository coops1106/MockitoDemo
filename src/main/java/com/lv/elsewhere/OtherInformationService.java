package com.lv.elsewhere;

public interface OtherInformationService {

    public String getLvEmailAddress();

    public String getLvName();

    public String getForgottenPasswordEmailSubject();

    public String getForgottenPasswordEmailText(String resetLink);

}
