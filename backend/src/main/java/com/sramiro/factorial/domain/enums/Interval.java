package com.sramiro.factorial.domain.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Interval {
    MINUTE("minute"),
    HOUR("hour"),
    DAY("day");

    private final String interval;
}
