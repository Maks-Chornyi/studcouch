package com.studcouch.studcouch.statics;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Hashtags {

    WHO_WITH_ME("хто_зі_мною"),
    NEED_HOST("потрібна_вписка"),
    CAN_HOST("можу_вписати"),
    HAVE_QUESTION("є_питання"),
    HELLO_FROM("привіт_з"),
    TRAVEL_DIARY("щоденник_подорожі"),
    LOOKING_FOR_COMPANY("шукаю_компанію"),
    SHOW_CITY("покажіть_місто"),
    CAN_SHOW_CITY("покажу_місто");

    private String text;

    Hashtags(String text) {
        this.text = text;
    }
}
